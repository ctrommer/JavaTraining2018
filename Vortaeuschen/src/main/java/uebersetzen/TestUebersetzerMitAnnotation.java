package uebersetzen;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestUebersetzerMitAnnotation {

	// mockt die Klasse Uebersetzer
	// entspricht:
	// Uebersetzer mockUebersetzer = Mockito.mock( Uebersetzer.class );

	@Test
	public void testeUebersetzer() {
		
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

	@Test
	public void testeUebersetzerMitMehrerenErgebnissen() {
		List<String> listeUebersetzungen;
		
	    listeUebersetzungen = new ArrayList<String>();
	    listeUebersetzungen.add("World");
	    listeUebersetzungen.add("Earth");

		// der Mock übersetzt "Welt" mit "World" und "Earth"

		// erzeugt die Uebersetzerschnittstelle
		UebersetzerSchnittstelle uebersetzerSchnittstelle = new UebersetzerSchnittstelle();

		// testet die Uebersetzerschnittstelle mit dem Mock
		List<String> uebersetzungen = new ArrayList<>();
		
		// prueft, ob das Ergebnis korrekt ist
		Assertions.assertEquals( 
							listeUebersetzungen, 
							uebersetzungen );
	}

}
