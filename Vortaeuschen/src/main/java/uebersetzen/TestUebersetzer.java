package uebersetzen;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class TestUebersetzer {
	@Test
	public void testeUebersetzer() {

		// mockt die Klasse Uebersetzer
		Uebersetzer mockUebersetzer = Mockito.mock(Uebersetzer.class);
		
		// der Mock übersetzt "Welt" mit "World"
		Mockito.when(mockUebersetzer.uebersetze("Welt")).thenReturn("World");
		
		// erzeugt die Uebersetzerschnittstelle mit dem Mock
		UebersetzerSchnittstelle zuTesten = new UebersetzerSchnittstelle();
		
		// testet die Uebersetzerschnittstelle mit dem Mock
		String uebersetzung = zuTesten.uebersetze(mockUebersetzer, "Welt");
		
		// prueft, ob das Ergebnis korrekt ist
		Assert.assertTrue(uebersetzung.equals("World"));
	}
}