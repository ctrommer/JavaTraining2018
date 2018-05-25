package streamBeispiel;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTerminal {
	public static void main(String[] args) {

		namenAusgeben();
		System.out.println();
		
		nachNamenSortierenUndErsteAusgeben();
		System.out.println();
		
		anzahlElementeAusgeben();
		System.out.println();

		summeVonZahlenAusgeben();
		System.out.println();
		
		zahlenMultiplizieren();
		System.out.println();
		
		statistikEinesStreamsAusgeben();
		System.out.println();
	}

	/**
	 * Erzeuge Stream von Namen und gebe die Namen aus.
	 */
	private static void namenAusgeben() {
		Stream.of("Karl", "Arnold", "Franz")
		.forEach( s -> System.out.print( s  + " ") );
	}

	/**
	 * Stream von Namen erzeugen, 
	 * ersten finden 
	 * und wenn vorhanden ausgeben.
	 */
	private static void nachNamenSortierenUndErsteAusgeben() {		
		Stream.of("Karl", "Arnold", "Franz")
			.findFirst()
			.ifPresent(System.out::print);		
	}

	/**
	 * Stream erzeugen,
	 * Anzahl Elemente ausgeben 
	 */
	private static void anzahlElementeAusgeben() {		
		long anzahlElemente = Stream.of("Karl", "Arnold", "Franz")
			.count();
		System.out.print(anzahlElemente);
	}

	/**
	 * Gebe die Summe der Zahlen von 1 bis 10 aus. 
	 * Mit Stream von int.
	 */
	private static void summeVonZahlenAusgeben() {
		int sum = IntStream
				.rangeClosed(1, 10)
				.sum();
		System.out.print(sum);
	}

	/**
	 * Stream von Integer erzeugen, 
	 * alle Zahlen miteinander multiplizieren.
	 */
	private static void zahlenMultiplizieren() {
		double multiplikationsErgebnis = Stream.of(1,2,3,4,5)
				.reduce(1, (Integer a, Integer b) -> a*b );
		System.out.print(multiplikationsErgebnis);
	}

	/**
	 * Erzeuge Stream von Integer
	 * Gebe die Statistik der enthaltenen Streams aus.
	 */
	private static void statistikEinesStreamsAusgeben() {
		IntSummaryStatistics summaryStatistics = IntStream.of(1,2,3,4,5)
				.summaryStatistics();
		System.out.print(summaryStatistics);		
	}

}
