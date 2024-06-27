package batch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class TesteApp {

	private void wurdeDateiAktualisiert( Instant startVonTest, Path erzeugteDatei ) {
		try {
			assertTrue( 
					Files.getLastModifiedTime( erzeugteDatei )
													.toInstant()
													.isAfter( startVonTest ), 
					"Zieldatei wurde nicht geschrieben." );
		} catch (IOException e) {
			e.printStackTrace();
			Assertions.assertFalse( 
					false, 
					"Es konnte nicht ermittelt werden, wann die Datei geschrieben wurde." );
		}
	}

	private void pruefeWerteInDatei( 
								String dateiPfad,
								List<String> erwarteteGewichte,
								List<String> erwarteteMitarbeiterIds,
								List<String> erwarteteMitarbeiterNamen ) {
		Instant startVonTest = Instant.now();

		App.main( null );
		
		Path erzeugteDatei = Paths.get( dateiPfad );

		wurdeDateiAktualisiert( startVonTest, erzeugteDatei );
		
		try {
			Document xmLDocument = DocumentBuilderFactory
												.newInstance()
												.newDocumentBuilder()
												.parse( erzeugteDatei.toFile() );
						
			for ( int zeile = 0; 
					zeile < xmLDocument
									.getElementsByTagName("gewicht")
									.getLength(); 
					zeile++ ) {
				assertEquals( 
						erwarteteGewichte.get( zeile ), 
						xmLDocument
							.getElementsByTagName("gewicht")
							.item( zeile )
							.getTextContent() );
				assertEquals( 
						erwarteteMitarbeiterIds.get( zeile ), 
						xmLDocument
							.getElementsByTagName("mitarbeiterId")
							.item( zeile )
							.getTextContent() );
				assertEquals( 
						erwarteteMitarbeiterNamen.get( zeile ),
						xmLDocument
							.getElementsByTagName("mitarbeiterName")
							.item(zeile)
							.getTextContent() );
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
			Assertions.assertFalse( false , "Zeildatei Datei konnte nicht geparst werden." );
		}
	}

	@Test
	@DisplayName("Wurde die xml-Datei OHNE BusinessLogik geschrieben?")
	public void test01() {		
		String dateiPfad = "C:\\xml\\outputs\\mitarbeiter1.xml";
		List<String> erwarteteGewichte = List.of( "70", "100", "81" );
		List<String> erwarteteMitarbeiterIds =  List.of( "1001", "1002", "1003" );
		List<String> erwarteteMitarbeiterNamen = List.of( "Karl", "Arnold", "Walter" );
		pruefeWerteInDatei( 
				dateiPfad,
				erwarteteGewichte,
				erwarteteMitarbeiterIds,
				erwarteteMitarbeiterNamen );		
	}
	
	@Test
	@DisplayName("Wurde die xml-Datei MIT BusinessLogik geschrieben?")
	public void test02() {
		
		String dateiPfad = "C:\\xml\\outputs\\mitarbeiter2.xml";
		List<String> erwarteteGewichte = List.of( "154", "221", "179" );
		List<String> erwarteteMitarbeiterIds =  List.of( "1001", "1002", "1003" );
		List<String> erwarteteMitarbeiterNamen = List.of( "Karl", "Arnold", "Walter" );
		pruefeWerteInDatei( 
				dateiPfad,
				erwarteteGewichte,
				erwarteteMitarbeiterIds,
				erwarteteMitarbeiterNamen );		
	}

}
