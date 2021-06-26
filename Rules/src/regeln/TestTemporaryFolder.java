package regeln;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class TestTemporaryFolder {
	
	/**
	 * Erzeugt temporären Ordner für Test.
	 */
	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder(new File("src\\regeln"));

	/**
	 * Erzeuge Datei in temporärem Ordner, schreibe Text in die Datei und gebe den Pfad der Datei aus.
	 */
	@Test
	public void testeTemporaryFolder() {
		try {
			File zielDatei = temporaryFolder.newFile("tempZielDatei.txt");
			String textInDatei = "Dieser Text wird in die temporaere Datei geschrieben";
			Files.write(Paths.get(zielDatei.getAbsolutePath()), textInDatei.getBytes(StandardCharsets.UTF_8) );
			System.out.println(zielDatei.getPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Lese die Datei quellDatei.xml ein als Stream von Strings.
	 * 
	 * Erzeuge eine temporäre Datei im gleichen Pfad, aber ohne TemporaryFolder
	 *
	 * Schreibe das, was aus der Datei quellDatei.xml ausgelesen wurde in die temporäre Datei 
	 * 
	 */
	@Test
	public void testeAlternativeZuTemporaryFolder() {
		try {
			// Datei einlesen
			Path verzeichnisUndDateinameQuelldatei = Paths.get("src\\regeln\\quellDatei.xml");
			Stream<String> zeilen = Files.lines(verzeichnisUndDateinameQuelldatei);

			// Datei im gleichen Pfad erzeugen
			File erzeugteDatei = new File("src\\regeln\\temp.xml");
			// damit Datei am Ende wieder geloescht wird
			erzeugteDatei.deleteOnExit();

		    // in neue Datei schreiben
			String verzeichnisUndDateinameZielDatei = erzeugteDatei.getAbsolutePath();
			Files.write(Paths.get(verzeichnisUndDateinameZielDatei), zeilen.collect(Collectors.toList()), StandardCharsets.UTF_8);

			zeilen.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}