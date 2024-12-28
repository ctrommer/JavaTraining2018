package uebersetzen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestUebersetzer {
	@Test
	public void testeUebersetzer() {

		// mockt die Klasse Uebersetzer
		
		// der Mock übersetzt "Welt" mit "World"
		
		// erzeugt die Uebersetzerschnittstelle
		UebersetzerSchnittstelle zuTesten = new UebersetzerSchnittstelle();
		
		// testet die Uebersetzerschnittstelle mit dem Mock
		String uebersetzung = "";
		
		// prueft, ob das Ergebnis korrekt ist
		Assertions.assertEquals( 
							"World", 
							uebersetzung );
	}
}