package vergleicherBeispiel;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VergleicherTrainer {

	private static final Spieler KARL_11 = new Spieler("Karl", 11, "Kalle");
	private static final Spieler ALBERT_22 = new Spieler("Albert", 22, "Albi");
	private static final Spieler GUSTAV_11 = new Spieler("Gustav", 11, "Gustel");
	private static final Spieler BERTRAM_33 = new Spieler("Bertram", 33, "Bert");

	private int vergleicheSpielerNachAlterMitAnonymerInnererKlasse( Spieler links, Spieler rechts ) {
		return 0;
	}

	private int vergleicheSpielerNachAlterMitLambda(Spieler links, Spieler rechts ) {
		return 0;
	}
	
	/**
	 * Ein bereits existierender Vergleicher soll in einen Rückwärtsvergleicher verwandelt werden.
	 */
	private int vergleicheSpielerNachAlterMitLambdaRueckwaerts(Spieler links, Spieler rechts ) {
		return 0;
	}

	private int vergleicheSpielerNachAlterMitFunktion(Spieler links, Spieler rechts ) {		
		return 0;
	}

	private int vergleicheSpielerNachAlterMitFunktionUndStatischerMethodeVonVergleicher( Spieler links, Spieler rechts ) {
		return 0;
	}
	
	/**
	 * Schreibe Methode von MyVergleicher, die einen Vergleicher erzeugt, der Elemente rückwärts vergleicht, die
	 * Comparable implementieren.
	 * Verwende die Methode, um Integer rückwärts zu sortieren.
	 */
	private int vergleicheIntegerRueckwaerts(Integer links, Integer rechts) {
		return 0;
	}

	/**
	 * Mit Methode, die einen Vergleichskriteriumextrahierer und einen Rueckwaertsvergleicher nimmt.  
	 * 	  
	 * Beachte dabei den Unterschied zwischen anonymer innerer Klasse und lambda.
	 * 
	 * Für die übung mit eigenem Vergleicher starke Vereinfachung akzeptabel.
	 * 
	 */
	private int vergleicheSpielerNachAlterRueckwaertsMitVergleichskriteriumextrahiererUndRueckwaertsvergleicher( Spieler links, Spieler rechts ) {
		return 0;
	}

	private int vergleicheZeichenketteGrossKleinSchreibungIgnorierend( Zeichenkette links, Zeichenkette rechts ) {
		return 0;
	}

	/**
	 * Sortieren nach Spitzname
	 */
	private int vergleicheSpielerNachSpitznameRueckwaertsGrossKleinSchreibungIgnorierend( Spieler links, Spieler rechts ) {
		return 0;
	}

	/**
	 * Hierzu 2 Methoden schreiben:
	 * - Methode, die mit der übergebenen Funktion einen Vergleicher erzeugt und damit die zweite Methode aufruft, die 
	 * - die zwei Vergleicher zusammenfuegt 
	 */
	private int vergleicheSpielerNachAlterUndDannNachName( Spieler links, Spieler rechts ) {
		return 0;
	}

	/**
	 * NullVergleicher zum Vergleichen erstellen.
	 * Parameter ist ein Vergleicher, also nicht eine Method-Referenz.
	 * Über Vergleicherunterstützer und nestend class.
	 */
	public int vergleicheSpielerNachAlterNullBeruecksichtigend( Spieler links, Spieler rechts ) {
		return 0;
	}

	public int vergleicheSpielerNachAlterNullBeruecksichtigendRueckwaerts( Spieler links, Spieler rechts ) {
		return 0;
	}

	private int vergleicheSpielerNachAlterNullBeruecksichtigendUndDannNachName( Spieler links, Spieler rechts ) {
		return 0;
	}

	/**
	 * Null beruecksichtigenden Vergleicher, bei dem Null zuerst kommt erstellen.
	 * Als zweites Vergleichskriterium nach Name vergleichen.
	 * @param links
	 * @param rechts
	 * @return
	 */
	private int vergleicheSpielerErsterVergleicherNullZweiterVergleicherNachName( Spieler links, Spieler rechts ) {

		// Soll auch funktionieren, wenn null als Comparator übergeben wird.
		return 0;
	}

	/**
	 * Etwas vergleichen, was auf natürliche Art verglichen werden kann.
	 * 
	 * Über Vergleicherunterstuetzer, Enum als Singelton.
	 * 
	 * Hinweise: enum VergleicherWieComparable implements Vergleicher<Comparable<Object>> { 
	 */
	public int sortiereNachNatuerlicherOrdnung( Fussballer links, Fussballer rechts ) {
		return 0;
	}

}
