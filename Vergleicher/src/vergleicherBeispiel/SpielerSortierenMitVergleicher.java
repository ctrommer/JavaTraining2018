package vergleicherBeispiel;

import java.util.Arrays;
import java.util.List;

public class SpielerSortierenMitVergleicher {
	
	static List<Spieler> spielerListe = Arrays.asList(new Spieler("Anton",43),new Spieler("Karl",22),new Spieler("Gabi",42));
	
	public static void main(String[] args) {
		vergleicheSpielerNachAlterMitAnonymerInnererKlasse();
		vergleicheSpielerNachAlterMitLambda();
		vergleicheSpielerNachAlterMitLambdaRueckwaerts();
		vergleicheSpielerNachAlterMitLambdaUndFunktion();
		vergleicheSpielerNachAlterMitStatischerMethodeVonComperator();
		vergleicheSpielerNachAlterMitStatischerMethodeVonComperatorMitLambda();
		vergleicheSpielerNachAlterMitStatischerMethodeVonComperatorMitMethodReferenz();
		vergleicheSpielerNachAlterMitStatischerMethodeVonComperatorMitMethodReferenzDirekt();
		vergleicheIntegerRueckwaerts();
		vergleicheSpielerNachAlterRueckwaerts();
		vergleicheZeichenketteGrossKleinSchreibungIgnorierend();		
		vergleicheSpielerNachSpitznameRueckwaertsGrossKleinSchreibungIgnorierend();
		vergleicheSpielerNachAlterUndDannNachName();
		vergleicheSpielerNachAlterNullBeruecksichtigend();
		vergleicheSpielerNachAlterNullBeruecksichtigendRueckwaerts();
		vergleicheSpielerNachAlterNullBeruecksichtigendUndDannNachName();
		sortiereNachNatuerlicherOrdnung();
	}
	
	private static void vergleicheSpielerNachAlterMitAnonymerInnererKlasse() {
		
		// System.out.println(spielerVergleicher.vergleiche(new Spieler("Karl", 42), new Spieler("Albert", 14)));
	}

	private static void vergleicheSpielerNachAlterMitLambda() {

	}

	/**
	 * Ein bereits existierender Vergleicher soll in einen Rückwärtsvergleicher verwandelt werden.
	 */
	private static void vergleicheSpielerNachAlterMitLambdaRueckwaerts() {
		
	}	

	private static void vergleicheSpielerNachAlterMitLambdaUndFunktion() {
		
	}

	private static void vergleicheSpielerNachAlterMitStatischerMethodeVonComperator() {

	}
	
	private static void vergleicheSpielerNachAlterMitStatischerMethodeVonComperatorMitLambda() {

	}

	private static void vergleicheSpielerNachAlterMitStatischerMethodeVonComperatorMitMethodReferenz() {		

	}

	private static void vergleicheSpielerNachAlterMitStatischerMethodeVonComperatorMitMethodReferenzDirekt() {

	}

	/**
	 * Schreibe Methode von MyVergleicher, die einen Vergleicher erzeugt, der Elemente rückwärts vergleicht, die 
	 * Comparable implementieren.
	 * Verwende die Methode, um Integer rückwärts zu sortieren. 
	 */
	private static void vergleicheIntegerRueckwaerts() {

	}

	/**
	 * Mit Methode, die einen Vergleicher erzeugt. Dazu nimmt sie einen Vergleichskriteriumextrahierer und einen Rueckwaertsvergleicher.  
	 * 	  
	 * Beachte dabei den Unterschied zwischen anonymer innerer Klasse und lambda.
	 * 
	 * Für die Übung mit eigenem Vergleicher starke Vereinfachung akzeptabel.
	 * 
	 */
	private static void vergleicheSpielerNachAlterRueckwaerts() {

	}

	/**
	 * Hierzu nested class in Zeichenkette, von der dann in Zeichenkette eine Konstante erzeugt wird.
	 */
	private static void vergleicheZeichenketteGrossKleinSchreibungIgnorierend() {

	}	

	/**
	 * Sortieren nach Spitzname; Spitzname ist eine Zeichenkette.
	 */	
	private static void vergleicheSpielerNachSpitznameRueckwaertsGrossKleinSchreibungIgnorierend() {
		
	}

	/**
	 * Hierzu 2 Methoden schreiben:
	 * - 1. Methode, die aus der als Parameter übergebenen Funktion einen Vergleicher erzeugt und die 2. Methode damit aufruft. 
	 * - 2. Methode, die einen neuen Vergleicher aus zwei Vergleichern erzeugt. 
	 */
	private static void vergleicheSpielerNachAlterUndDannNachName() {
		
	}

	/**
	 * NullVergleicher zum Vergleichen erstellen.
	 * Parameter ist ein Vergleicher, also nicht eine Method-Referenz.  
	 * Über Vergleicherunterstützer und nestend class.
	 */
	public static void vergleicheSpielerNachAlterNullBeruecksichtigend() {
	}

	/**
	 * Nur zum testen, ob der Nullvergleicher auch Rueckwaerts berücksichtigt.
	 */
	public static void vergleicheSpielerNachAlterNullBeruecksichtigendRueckwaerts() {
	}

	/**
	 * Nur zum testen, ob der Nullvergleicher auch zweiten Vergleicher hinzufügen berücksichtigt.
	 */
	private static void vergleicheSpielerNachAlterNullBeruecksichtigendUndDannNachName() {
	}
	
	/** 
	 * Etwas vergleichen, was auf natürliche Art verglichen werden kann.
	 * 
	 * Über Vergleicherunterstützer, Enum als Singelton.
	 * 
	 * Hinweise: enum VergleicherWieComparable implements Vergleicher<Comparable<Object>> {
	 */
	private static void sortiereNachNatuerlicherOrdnung() {
		
		// System.out.println(fussballerNummernVergleicher.vergleiche(new Fussballer(42), new Fussballer(40)));
	}	
}
