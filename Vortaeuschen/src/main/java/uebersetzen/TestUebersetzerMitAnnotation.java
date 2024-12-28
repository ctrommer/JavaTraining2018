package uebersetzen;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith( MockitoExtension.class )
public class TestUebersetzerMitAnnotation {

	// mockt die Klasse Uebersetzer
	// entspricht:
	// Uebersetzer mockUebersetzer = Mockito.mock( Uebersetzer.class );
	@Mock
	private Uebersetzer mockUebersetzer;

	@Test
	public void testeUebersetzer() {
		
		// der Mock übersetzt "Welt" mit "World"
		Mockito
			.when( mockUebersetzer.uebersetze("Welt") )
			.thenReturn("World");

		// erzeugt die Uebersetzerschnittstelle
		UebersetzerSchnittstelle zuTesten = new UebersetzerSchnittstelle();

		// testet die Uebersetzerschnittstelle mit dem Mock
		String uebersetzung = zuTesten.uebersetze( 
												mockUebersetzer, 
												"Welt" );

		// prueft, ob das Ergebnis korrekt ist
		Assertions.assertTrue( uebersetzung.equals("World") );
	}

	@Test
	public void testeUebersetzerMitMehrerenErgebnissen() {
		List<String> listeUebersetzungen;
		
	    listeUebersetzungen = new ArrayList<String>();
	    listeUebersetzungen.add("World");
	    listeUebersetzungen.add("Earth");
	    
	    Mockito
	    	.when( mockUebersetzer.uebersetzeMitMehrerenErgebnissen( "Welt" ) )
	    	.thenReturn( listeUebersetzungen );		

		// erzeugt die Uebersetzerschnittstelle
		UebersetzerSchnittstelle uebersetzerSchnittstelle = new UebersetzerSchnittstelle();

		// testet die Uebersetzerschnittstelle mit dem Mock
		List<String> uebersetzungen = uebersetzerSchnittstelle.uebersetzeMitMehrerenErgebnissen(
																						mockUebersetzer, 
																						"Welt");
		// prueft, ob das Ergebnis korrekt ist
		Assertions.assertTrue( uebersetzungen.equals( listeUebersetzungen ) );
	}

}
