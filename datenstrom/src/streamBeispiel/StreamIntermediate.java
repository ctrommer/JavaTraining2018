package streamBeispiel;

import java.util.IntSummaryStatistics;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamIntermediate {
	public static void main(String[] args) {
		
		sortierenUndErstenFinden();
		System.out.println();
		
		filtern();
		System.out.println();
		
		filternMitAnonymerKlasse();
		System.out.println();
		
		zuKleinbuchstaben();
		System.out.println();
		
		zumQuadratUndDurchschnitt();
		System.out.println();
		
		zahlenUeberspringen();
		System.out.println();
		
	}

	/**
	 * Stream von Namen 
	 * sortieren, 
	 * ersten finden 
	 * und wenn vorhanden ausgeben.
	 */
	private static void sortierenUndErstenFinden() {		
	}

	/**
	 * Stream von Namen
	 * filtern auf Elemente, die mit A anfangen
	 * und ausgeben
	 */
	private static void filtern() {
	}
	
	/**
	 * Mit anonymer Klasse
	 * 
	 * Stream von Namen
	 * filtern auf Elemente, die mit A anfangen
	 * und ausgeben
	 */
	private static void filternMitAnonymerKlasse() {
	}	
	
	/**
	 * Stream von Namen
	 * zu Kleinbuchstaben
	 * und ausgeben 
	 */
	private static void zuKleinbuchstaben() {
	}

	/**
	 * Stream von Zahlen erzeugen
	 * Zahlen quadrieren
	 * durchschnitt der Zahlen bilden
	 * ausgeben
	 */
	private static void zumQuadratUndDurchschnitt() {
	}	
	
	/**
	 * Gebe die Zahlen von 1 bis 10 aus, überspringe dabei die ersten 5 Elemente.
	 * Mit Stream von int.
	 */
	private static void zahlenUeberspringen() {
	}

}
