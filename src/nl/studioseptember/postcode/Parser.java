package nl.studioseptember.postcode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import nl.kadaster.schemas.bag_verstrekkingen.extract_deelbestand_lvc.v20090901.BAGExtractDeelbestandLVC;
import nl.kadaster.schemas.bag_verstrekkingen.extract_deelbestand_lvc.v20090901.BAGExtractDeelbestandLVC.Antwoord;
import nl.kadaster.schemas.bag_verstrekkingen.extract_producten_lvc.v20090901.LVCProduct;
import nl.studioseptember.postcode.type.Base;
import nl.studioseptember.postcode.type.Nummer;
import nl.studioseptember.postcode.type.OpenbareRuimte;
import nl.studioseptember.postcode.type.VerblijfsObject;
import nl.studioseptember.postcode.type.Woonplaats;

public class Parser {

	final static Logger LOG = Logger.getLogger(Parser.class);

	private static Date start = new Date();

	public static void main(String[] args) throws JAXBException, IOException {

		Locale.setDefault(Locale.ENGLISH);

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		// NummerRepository repository = context.getBean(NummerRepository.class);

		LOG.info("Starting");

		var files = new File[] { 
//				new File("var/9999WPL08092018.zip"),
//				new File("var/9999OPR08092018.zip"),
//				new File("var/9999NUM08092018.zip"),
				new File("var/9999VBO08092018.zip"),
		};

		for (File file : files) {
			parseZip(file);
		}

		LOG.info("Persisting");

		SessionFactory sessionFactory = context.getBean(SessionFactory.class);

		Session session = sessionFactory.openSession();

		EntityManagerFactory entityManagerFactory = session.getEntityManagerFactory();

		batchPersist(woonplaatsen.values(), entityManagerFactory);
		batchPersist(openbareRuimtes.values(), entityManagerFactory);
		batchPersist(nummers.values(), entityManagerFactory);
		
		LOG.info("Done.");
	}
	
	private static void batchPersist(Collection<? extends Base> entities, EntityManagerFactory entityManagerFactory) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction txn = null;
		try {

			txn = entityManager.getTransaction();
			txn.begin();

			
			int batchSize = Math.min(5000, entities.size() / 10);

			int count = 0;
			for (Base entity : entities) {

				if (count > 0 && count % batchSize == 0) {
					// flush a batch of inserts and release memory
					entityManager.flush();
					entityManager.clear();

					LOG.info(String.format("Persisted [% 4d/% 4d] %s", count, entities.size(), entity.toString()));
				}
				count++;

				entityManager.persist(entity);
			}
			

			txn.commit();

		} catch (RuntimeException e) {
			if (txn != null && txn.isActive())
				txn.rollback();
			throw e;
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}

	private static Map<Long, Woonplaats> woonplaatsen = new HashMap<Long, Woonplaats>();
	private static Map<Long, OpenbareRuimte> openbareRuimtes = new HashMap<Long, OpenbareRuimte>();
	private static Map<Long, Nummer> nummers = new HashMap<Long, Nummer>();
	private static Map<Long, VerblijfsObject> verblijfsobjecten = new HashMap<Long, VerblijfsObject>();

	private static void parseZip(File zip) throws JAXBException, IOException {
		ZipInputStream zis = new ZipInputStream(new FileInputStream(zip));
		ZipEntry entry;
		while ((entry = zis.getNextEntry()) != null) {
			if (entry.getName().endsWith(".xml")) {
				LOG.info("Parsing " + entry.getName());
				var product = parseLVCProduct(zis);
				LOG.info("Parsed " + entry.getName());

				parseWoonplaatsen(product);

				LOG.info("Have woonplaatsen: " + woonplaatsen.size());

				parseOpenbareRuimtes(product);

				LOG.info("Have openbare ruimtes: " + openbareRuimtes.size());

				parseNummers(product);
				LOG.info("Have nummers: " + nummers.size());

				parseVerblijfsObjecten(product);
				LOG.info("Have verblijfsobjecten: " + verblijfsobjecten.size());
				
			} else {
				LOG.info("Skipping " + entry.getName());
			}
		}
	}

	private static void parseOpenbareRuimtes(LVCProduct product) {
		for (var openbareRuimte : product.getOpenbareRuimte()) {
			var parsed = new OpenbareRuimte(openbareRuimte, woonplaatsen);
			openbareRuimtes.put(parsed.getIdentificatie(), parsed);
		}
	}

	private static void parseNummers(LVCProduct product) {
		for (var nummer : product.getNummeraanduiding()) {
			var parsed = new Nummer(nummer, woonplaatsen, openbareRuimtes);
			nummers.put(parsed.getIdentificatie(), parsed);
		}
	}

	private static LVCProduct parseLVCProduct(InputStream stream) throws JAXBException, IOException {
		JAXBContext jaxbContext = JAXBContext.newInstance(BAGExtractDeelbestandLVC.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		BAGExtractDeelbestandLVC deelbestand = (BAGExtractDeelbestandLVC) jaxbUnmarshaller
				.unmarshal(new NonClosingInputStream(stream));

		Antwoord antwoord = deelbestand.getAntwoord();

		LVCProduct product = antwoord.getProducten().getLVCProduct();
		return product;
	}

	private static void parseWoonplaatsen(LVCProduct product) throws IOException {
		for (var woonplaats : product.getWoonplaats()) {
			Woonplaats parsed = new Woonplaats(woonplaats);
			woonplaatsen.put(parsed.getIdentificatie(), parsed);
		}

	}

	private static void parseVerblijfsObjecten(LVCProduct product) throws IOException {
		for (var verblijfsobject : product.getVerblijfsobject()) {
			VerblijfsObject parsed = new VerblijfsObject(verblijfsobject);
			verblijfsobjecten .put(parsed.getIdentificatie(), parsed);
		}

	}
}
