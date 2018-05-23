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
		
		statistik();
		System.out.println();
	}

	/**
	 * Stream von Namen 
	 * sortieren, 
	 * ersten finden 
	 * und wenn vorhanden ausgeben.
	 */
	private static void sortierenUndErstenFinden() {		
		Stream.of("Karl", "Arnold", "Franz")
			.sorted()
			.findFirst()
			.ifPresent(System.out::println);		
	}

	/**
	 * Stream von Namen
	 * filtern auf Elemente, die mit A anfangen
	 * und ausgeben
	 */
	private static void filtern() {
		Stream.of("Karl", "Arnold", "Franz")
			.filter(s->s.startsWith("A"))
			.forEach(System.out::println);
	}
	
	/**
	 * Mit anonymer Klasse
	 * 
	 * Stream von Namen
	 * filtern auf Elemente, die mit A anfangen
	 * und ausgeben
	 */
	private static void filternMitAnonymerKlasse() {
		Stream.of("Karl", "Arnold", "Franz")
			.filter(new Predicate<String>() {
				@Override
				public boolean test(String s) {
					return s.startsWith("A");
				}
			})
			.forEach(new Consumer<String>() {
				@Override
				public void accept(String t) {
					System.out.println(t);
				}
			});		
	}	
	
	/**
	 * Stream von Namen
	 * zu Kleinbuchstaben
	 * und ausgeben 
	 */
	private static void zuKleinbuchstaben() {
		Stream.of("Karl", "Arnold", "Franz")
			.map(String::toLowerCase)
			.forEach(System.out::println);			
	}

	/**
	 * Stream von Zahlen erzeugen
	 * Zahlen quadrieren
	 * durchschnitt der Zahlen bilden
	 * ausgeben
	 */
	private static void zumQuadratUndDurchschnitt() {
		IntStream
			.rangeClosed(1, 10)
			.map( x -> x*x )
			.average()
			.ifPresent(System.out::println);		
	}	
	
	/**
	 * Gebe die Zahlen von 1 bis 10 aus, überspringe dabei die ersten 5 Elemente.
	 * Mit Stream von int.
	 */
	private static void zahlenUeberspringen() {
		IntStream
			.rangeClosed(1, 10)
			.skip(5)
			.forEach(System.out::print);		
	}
	
	/**
	 * Erzeuge einen Stream von int, der die Zahlen 1 bis 10 enthält.
	 * Gebe für die Zahlen die Statistik aus.
	 * Nur für Integer. 
	 */
	private static void statistik() {
		
		IntSummaryStatistics summaryStatistics = IntStream
			.rangeClosed(1, 10)
			.summaryStatistics();

		System.out.println(summaryStatistics);		
	}

}
