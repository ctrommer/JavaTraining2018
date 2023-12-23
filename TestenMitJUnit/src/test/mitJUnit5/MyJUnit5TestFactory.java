package test.mitJUnit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import main.MeineMatheUtil;

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
	@TestFactory
    Collection<DynamicTest> dynamicTestMitCollection() {
        return Arrays.asList(
            DynamicTest.dynamicTest( 
            		"MeineMatheUtil.quadriere", 
            		() -> assertEquals( 4, MeineMatheUtil.quadriere( 2 ) ) ),
            DynamicTest.dynamicTest( 
            		"MeineMatheUtil.quadriere", 
            		() -> assertEquals( 9, MeineMatheUtil.quadriere( 3 ) ) )
        );
    }

	/**
	 * Teste MeineMatheUtil.quadriere mit einer Testfactory für die Zahlen von 2 bis 10 und einer for-Schleife
	 * @return
	 * ... die Stream-Variante ;-)
	 */
	@TestFactory
	Stream<DynamicTest> gleicherTestUnterschiedlicheDatenMitForSchleife() {
		// erst mal mit Liste
		List<DynamicTest> dynamicTests = new ArrayList<>();
		
		for( int index = 2; index <= 10; index++ ) {
			final int zahl = index;
			DynamicTest dynamicTest = DynamicTest.dynamicTest(
													"MeineMatheUtil.quadriere " + zahl, 
													() -> { assertEquals( 
																	zahl * zahl, 
																	MeineMatheUtil.quadriere( zahl ) ); 
															} );
			dynamicTests.add( dynamicTest );
		}
		
		// aber stream zurueckgeben
		return dynamicTests.stream();
	}
	
	/**
	 * Teste MeineMatheUtil.quadriere mit einer Testfactory für die Zahlen von 2 bis 10 ohne for-Schleife
	 * @return
	 * ... die Stream-Variante ;-)
	 */
	@TestFactory
	Stream<DynamicTest> gleicherTestUnterschiedlicheDaten() {
		
		// Direkt mit Stream, ohne Liste
		IntFunction<DynamicTest> zahlZuTest  
									= zuTestendeZahl 
									-> DynamicTest.dynamicTest( 
														"quadrieren von " + zuTestendeZahl, 
														()-> assertEquals( 
																zuTestendeZahl * zuTestendeZahl, 
																MeineMatheUtil.quadriere( zuTestendeZahl ) ) );
		return IntStream
				.rangeClosed( 2, 10 )
				.mapToObj( zahlZuTest );
	}

	/**
	 * Erzeuge ein zweidimensionales int-Array
	 * erste Zeile : 1,2 
	 * zweite Zeile: 3,4
	 * @return
	 * von der zweiten Zeile das erste Element
	 */
	public int elementAusZweidimensionalemArray() {
		int[][] zweidimensionalesIntArray = new int[][] { 
															{ 1, 2 }, 
															{ 3, 4 } 
															};
		
		return  zweidimensionalesIntArray[1][0];
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
	public List<Integer> zweidimensionalesArrayZuStream( int[][] zweidimensionalesIntArray ) {

		Stream<int[]> streamOfPrimitiveIntArray = Arrays.stream( zweidimensionalesIntArray );
		
		IntStream streamOfPrimitiveInt = streamOfPrimitiveIntArray.flatMapToInt( x->Arrays.stream( x ) );
		
		Stream<Integer> streamOfInteger = streamOfPrimitiveInt.boxed();
		
		return streamOfInteger.collect( Collectors.toList() );
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
    @TestFactory    
    public Stream<DynamicTest> testeMitMehrerenDaten() {

        int[][] testdaten = new int[][] { 
        								{ 2, 4 }, 
        								{ 5, 25 }, 
        								{ 7, 49 } 
        								};
        Stream<int[]> intArrayStream = Arrays.stream( testdaten );
        
        Function<? super int[], ? extends DynamicTest> intArrayToDynamicTest 
        															= intArray 
        															-> {
        																return DynamicTest.dynamicTest(
        																						"MeineMatheUtil.quadriere " + intArray[0],
        																						() -> assertEquals( 
        																									intArray[1], 
        																									MeineMatheUtil.quadriere( intArray[0] ) ) );
        };
        
		return intArrayStream.map( intArrayToDynamicTest );
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
