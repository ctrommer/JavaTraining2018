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
	 * Schreibe Methode von MyVergleicher, die einen Vergleicher erzeugt, der Elemente r�ckw�rts vergleicht, die 
	 * Comparable implementieren.
	 * Verwende die Methode, um Integer r�ckw�rts zu sortieren. 
	 */
	private static void vergleicheIntegerRueckwaerts() {

	}

	/**
	 * Mit Methode, die einen Vergleichskriteriumextrahierer und einen Rueckwaertsvergleicher nimmt.  
	 * 	  
	 * Beachte dabei den Unterschied zwischen anonymer innerer Klasse und lambda.
	 * 
	 * F�r die �bung mit eigenem Vergleicher starke Vereinfachung akzeptabel.
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
	 * - Methode, die einem Vergleicher einen weiteren Vergleicher hinzuf�gt. 
	 * - Methode die die zwei Vergleicher zusammenf�gt 
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
	 * Etwas vergleichen, was auf nat�rliche Art verglichen werden kann.
	 */
	private static void sortiereNachNatuerlicherOrdnung() {
		// System.out.println(fussballerNummernVergleicher.vergleiche(new Fussballer(42), new Fussballer(40)));
	}	
}
