package test.mitJUnit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

public class MyJUnit5TestFactory {
	
	private static int ausgefuehrteTests = 0;
	
	@AfterEach
	public void testWurdeAusgefuehrt() {
		ausgefuehrteTests++;
	}
	
	@AfterAll
	public static void wurdenAlleTestsAusgefuehrt() {
		assertEquals( 7, ausgefuehrteTests );
	}
	
	/**
	 * Teste MeineMatheUtil.quadriere mit einer Testfactory für die Zahlen 2 und 3
	 * @return
	 * ... die Collection-Variante ;-)
	 */
    void dynamicTestMitCollection() {
    }

	/**
	 * Teste MeineMatheUtil.quadriere mit einer Testfactory für die Zahlen von 2 bis 10 und einer for-Schleife
	 * @return
	 * ... die Stream-Variante ;-)
	 */
	void gleicherTestUnterschiedlicheDatenMitForSchleife() {

		// erst mal mit Liste
		
		// aber stream zurueckgeben
	}
	
	/**
	 * Teste MeineMatheUtil.quadriere mit einer Testfactory für die Zahlen von 2 bis 10 ohne for-Schleife
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
		assertEquals( 
				3, 
				elementAusZweidimensionalemArray() );
	}

	/**
	 * Zweidimensionales array aus primitiven int soll
	 * über Stream
	 * in Liste von Integer umgewandelt werden.
	 * 
	 * @param zweidimensionalesIntArray
	 * @return
	 * Liste, die alle Integer Werte des zweidimensionalen Arrays enthaelt
	 */

	public List<Integer> zweidimensionalesArrayZuStream(int[][] zweidimensionalesIntArray) {
		return null;
	}
	
	@Test
	public void testeZweidimensionalesArrayZuStream() {
		List<Integer> zutestendeWerte = zweidimensionalesArrayZuStream( new int[][] { 
																					{ 1, 2 }, 
																					{ 3, 4 } 
																					} );
		List<Integer> erwarteteWerte = Arrays.asList( 1, 2, 3, 4 );
		assertEquals(
				erwarteteWerte, 
				zutestendeWerte);
	}	

    /**
     * Erzeuge zweidimensionales int-Array mit Testdaten { 2, 4 }, { 5, 25 }, { 7, 49 }
     * Wandle zweidimensionales Array in Stream von int-Array
     * Wandle stream von int-Array in Stream von DynamicTest.
     * 
     * @return
     * die Stream-Variante
     */
    public void testeMitMehrerenDaten() {
    }	

	/**
	 * Verwendet Reflektion, um die Methoden zu ermitteln, die mit
	 * @TestFactory annotiert sind.
	 * Siehe
	 * https://stackoverflow.com/questions/6593597/java-seek-a-method-with-specific-annotation-and-its-annotation-element
	 * @return
	 * Liste der mit @TestFactory annotierten Methoden 
	 */
	public static List<String> ermittleMitTestFactoryAnnotierteMethoden() {
		List<String> listeMitTestFactoryAnnotierteMethoden = new ArrayList<>();
		for ( final Method methode : MyJUnit5TestFactory.class.getDeclaredMethods() ) {
			if ( methode.isAnnotationPresent( TestFactory.class ) ) {
				listeMitTestFactoryAnnotierteMethoden.add( methode.getName() );
			}
		}
		return listeMitTestFactoryAnnotierteMethoden;
	}
	
	@Test
	@DisplayName("Teste, ob die Methoden mit @TestFactory annotiert sind.")
	public void testeDynamicTestMitCollection() {		
		List<String> methodsAnnotatedWithTestFactory = ermittleMitTestFactoryAnnotierteMethoden();
		List<String> expected = Arrays.asList( 
										"gleicherTestUnterschiedlicheDaten", 
										"dynamicTestMitCollection", 
										"testeMitMehrerenDaten", 
										"gleicherTestUnterschiedlicheDatenMitForSchleife" );
		
		assertEquals( new HashSet<>(expected), new HashSet<>( methodsAnnotatedWithTestFactory ) );		
	}

}
