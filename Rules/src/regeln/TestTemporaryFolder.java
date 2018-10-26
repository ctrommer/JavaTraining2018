package regeln;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class TestTemporaryFolder {
	
	/**
	 * Erzeugt tempor�ren Ordner f�r Test.
	 */
	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();
	
	/**
	 * Erzeuge Datei in temmpor�rem Ordner und gebe den Pfad aus.
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