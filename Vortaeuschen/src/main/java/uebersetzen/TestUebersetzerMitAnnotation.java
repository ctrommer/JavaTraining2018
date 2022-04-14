package uebersetzen;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestUebersetzerMitAnnotation {

	@Mock
	private Uebersetzer mockUebersetzer;
	
	private List<String> listeUebersetzungen;
	
	@Before
	public void setUp() {
		
	    Mockito.doReturn("World").when(mockUebersetzer).uebersetze("Welt");
	    
	    listeUebersetzungen = new ArrayList<String>();
	    listeUebersetzungen.add("World");
	    listeUebersetzungen.add("Earth");
	    Mockito.doReturn(listeUebersetzungen).when(mockUebersetzer).uebersetzeMitMehrerenErgebnissen("Welt");
	}	

	@Test
	public void testeUebersetzer() {

		// erzeugt die Uebersetzerschnittstelle mit dem Mock
		UebersetzerSchnittstelle uebersetzerSchnittstelle = new UebersetzerSchnittstelle();

		// testet die Uebersetzerschnittstelle mit dem Mock
		String uebersetzung = uebersetzerSchnittstelle.uebersetze( mockUebersetzer, "Welt" );

		// prueft, ob das Ergebnis korrekt ist
		Assert.assertTrue(uebersetzung.equals("World"));
	}
	
	@Test
	public void testeUebersetzerMitMehrerenErgebnissen() {

		// erzeugt die Uebersetzerschnittstelle mit dem Mock
		UebersetzerSchnittstelle uebersetzerSchnittstelle = new UebersetzerSchnittstelle();

		// testet die Uebersetzerschnittstelle mit dem Mock
		List<String> uebersetzungen = uebersetzerSchnittstelle.uebersetzeMitMehrerenErgebnissen(mockUebersetzer, "Welt");

		// prueft, ob das Ergebnis korrekt ist
		Assert.assertTrue(uebersetzungen.equals(listeUebersetzungen));
	}

}
