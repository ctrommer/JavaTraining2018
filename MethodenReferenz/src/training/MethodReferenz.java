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

	@Test
	@DisplayName("Werden Kleinbuchstaben in Grossbuchstaben umgewandelt?")
	public void test01() {
		assertEquals(
				("kleinbuchstaben").toUpperCase(Locale.GERMAN), 
				kleinZuGrossMitMethodReferenz("kleinbuchstaben") );
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
	@DisplayName("Werden Namen der Mitarbeiter in Grossbuchstaben umgewandelt?")
	public void test02() {		
		List<Mitarbeiter> mitarbeiterListe = Arrays.asList(	new Mitarbeiter("Albert"), new Mitarbeiter("Bert" ) );
		mitarbeiternameZuGrossbuchstabenMitMethodReferenz( mitarbeiterListe );
		assertEquals(
				Arrays.asList( new Mitarbeiter("ALBERT"), new Mitarbeiter("BERT") ), 
				mitarbeiterListe );
	}

	private void fansHinzufuegenMitConsumerUndLambda( Schauspieler schauspieler, List<Mitarbeiter> neueFans ) {
	}

	@Test
	@DisplayName("Werden die Fans hinzugefuegt mit Consumer und Lambda?")
	public void test03() {
		Schauspieler arnold = new Schauspieler("I'll be back");
		List<Mitarbeiter> mitarbeiterListe = Arrays.asList( 
														new Mitarbeiter( "Karl" ), 
														new Mitarbeiter( "Hans" ), 
														new Mitarbeiter( "Egon" ) );

		fansHinzufuegenMitConsumerUndLambda( arnold, mitarbeiterListe );		
		
		assertEquals(
				mitarbeiterListe, 
				arnold.getFans() );
	}

	private void fansHinzufuegenMitConsumerUndMethodReferenz( Schauspieler schauspieler, List<Mitarbeiter> neueFans ) {
	}

	@Test
	@DisplayName("Werden die Fans hinzugefuegt mit Consumer und Method Referenz?")
	public void test04() {
		Schauspieler arnold = new Schauspieler("I'll be back");
		List<Mitarbeiter> neueFansVonArnold = Arrays.asList(
														new Mitarbeiter( "Karl" ), 
														new Mitarbeiter( "Hans" ), 
														new Mitarbeiter( "Egon" ) );

		fansHinzufuegenMitConsumerUndMethodReferenz( arnold, neueFansVonArnold );
		
		assertEquals( 
				neueFansVonArnold, 
				arnold.getFans() );				
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

	@Test
	@DisplayName("Wird Name in Mitarbeiter umgewandelt mit Lambda und Function?")
	public void test05() {
		assertEquals(
				new Mitarbeiter("Karl"), 
				nameZuMitarbeiterMitLambdaUndFunction("Karl") );
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

	@Test
	@DisplayName("Wird der Name in Mitarbeiter umgewandelt?")
	public void test06() {
		assertEquals(
				new Mitarbeiter("Karl"), 
				nameZuMitarbeiterMitMethodReferenzUndFunction("Karl") );
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

	@Test
	@DisplayName("Wird Name in Map mit Name als Key und Mitarbeiter als Value umgewandelt?")
	public void test07( ) {
		Map<String, Mitarbeiter> mitarbeiterMap = new HashMap<>();
		String karl = "Karl";
		mitarbeiterMap.put( karl, new Mitarbeiter( karl ) );

		assertEquals(
				mitarbeiterMap, 
				nameZuMitarbeiterMapMitReferenzAufKonstruktor( karl ) );
	}

	/**
	 * Wandelt double in String mit Function und Method Referenz auf statische Methode von String.
	 */
	private String doubleZuStringMitFunctionUndMethodReferenz( Double zahl ) {
		return null;
	}

	@Test
	@DisplayName("Wird double mit Function in String umgewandelt?")
	public void test08() {
		assertEquals( 
				"42.3", 
				doubleZuStringMitFunctionUndMethodReferenz( 42.3 ) );
	}

	/**
	 * Mitarbeiter zu den besten Mitarbeitern hinzufuegen
	 * Mit Referenz auf statische Methode ( von Mitarbeiter )
	 * @param mitarbeiters
	 * Mitarbeiter, die zu den besten Mitarbeitern hinzugefügt werden sollen.
	 */
	private static void mitarbeiterZuBestenMitarbeiternHinzufuegenMitReferenzAufStatischeMethode( List<Mitarbeiter> mitarbeiters ) {		

	}

	@Test
	@DisplayName("Wird Mitarbeiter zu besten Mitarbeitern hinzugefuegt?")
	public void test09( ) {
		List<Mitarbeiter> mitarbeiterListe = Arrays.asList( new Mitarbeiter( "Karl" ), new Mitarbeiter( "Hans" ), new Mitarbeiter( "Egon" ) );
	
		mitarbeiterZuBestenMitarbeiternHinzufuegenMitReferenzAufStatischeMethode(mitarbeiterListe);

		assertEquals( 
				mitarbeiterListe, 
				Mitarbeiter.getBestenMitarbeiter() );
	}
	
}
