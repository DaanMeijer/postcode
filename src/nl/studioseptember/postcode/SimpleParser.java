package nl.studioseptember.postcode;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import javax.xml.bind.JAXBException;

public class SimpleParser extends Parser {
	
	public static void main(String[] args) throws JAXBException, IOException {

		Locale.setDefault(Locale.ENGLISH);

		Parser parser = new SimpleParser();
		
		LOG.info("Starting");

		var files = new File[] { 
				new File("var/9999WPL08102018.zip"),
				new File("var/9999OPR08102018.zip"),
				new File("var/9999LIG08102018.zip"),
				new File("var/9999STA08102018.zip"),
				new File("var/9999VBO08102018.zip"),
				new File("var/9999NUM08102018.zip"),
				new File("var/9999PND08102018.zip"),
		};

		for (File file : files) {
			parser.parseZip(file);
		}
		parser.persist();
		
		LOG.info("Done.");
	}
	
}
