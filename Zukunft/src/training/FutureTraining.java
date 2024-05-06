package training;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FutureTraining {
	
	/**
	 * Quadriert die Zahl ohne eigenen Thread.
	 * @param zahl zu quadrieren
	 * @return Future, dass die quadrierte Zahl enthält
	 */
	private Future<Integer> ohneThreadQuadrieren( int zahl ) {
		return null;
	}
	
	/**
	 * Quadriert die Zahl in eigenem Thread.
	 * @param zahl zu quadrieren
	 * @return Future, dass die quadrierte Zahl enthält
	 */	
	private Future<Integer> inEigenemThreadQuadrieren( int zahl ) {
		return null;
	}
	
	/**
	 * Quadriert die Zahl in eigenem Thread. 
	 * Das Ergebnis wird mit 2 multipliziert, aber nicht in einem eigenen Thread.
	 * @param zahl als Eingabe
	 * @return Future, dass das Ergebnis enthält
	 */	
	private Future<Integer> inEigenemThreadQuadrierenDannMit2Multiplizieren( int zahl ) {
		return null;
	}

	/**
	 * Quadriert die Zahl in eigenem Thread. 
	 * Das Ergebnis wird in eigenem Thrad mit 2 multipliziert.
	 * @param zahl als Eingabe
	 * @return Future, dass das Ergebnis enthält
	 */
	private Future<Integer> inEigenemThreadQuadrierenDannMit2InThreadMultiplizieren( int zahl ) {
		return null; 
	}

	/**
	 * Quadriert die Zahl in eigenem Thread. 
	 * Setze das Ergebnis zusammen mit dem Ergebnis eines zweiten Threads, 
	 * der das Ergebnis des ersten Threads verwendet, um es mit 2 zu multiplizieren.
	 * @param zahl als Eingabe
	 * @return Future, dass das Ergebnis enthält
	 */
	private Future<Integer> inEigenemThreadQuadrierenDannZusammensetzenMitMit2InThreadMultiplizieren( int zahl ) {
		return null;
	}
	
	/**
	 * Quadriert die Zahl in eigenem Thread.
	 * Multipliziere die Zahl in einem zweiten Thread mit zwei. 
	 * Kombiniere beiden Futures zu drittem Future, indem der Inhalt der Futures addiert wird.
	 * @param zahl als Eingabe
	 * @return Future, dass das Ergebnis enthält
	 */
	private Future<Integer> ersterThreadQuadriertZweiterThreadMultipliziertMit2Kombiniert( int zahl ) {
		return null;
	}

	/**
	 * Quadriert die Zahl in eigenem Thread.
	 * Multipliziere die Zahl in einem zweiten Thread mit zwei.
	 * Multipliziere die Zahl in einem dritten Thread mit 10. 
	 * Erzeuge aus den Teilergebnissen einen Stream von CompletableFuture.
	 * Transformiere die Teilergebnisse in einen Stream von Integer.
	 * 
	 * @param zahl als Eingabe
	 * @return Future, dass das Ergebnis enthält
	 */
	private Stream<Integer> dreiTheadsParallelDannGejoint( int zahl ) {
		return null;
	}
	
	/**
	 * Quadriert die Zahl in eigenem Thread. Wenn zahl > 46340, dann wirf IllegalArgumentException.
	 * 
	 * @param zahl als Eingabe
	 * @return Future, dass das Ergebnis enthält. 
	 * Wenn keine Exception: Zahl quadriert als String.
	 * Wenn Exception: "Zahl zu gross."
	 */	
	private Future<String> inEigenemThreadQuadrierenAusnameBehandeln( int zahl ) {
		return null;
	}

	/**
	 * Quadriert die Zahl in eigenem Thread.
	 * Bis der Thread Ergebnis liefert, wird ausgegeben:
	 * 
	 * Aus main: Ich mach solange was anderes, bis Thread Ergebnis liefert."
	 * 
	 * @param zahl zu quadrieren
	 * @return quadrierte Zahl
	 */	
	public Integer erledigeAufgabeUndParallelDazuUnteraufgabeInThread( int zahl ) {
		
		// zeitintensive Aufgabe in eigenem Thread starten
		
		// solange der Thread noch kein Ergebnis geliefert hat, kann man was anderes machen

			System.out.println("Aus main: Ich mach solange was anderes, bis Thread Ergebnis liefert.");

		
		// Ergebnis von Thread abrufen

		return null;
	}	

	@Test
	@DisplayName("ohne Thread quadrieren")
	public void test01() {
		try {
			assertEquals( 
					81, 
					ohneThreadQuadrieren( 9 ).get() );
		} catch ( InterruptedException | ExecutionException e ) {
			e.printStackTrace();
		}		
	}

	@Test
	@DisplayName("in eigenem Thread quadrieren")
	public void test02() {
		try {
			assertEquals( 
					81, 
					inEigenemThreadQuadrieren( 9 ).get() );		
		} catch ( InterruptedException | ExecutionException e ) {
			e.printStackTrace();
		}
	}

	@Test
	@DisplayName("in eigenem Thread quadrieren dann mit 2 multiplizieren")
	public void test03() {
		try {
			assertEquals( 
					162, 
					inEigenemThreadQuadrierenDannMit2Multiplizieren( 9 ).get() );		
		} catch ( InterruptedException | ExecutionException e ) {
			e.printStackTrace();
		}
	}

	@Test
	@DisplayName("in eigenem Thread quadrieren dann mit 2 in Thread multiplizieren")
	public void test04() {
		try {
			assertEquals( 
					162, 
					inEigenemThreadQuadrierenDannMit2InThreadMultiplizieren( 9 ).get() );		
		} catch ( InterruptedException | ExecutionException e ) {
			e.printStackTrace();
		}
	}

	@Test
	@DisplayName("in eigenem Thread quadrieren dann zusammensetzen mit mit 2 in ThreadMultiplizieren")
	public void test05() {
		try {
			assertEquals( 
					162, 
					inEigenemThreadQuadrierenDannZusammensetzenMitMit2InThreadMultiplizieren( 9 ).get() );		
		} catch ( InterruptedException | ExecutionException e ) {
			e.printStackTrace();
		}
	}	

	@Test
	@DisplayName("erster Thread quadriert zweiter Thread multipliziert mit 2 kombiniert")
	public void test06() {
		try {
			assertEquals( 
					99, 
					ersterThreadQuadriertZweiterThreadMultipliziertMit2Kombiniert( 9 ).get() );		
		} catch ( InterruptedException | ExecutionException e ) {
			e.printStackTrace();
		}
	}

	@Test
	@DisplayName("drei Theads parallel dann gejoint")
	public void test07( ) {
		List<Integer> dreiTheadsParallelDannGejoint = dreiTheadsParallelDannGejoint( 9 ).collect( Collectors.toList() );		
		List<Integer> expected = List.of( 81, 18, 90 );
		assertEquals( 
				expected, 
				dreiTheadsParallelDannGejoint );
	}

	@Test
	@DisplayName("in eigenem Thread quadrieren Ausname behandeln ohne Exception")
	public void test08() {
		try {
			assertEquals( 
					"81", 
					inEigenemThreadQuadrierenAusnameBehandeln( 9 ).get() );		
		} catch ( InterruptedException | ExecutionException e ) {
			e.printStackTrace();
		}
	}
	
	@Test
	@DisplayName("In eigenem Thread quadrieren Ausname behandeln mit Exception")
	public void test09() {
		try {
			assertDoesNotThrow(
							() 
							-> inEigenemThreadQuadrierenAusnameBehandeln( 46341 ).get() );
			
			assertEquals(
					"Zahl zu gross.", 
					inEigenemThreadQuadrierenAusnameBehandeln( 46341 ).get());		
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@DisplayName("erledige Aufgabe und parallel dazu Unteraufgabe in Thread")
	public void test10() {
		assertEquals(
				81, 
				erledigeAufgabeUndParallelDazuUnteraufgabeInThread( 9 ) );		
	}
}