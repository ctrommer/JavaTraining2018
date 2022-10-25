package regeln;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class TestTemporaryFolder {

	/**
	 * Erzeugt temporaeren Ordner fuer Test in dem gleichen Verzeichnis, in dem
	 * quellDatei.xml liegt.
	 */
	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder(new File("src\\regeln"));

	public File testeTemporaryFolder() throws IOException{

		String textInDatei = "Dieser Text wird in die temporaere Datei geschrieben";
		
		// Erzeuge Datei in temporaerem Ordner
		
		// Schreibe Text in die Datei
		
		return null;			

	}

	@Test
	public void testeTesteTemporaryFolder() throws IOException{
		File zielDatei = testeTemporaryFolder();
		assertTrue(zielDatei.getPath().startsWith("src\\regeln"));
		try (Stream<String> lines = Files.lines(Paths.get(zielDatei.getPath()))) {
			assertTrue(  lines.findFirst().orElse("falscher Text").equals("Dieser Text wird in die temporaere Datei geschrieben") );
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		};
	}
	
	public File testeAlternativeZuTemporaryFolder() throws IOException {

		// Lese die Datei quellDatei.xml ein als Stream von Strings.

		// Erzeuge eine temporaere Datei im gleichen Pfad, aber ohne TemporaryFolder
		 
		
		// damit Datei am Ende wieder geloescht wird
		

		// Schreibe das, was aus der Datei quellDatei.xml ausgelesen wurde in die
		// temporaere Datei
		
		
		
		return null;
	}

	@Test
	public void testeTesteAlternativeZuTemporaryFolder( ) throws IOException {
		File erzeugteDatei = testeAlternativeZuTemporaryFolder();
		assertTrue(erzeugteDatei.getPath().startsWith("src\\regeln"));
		try ( Stream<String> zuTesten = Files.lines(Paths.get(erzeugteDatei.getPath())) ) {
			Stream<String> erwartet = Stream.of("erste Zeile", "zweite Zeile", "dritte Zeile" );
			Iterator<String> iterZuTesten = zuTesten.iterator();
			Iterator<String> iteratorErwartet = erwartet.iterator();
			while ( iterZuTesten.hasNext() && iteratorErwartet.hasNext() ) {
				assertEquals(iterZuTesten.next(), iteratorErwartet.next() );
			}
			assertFalse(iterZuTesten.hasNext());
			assertFalse(iteratorErwartet.hasNext());

		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
}