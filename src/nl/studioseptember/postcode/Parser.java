package nl.studioseptember.postcode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import nl.studioseptember.postcode.type.BaseInterface;
import nl.studioseptember.postcode.type.Nummer;
import nl.studioseptember.postcode.type.OpenbareRuimte;
import nl.studioseptember.postcode.type.Pand;
import nl.studioseptember.postcode.type.VerblijfsObject;
import nl.studioseptember.postcode.type.Woonplaats;

public class Parser {

	final static Logger LOG = Logger.getLogger(Parser.class);

	public static void main(String[] args) throws JAXBException, IOException {

		Locale.setDefault(Locale.ENGLISH);

		Parser parser = new Parser();
		
		LOG.info("Starting");

		var files = new File[] { 
				new File("var/9999WPL08102018.zip"),
//				new File("var/9999OPR08102018.zip"),
//				new File("var/9999LIG08102018.zip"),
//				new File("var/9999STA08102018.zip"),
//				new File("var/9999VBO08102018.zip"),
//				new File("var/9999NUM08102018.zip"),
//				new File("var/9999PND08102018.zip"),
		};

		for (File file : files) {
			parser.parseZip(file);
		}
		parser.persist();
		
		LOG.info("Done.");
	}

	private SessionFactory sessionFactory;
	private EntityManager entityManager;
	
	public Parser() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		sessionFactory = context.getBean(SessionFactory.class);
		

		Session session = sessionFactory.openSession();

		EntityManagerFactory entityManagerFactory = session.getEntityManagerFactory();
		

		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public void finalize(){
		if (entityManager != null) {
			entityManager.close();
		}
		sessionFactory.close();
	}
	
	protected void persist() {
		

		LOG.info("Persisting");

		


		batchPersist(woonplaatsen.values());
		batchPersist(openbareRuimtes.values());
		batchPersist(nummers.values());
		batchPersist(panden.values());
		batchPersist(verblijfsobjecten.values());
		
		woonplaatsen.clear();
		openbareRuimtes.clear();
		nummers.clear();
		panden.clear();
		verblijfsobjecten.clear();
		
	}
	
	private void batchPersist(Collection<? extends Base> entities) {
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
			
			LOG.info("Flushing...");
			txn.commit();
			LOG.info("Flushed...");
			

		} catch (RuntimeException e) {
			if (txn != null && txn.isActive())
				txn.rollback();
			throw e;
		}
	}

	private Map<Long, Woonplaats> woonplaatsen = new HashMap<Long, Woonplaats>();
	private Map<Long, OpenbareRuimte> openbareRuimtes = new HashMap<Long, OpenbareRuimte>();
	private Map<Long, Nummer> nummers = new HashMap<Long, Nummer>();
	private Map<Long, VerblijfsObject> verblijfsobjecten = new HashMap<Long, VerblijfsObject>();
	private Map<Long, Pand> panden = new HashMap<Long, Pand>();

	static int MAX_FILES_PER_ZIP = Integer.MAX_VALUE;
	
	protected void parseZip(File zip) throws JAXBException, IOException {

		int total = 0;
		/*
		final ZipFile file = new ZipFile( zip );
		
		try
		{
		    final Enumeration<? extends ZipEntry> entries = file.entries();
		    while ( entries.hasMoreElements() )
		    {
		        final ZipEntry entry = entries.nextElement();
		        total++;
		    }
		}
		finally
		{
		    file.close();
		}*/
		
		ZipInputStream zis = new ZipInputStream(new FileInputStream(zip));
		
		
		ZipEntry entry;
		int count = 0;
		while (count < MAX_FILES_PER_ZIP && (entry = zis.getNextEntry()) != null) {
			count++;
			if (entry.getName().endsWith(".xml")) {
				LOG.info("Parsing " + entry.getName() + " ("+count+"/"+total+")");
				var product = parseLVCProduct(zis);
				LOG.info("Parsed " + entry.getName());

				parseWoonplaatsen(product);

//				LOG.info("Have woonplaatsen: " + woonplaatsen.size());

				parseOpenbareRuimtes(product);

//				LOG.info("Have openbare ruimtes: " + openbareRuimtes.size());

				parseNummers(product);
//				LOG.info("Have nummers: " + nummers.size());

				parsePanden(product);
//				LOG.info("Have panden: " + panden.size());

				parseVerblijfsObjecten(product);
//				LOG.info("Have verblijfsobjecten: " + verblijfsobjecten.size());
//				LOG.info("Have objects: " + (
//						woonplaatsen.size() + 
//						openbareRuimtes.size() + 
//						nummers.size() + 
//						verblijfsobjecten.size() + 
//						panden.size()
//				));
				
//				persist();
			} else {
				LOG.info("Skipping " + entry.getName());
			}
		}
	}
	
	private void parsePanden(LVCProduct product) throws IOException {
		for (var pand : product.getPand()) {
			var parsed = new Pand(pand);
			panden.put(parsed.getIdentificatie(), parsed);
		}
	}

	private void parseOpenbareRuimtes(LVCProduct product) {
		for (var openbareRuimte : product.getOpenbareRuimte()) {
			var parsed = new OpenbareRuimte(openbareRuimte);
			openbareRuimtes.put(parsed.getIdentificatie(), parsed);
		}
	}

	private void parseNummers(LVCProduct product) {
		for (var nummer : product.getNummeraanduiding()) {
			var parsed = new Nummer(nummer);
			nummers.put(parsed.getIdentificatie(), parsed);
		}
	}

	private LVCProduct parseLVCProduct(InputStream stream) throws JAXBException, IOException {
		JAXBContext jaxbContext = JAXBContext.newInstance(BAGExtractDeelbestandLVC.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		BAGExtractDeelbestandLVC deelbestand = (BAGExtractDeelbestandLVC) jaxbUnmarshaller
				.unmarshal(new NonClosingInputStream(stream));

		Antwoord antwoord = deelbestand.getAntwoord();

		LVCProduct product = antwoord.getProducten().getLVCProduct();
		return product;
	}

	private void parseWoonplaatsen(LVCProduct product) throws IOException {
		for (var woonplaats : product.getWoonplaats()) {
			Woonplaats parsed = new Woonplaats(woonplaats);
			woonplaatsen.put(parsed.getIdentificatie(), parsed);
		}

	}

	private void parseVerblijfsObjecten(LVCProduct product) throws IOException {
		for (var verblijfsobject : product.getVerblijfsobject()) {
			VerblijfsObject parsed = new VerblijfsObject(verblijfsobject);
			verblijfsobjecten .put(parsed.getIdentificatie(), parsed);
		}
		
		for (var ligplaats : product.getLigplaats()) {
			VerblijfsObject parsed = new VerblijfsObject(ligplaats);
			verblijfsobjecten .put(parsed.getIdentificatie(), parsed);
		}
		
		for (var standplaats : product.getStandplaats()) {
			VerblijfsObject parsed = new VerblijfsObject(standplaats);
			verblijfsobjecten .put(parsed.getIdentificatie(), parsed);
		}
		
		

	}
}
