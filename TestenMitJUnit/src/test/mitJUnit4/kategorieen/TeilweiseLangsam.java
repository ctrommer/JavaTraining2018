package test.mitJUnit4.kategorieen;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TeilweiseLangsam {

	@Test
	public void ohneKategorie() {
		System.out.println("ohne Kategorie");
	}

	@Category( KategorieLangsameTests.class )
	@Test
	public void langsam() {
		System.out.println("Klasse: TeilweiseLangsam | Methode: langsam");
	}

}
