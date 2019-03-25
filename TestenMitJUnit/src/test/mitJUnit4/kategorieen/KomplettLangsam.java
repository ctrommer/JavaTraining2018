package test.mitJUnit4.kategorieen;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({ KategorieLangsameTests.class })
public class KomplettLangsam {
	@Test
	public void langsamerTest1() {
		System.out.println("Klasse: KomplettLangsam | Methode: langsamerTest 1");
	}
	@Test
	public void langsamerTest2() {
		System.out.println("Klasse: KomplettLangsam | Methode: langsamerTest 2");
	}		
}
