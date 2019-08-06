package uebersetzen;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TestUebersetzerMitAnnotation {

	
	private List<String> listeUebersetzungen;
	
	public void setUp() {
	    
	    listeUebersetzungen = new ArrayList<String>();
	    listeUebersetzungen.add("World");
	    listeUebersetzungen.add("Earth");

	}	

	@Test
	public void testeUebersetzer() {

		UebersetzerSchnittstelle uebersetzerSchnittstelle = new UebersetzerSchnittstelle();

		// testet die Uebersetzerschnittstelle mit dem Mock
		String uebersetzung = null;

		// prueft, ob das Ergebnis korrekt ist
		Assert.assertTrue(uebersetzung.equals("World"));
	}
	
	@Test
	public void testeUebersetzerMitMehrerenErgebnissen() {

		// erzeugt die Uebersetzerschnittstelle mit dem Mock
		UebersetzerSchnittstelle uebersetzerSchnittstelle = new UebersetzerSchnittstelle();

		// testet die Uebersetzerschnittstelle mit dem Mock
		List<String> uebersetzungen = null;

		// prueft, ob das Ergebnis korrekt ist
		Assert.assertTrue(uebersetzungen.equals(listeUebersetzungen));
	}

}
