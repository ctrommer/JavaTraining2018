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
		vergleicheSpielerNachAlterRueckwaertsDirekt();
		vergleicheZeichenketteGrossKleinSchreibungIgnorierend();		
		vergleicheSpielerNachSpitznameRueckwaertsGrossKleinSchreibungIgnorierend();
		vergleicheSpielerNachAlterUndDannNachName();
		vergleicheSpielerNachAlterNullBeruecksichtigend();
		vergleicheSpielerNachAlterNullBeruecksichtigendReuckwaerts();
		vergleicheSpielerNachAlterNullBeruecksichtigendUndDannNachName();
		sortiereNachNatuerlicherOrdnung();
	}
	
	private static void vergleicheSpielerNachAlterMitAnonymerInnererKlasse() {
		
		// System.out.println(spielerVergleicher.vergleiche(new Spieler("Karl", 42), new Spieler("Albert", 14)));
	}

	private static void vergleicheSpielerNachAlterMitLambda() {

	}

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
	 * Mit Methode, die einen Vergleichskriteriumextrahierer und einen Rueckwaertsvergleicher nimmt.  
	 * 	  
	 * Beachte dabei den Unterschied zwischen anonymer innerer Klasse und lambda.
	 * 
	 * Für die Übung mit eigenem Vergleicher starke Vereinfachung akzeptabel.
	 * 
	 */
	private static void vergleicheSpielerNachAlterRueckwaerts() {

	}

	private static void vergleicheSpielerNachAlterRueckwaertsDirekt() {

	}

	private static void vergleicheZeichenketteGrossKleinSchreibungIgnorierend() {

	}	

	/**
	 * Sortieren nach Spitzname
	 */	
	private static void vergleicheSpielerNachSpitznameRueckwaertsGrossKleinSchreibungIgnorierend() {

	}

	/**
	 * Hierzu 2 Methoden schreiben:
	 * - Methode, die einem Vergleicher einen weiteren Vergleicher hinzufügt. 
	 * - Methode die die zwei Vergleicher zusammenfügt 
	 */
	private static void vergleicheSpielerNachAlterUndDannNachName() {

	}

	/**
	 * NullVergleicher zum Vergleichen erstellen.
	 * Parameter ist ein Vergleicher, also nicht eine Method-Referenz.  
	 */
	public static void vergleicheSpielerNachAlterNullBeruecksichtigend() {
	}

	public static void vergleicheSpielerNachAlterNullBeruecksichtigendReuckwaerts() {
	}

	private static void vergleicheSpielerNachAlterNullBeruecksichtigendUndDannNachName() {
	}
	
	/** 
	 * Etwas vergleichen, was auf natürliche Art verglichen werden kann.
	 */
	private static void sortiereNachNatuerlicherOrdnung() {
		// System.out.println(fussballerNummernVergleicher.vergleiche(new Fussballer(42), new Fussballer(40)));
	}	
}
