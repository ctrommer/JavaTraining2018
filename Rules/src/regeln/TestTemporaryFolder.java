package regeln;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class TestTemporaryFolder {
	
	/**
	 * Erzeugt temporären Ordner für Test.
	 */
	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();
	
	/**
	 * Erzeuge Datei in temmporärem Ordner und gebe den Pfad aus.
	 */
	@Test
	public void testeTemporaryFolder() {
		try {
			File file = temporaryFolder.newFile("MyTest.txt");
			System.out.println(file.getPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}