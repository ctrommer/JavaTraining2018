package training;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MethodReferenz {

	/**
	 * Verwandelt Kleinbuchstaben in Großbuchstaben mit Function mit Method Referenz.
	 * 
	 * Referenz auf Instanzmethode eines beliebigen Objekts eines bestimmtenTyps.
	 * 
	 * Nur zum Demonstrieren der Syntax, es ginge natürlich einfacher ohne Method Referenz. 
	 */
	private String kleinZuGrossMitMethodReferenz( String text ) {
		return null;
	}	

	/**
	 * Mitarbeiternamen zu Grossbuchstaben:
	 * Mit Method Referenz. Verwendet Methode von Mitarbeiter.
	 * @param mitarbeiter
	 * Mitarbeiter, deren Namen in Grossbuchstaben verwandelt werden sollen.
	 */
	private void mitarbeiternameZuGrossbuchstabenMitMethodReferenz( List<Mitarbeiter> mitarbeiter ) {
	}

	private void fansHinzufuegenMitConsumerUndLambda( Schauspieler schauspieler, List<Mitarbeiter> neueFans ) {
	}

	private void fansHinzufuegenMitConsumerUndMethodReferenz( Schauspieler schauspieler, List<Mitarbeiter> neueFans ) {
	}

	/**
	 * Mitarbeiter aus Namen erzeugen.
	 * Mit Method Referenz auf Konstruktor.
	 * @param mitarbeiterName
	 * Name des Mitarbeiters.
	 * @return
	 * Mitarbeiter mit dem als Parameter übergebenen Namen.
	 */
	private Mitarbeiter nameZuMitarbeiterMitLambdaUndFunction( String mitarbeiterName ) {
		return null;				
	}

	/**
	 * Mitarbeiter aus Namen erzeugen.
	 * Mit Method Referenz auf Konstruktor.
	 * @param mitarbeiterName
	 * Name des Mitarbeiters.
	 * @return
	 * Mitarbeiter mit dem als Parameter übergebenen Namen.
	 */
	private Mitarbeiter nameZuMitarbeiterMitMethodReferenzUndFunction( String mitarbeiterName ) {
		return null;
	}

	/**
	 * Verwende Konstruktor Referenz um eine Map zu füllen, die den Mitarbeiternamen als Key und
	 * den Mitarbeiter als Value hat.
	 * 
	 * @param mitarbeiterName
	 * Mitarbeiter mit diesem Namen wird erzeugt.
	 * @return
	 * Aus dem Namen erzeugter Mitarbeiter.
	 */
	private Map<String, Mitarbeiter> nameZuMitarbeiterMapMitReferenzAufKonstruktor( String mitarbeiterName ) {
		Map<String, Mitarbeiter> mitarbeiterMap = new HashMap<>();
		return mitarbeiterMap;
	}

	/**
	 * Wandelt double in String mit Function und Method Referenz auf statische Methode von String.
	 */
	private String doubleZuStringMitFunctionUndMethodReferenz( Double zahl ) {
		return null;
	}

	/**
	 * Mitarbeiter zu den besten Mitarbeitern hinzufuegen
	 * Mit Referenz auf statische Methode ( von Mitarbeiter )
	 * @param mitarbeiters
	 * Mitarbeiter, die zu den besten Mitarbeitern hinzugefügt werden sollen.
	 */
	private static void mitarbeiterZuBestenMitarbeiternHinzufuegenMitReferenzAufStatischeMethode( List<Mitarbeiter> mitarbeiters ) {		

	}

}
