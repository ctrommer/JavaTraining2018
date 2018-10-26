package uebersetzen;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * 
 * 1. Mockito downloaden: google | mockito download jar -> http://www.java2s.com/Code/Jar/m/Downloadmockitoall195jar.htm
 * 		Achtung: hatte vorher das mockito genommen, was ich schon hatte. Leider bekam ich dadurch eine ClassNotFoundException.
 * 
 * 2. Rechte Maus auf Projekt | Build Path | Configure Build Path | 
 * 		Libraries | Add external jar ... | mocktio ausw�hlen
 * 
 */
public class TestUebersetzer {
	@Test
	public void testeUebersetzer() {

		// mockt die Klasse Uebersetzer
		Uebersetzer mockUebersetzer = Mockito.mock(Uebersetzer.class);
		
		// der Mock �bersetzt "Welt" mit "World"
		Mockito.when(mockUebersetzer.uebersetze("Welt")).thenReturn("World");
		
		// erzeugt die Uebersetzerschnittstelle mit dem Mock
		UebersetzerSchnittstelle zuTesten = new UebersetzerSchnittstelle();
		
		// testet die Uebersetzerschnittstelle mit dem Mock
		String uebersetzung = zuTesten.uebersetze(mockUebersetzer, "Welt");
		
		// prueft, ob das Ergebnis korrekt ist
		Assert.assertTrue(uebersetzung.equals("World"));
	}
}