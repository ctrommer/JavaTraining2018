package training;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

import org.junit.jupiter.api.Test;

import methodenReferenz.Mitarbeiter;
import methodenReferenz.Schauspieler;

public class MethodReferenz {

	/**
	 * Verwandelt Kleinbuchstaben in Gro�buchstaben mit Function mit Method Referenz.
	 * 
	 * Referenz auf Instanzmethode eines beliebigen Objekts eines bestimmtenTyps.
	 * 
	 * Nur zum Demonstrieren der Syntax, es ginge nat�rlich einfacher ohne Method Referenz. 
	 */
	private String kleinZuGrossMitMethodReferenz( String text ) {

		return null;
	}	

	@Test
	public void testeKleinZuGrossMitMethodReferenz() {
		assertEquals(("kleinbuchstaben").toUpperCase(), kleinZuGrossMitMethodReferenz("kleinbuchstaben"));
	}

	/**
	 * Mitarbeiternamen zu Grossbuchstaben:
	 * Mit Method Referenz. Verwendet Methode von Mitarbeiter.
	 * @param mitarbeiter
	 * Mitarbeiter, deren Namen in Grossbuchstaben verwandelt werden sollen.
	 */
	private void mitarbeiternameZuGrossbuchstabenMitMethodReferenz( List<Mitarbeiter> mitarbeiter ) {
		
	}
	
	@Test
	public void testeMitarbeiternameZuGrossbuchstabenMitMethodReferenz() {		
		List<Mitarbeiter> mitarbeiterListe = Arrays.asList(new Mitarbeiter("Albert"), new Mitarbeiter("Bert" ) );
		mitarbeiternameZuGrossbuchstabenMitMethodReferenz(mitarbeiterListe);
		assertEquals(Arrays.asList(new Mitarbeiter("ALBERT"), new Mitarbeiter("BERT" ) ), mitarbeiterListe);
	}

	private void fansHinzufuegenMitConsumerUndLambda( Schauspieler schauspieler, List<Mitarbeiter> neueFans ) {

	}

	@Test
	public void testeFansHinzufuegenMitConsumerUndLambda() {
		Schauspieler arnold = new Schauspieler("I'll be back");
		List<Mitarbeiter> mitarbeiterListe = Arrays.asList(new Mitarbeiter( "Karl" ), new Mitarbeiter( "Hans" ), new Mitarbeiter( "Egon" ));

		fansHinzufuegenMitConsumerUndLambda(arnold, mitarbeiterListe);		
		
		assertEquals(mitarbeiterListe, arnold.getFans());
	}

	private void fansHinzufuegenMitConsumerUndMethodReferenz( Schauspieler schauspieler, List<Mitarbeiter> neueFans ) {

	}
	
	@Test
	public void testeFansHinzufuegenMitConsumerUndMethodReferenz() {
		Schauspieler arnold = new Schauspieler("I'll be back");
		List<Mitarbeiter> neueFansVonArnold = Arrays.asList(new Mitarbeiter( "Karl" ), new Mitarbeiter( "Hans" ), new Mitarbeiter( "Egon" ));

		fansHinzufuegenMitConsumerUndMethodReferenz(arnold, neueFansVonArnold);		
		
		assertEquals(neueFansVonArnold, arnold.getFans());				
	}
	
	/**
	 * Mitarbeiter aus Namen erzeugen.
	 * Mit Method Referenz auf Konstruktor.
	 * @param mitarbeiterName
	 * Name des Mitarbeiters.
	 * @return
	 * Mitarbeiter mit dem als Parameter �bergebenen Namen.
	 */
	private Mitarbeiter nameZuMitarbeiterMitLambdaUndFunction( String mitarbeiterName ) {

		
		return null;				
	}

	@Test
	public void testeNameZuMitarbeiterMitLambdaUndFunction() {
		assertEquals(new Mitarbeiter("Karl"), nameZuMitarbeiterMitLambdaUndFunction("Karl"));
	}

	/**
	 * Mitarbeiter aus Namen erzeugen.
	 * Mit Method Referenz auf Konstruktor.
	 * @param mitarbeiterName
	 * Name des Mitarbeiters.
	 * @return
	 * Mitarbeiter mit dem als Parameter �bergebenen Namen.
	 */
	private Mitarbeiter nameZuMitarbeiterMitMethodReferenzUndFunction( String mitarbeiterName ) {

		return null;
	}
	
	@Test
	public void testeNameZuMitarbeiterMitMethodReferenzUndFunction() {
		assertEquals(new Mitarbeiter("Karl"), nameZuMitarbeiterMitMethodReferenzUndFunction("Karl"));
	}

	/**
	 * Verwende Konstruktor Referenz um eine Map zu f�llen, die den Mitarbeiternamen als Key und
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
	
	@Test
	public void testeNameZuMitarbeiterMapMitReferenzAufKonstruktor( ) {
		Map<String, Mitarbeiter> mitarbeiterMap = new HashMap<>();
		String karl = "Karl";
		mitarbeiterMap.put(karl, new Mitarbeiter(karl));
		
		assertEquals(mitarbeiterMap, nameZuMitarbeiterMapMitReferenzAufKonstruktor(karl));
	}

	/**
	 * Wandelt double in String mit Function und Method Referenz auf statische Methode von String.
	 */
	private String doubleZuStringMitFunctionUndMethodReferenz( Double zahl ) {

		
		return null;
	}

	@Test
	public void testeDoubleZuStringMitFunctionUndMethodReferenz() {
		assertEquals("42.3", doubleZuStringMitFunctionUndMethodReferenz(42.3));
	}

	/**
	 * Mitarbeiter zu den besten Mitarbeitern hinzufuegen
	 * Mit Referenz auf statische Methode ( von Mitarbeiter )
	 * @param mitarbeiters
	 * Mitarbeiter, die zu den besten Mitarbeitern hinzugef�gt werden sollen.
	 */
	private static void mitarbeiterZuBestenMitarbeiternHinzufuegenMitReferenzAufStatischeMethode( List<Mitarbeiter> mitarbeiters ) {		

	}

	@Test
	public void testeMitarbeiterZuBestenMitarbeiternHinzufuegenMitReferenzAufStatischeMethode( ) {
		List<Mitarbeiter> mitarbeiterListe = Arrays.asList(new Mitarbeiter( "Karl" ), new Mitarbeiter( "Hans" ), new Mitarbeiter( "Egon" ));
	
		mitarbeiterZuBestenMitarbeiternHinzufuegenMitReferenzAufStatischeMethode(mitarbeiterListe);

		assertEquals( mitarbeiterListe, Mitarbeiter.getBestenMitarbeiter() );
	}
	
}