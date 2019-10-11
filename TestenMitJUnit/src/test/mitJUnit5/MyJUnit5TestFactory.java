package test.mitJUnit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import main.MeineMatheUtil;

public class MyJUnit5TestFactory {

	/**
	 * Teste MeineMatheUtil.quadriere mit einer Testfactory für die Zahlen 2 und 3
	 * @return
	 * ... die Collection-Variante ;-)
	 */
    void dynamicTestMitCollection() {
    }

	/**
	 * Teste MeineMatheUtil.quadriere mit einer Testfactory für die Zahlen 2 und 3 und einer for-Schleife
	 * @return
	 * ... die Stream-Variante ;-)
	 */
	void gleicherTestUnterschiedlicheDaten() {
		// erst mal mit Liste
	
		
		// aber stream zurueckgeben
		
	}

	/**
	 * Erzeuge ein zweidimensionales int-Array
	 * erste Zeile : 1,2 
	 * zweite Zeile: 3,4
	 * @return
	 * von der zweiten Zeile das erste Element
	 */
	public int elementAusZweidimensionalemArray() {
		
		
		return  42;
	}

	@Test
	public void testeElementAusZweidimensionalemArray() {		
		assertEquals(3, elementAusZweidimensionalemArray());
	}

	/**
	 * erzeuge aus dem zweidimensionalen Array einen Stream von int-Array
	 * fülle die Elemente des Streams mit einem Consumer in eine Liste
	 * 
	 * @param zweidimensionalesIntArray
	 * @return
	 * Liste, die alle Integer Werte des zweidimensionalen Arrays enthält
	 */
	public List<Integer> zweidimensionalesArrayZuStream(int[][] zweidimensionalesIntArray) {

		List<Integer> intList = new ArrayList<>();


		return intList;
	}
	
	@Test
	public void testeZweidimensionalesArrayZuStream() {
		List<Integer> zutestendeWerte = zweidimensionalesArrayZuStream( new int[][] { { 1, 2 }, { 3, 4 } } );
		List<Integer> erwarteteWerte = Arrays.asList(1,2,3,4);
		assertEquals(erwarteteWerte, zutestendeWerte);
	}	

    /**
     * Erzeuge zweidimensionales int-Array mit Testdaten
     * Wandle zweidimensionales Array in Stream von int-Array
     * Wandle stream von int-Array in Stream von DynamicTest.
     * 
     * @return
     * die Stream-Variante
     */
    @TestFactory    
    public void testeMitMehrerenDaten() {
    }

}
