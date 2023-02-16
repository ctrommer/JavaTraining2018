package test.mitJUnit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import main.MeineMatheUtil;

public class MyJUnit5TestFactory {

	/**
	 * Teste MeineMatheUtil.quadriere mit einer Testfactory f�r die Zahlen 2 und 3
	 * @return
	 * ... die Collection-Variante ;-)
	 */
    void dynamicTestMitCollection() {
    }

	/**
	 * Teste MeineMatheUtil.quadriere mit einer Testfactory f�r die Zahlen von 2 bis 10 und einer for-Schleife
	 * @return
	 * ... die Stream-Variante ;-)
	 */
	void gleicherTestUnterschiedlicheDatenMitForSchleife() {

		// erst mal mit Liste
		
		// aber stream zurueckgeben
	}
	
	/**
	 * Teste MeineMatheUtil.quadriere mit einer Testfactory f�r die Zahlen von 2 bis 10 ohne for-Schleife
	 * @return
	 * ... die Stream-Variante ;-)
	 */
	void gleicherTestUnterschiedlicheDaten() {
		
		// Direkt mit Stream, ohne Liste
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
	 * f�lle die Elemente des Streams mit einem Consumer in eine Liste
	 * 
	 * @param zweidimensionalesIntArray
	 * @return
	 * Liste, die alle Integer Werte des zweidimensionalen Arrays enth�lt
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
