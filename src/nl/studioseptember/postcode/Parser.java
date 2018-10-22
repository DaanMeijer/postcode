package nl.studioseptember.postcode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import nl.kadaster.schemas.bag_verstrekkingen.extract_deelbestand_lvc.v20090901.BAGExtractDeelbestandLVC;
import nl.kadaster.schemas.bag_verstrekkingen.extract_deelbestand_lvc.v20090901.BAGExtractDeelbestandLVC.Antwoord;
import nl.kadaster.schemas.bag_verstrekkingen.extract_producten_lvc.v20090901.LVCProduct;
import nl.studioseptember.postcode.type.Nummer;
import nl.studioseptember.postcode.type.OpenbareRuimte;
import nl.studioseptember.postcode.type.Polygon;
import nl.studioseptember.postcode.type.Woonplaats;

public class Parser {

	final static Logger LOG = Logger.getLogger(Parser.class);
	
	private static Date start = new Date();
	
	public static void main(String[] args) throws JAXBException, IOException {

		Locale.setDefault(Locale.ENGLISH);
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		//NummerRepository repository = context.getBean(NummerRepository.class);
		
		
		LOG.info("Starting");
		
		var files = new File[] {
				new File("var/9999WPL08092018.zip"),
//				new File("var/9999OPR08092018.zip"),
//				new File("var/9999NUM08092018.zip"),
		};
		
		for(File file: files) {
			parseZip(file);
		}
		
		LOG.info("Persisting");
		
		SessionFactory sessionFactory = context.getBean(SessionFactory.class);

		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		for(Woonplaats woonplaats: woonplaatsen.values()) {
			for(Polygon polygon: woonplaats.getSurface()) {
				session.persist(polygon);
			}
			session.persist(woonplaats);
		}
		

		for(OpenbareRuimte openbareRuimte: openbareRuimtes.values()) {
			session.persist(openbareRuimte);
		}
		
		for(Nummer nummer: nummers.values()) {
			session.persist(nummer);
		}
		tx.commit();
		
		
		LOG.info("Done.");
	}
	private static Map<Long, Woonplaats> woonplaatsen = new HashMap<Long, Woonplaats>();
	private static Map<Long, OpenbareRuimte> openbareRuimtes = new HashMap<Long, OpenbareRuimte>();
	private static Map<Long, Nummer> nummers = new HashMap<Long, Nummer>();
	
	private static void parseZip(File zip) throws JAXBException, IOException {
		ZipInputStream zis = new ZipInputStream(new FileInputStream(zip));
		ZipEntry entry;
		while((entry = zis.getNextEntry()) != null) {
			if(entry.getName().endsWith(".xml")) {
				LOG.info("Parsing " + entry.getName());
				var product = parseLVCProduct(zis);
				LOG.info("Parsed " + entry.getName());
				
				parseWoonplaatsen(product);
				
				LOG.info("Have woonplaatsen: " + woonplaatsen.size());
				
				parseOpenbareRuimtes(product);
				
				LOG.info("Have openbare ruimtes: " + openbareRuimtes.size());
				
				parseNummers(product);
				LOG.info("Have nummers: " + nummers.size());
			}else {
				LOG.info("Skipping " + entry.getName());
			}
		}
	}
	
	private static void parseOpenbareRuimtes(LVCProduct product) {
		for (var openbareRuimte: product.getOpenbareRuimte()) {
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
		int count = 0;
		for (var woonplaats : product.getWoonplaats()) {
			count++;
			Woonplaats parsed = new Woonplaats(woonplaats);
			woonplaatsen.put(parsed.getIdentificatie(), parsed);
			if(count >= 1)
				break;
		}
		
	}
}
