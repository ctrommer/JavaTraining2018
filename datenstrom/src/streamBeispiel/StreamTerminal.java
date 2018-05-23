package streamBeispiel;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTerminal {
	public static void main(String[] args) {

		zahlenAusgeben();
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
	private static void zahlenAusgeben() {
	}

	/**
	 * Stream von Namen erzeugen, 
	 * ersten finden 
	 * und wenn vorhanden ausgeben.
	 */
	private static void nachNamenSortierenUndErsteAusgeben() {		
	}

	/**
	 * Stream erzeugen,
	 * Anzahl Elemente ausgeben 
	 */
	private static void anzahlElementeAusgeben() {		
//		System.out.print(anzahlElemente);
	}

	/**
	 * Gebe die Summe der Zahlen von 1 bis 10 aus. 
	 * Mit Stream von int.
	 */
	private static void summeVonZahlenAusgeben() {
//		System.out.print(sum);
	}

	/**
	 * Stream von Integer erzeugen, 
	 * alle Zahlen miteinander multiplizieren.
	 */
	private static void zahlenMultiplizieren() {
//		System.out.print(multiplikationsErgebnis);
	}

	/**
	 * Erzeuge Stream von Integer
	 * Gebe die Statistik der enthaltenen Streams aus.
	 */
	private static void statistikEinesStreamsAusgeben() {
//		System.out.print(summe);		
	}

}
