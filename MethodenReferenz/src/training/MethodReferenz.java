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
	 * Verwandelt Kleinbuchstaben in Großbuchstaben mit Function mit Method Referenz.
	 * 
	 * Referenz auf Instanzmethode eines beliebigen Objekts eines bestimmtenTyps.
	 * 
	 * Nur zum Demonstrieren der Syntax, es ginge natürlich einfacher ohne Method Referenz. 
	 */
	private String kleinZuGrossMitMethodReferenz( String text ) {
		Function<String, String> zuGrossbuchstaben = String::toUpperCase;
		
		return zuGrossbuchstaben.apply(text);
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
		mitarbeiter.forEach(Mitarbeiter::nameZuGrossbuchstaben);
	}
	
	@Test
	public void testeMitarbeiternameZuGrossbuchstabenMitMethodReferenz() {		
		List<Mitarbeiter> mitarbeiterListe = Arrays.asList(new Mitarbeiter("Albert"), new Mitarbeiter("Bert" ) );
		mitarbeiternameZuGrossbuchstabenMitMethodReferenz(mitarbeiterListe);
		assertEquals(Arrays.asList(new Mitarbeiter("ALBERT"), new Mitarbeiter("BERT" ) ), mitarbeiterListe);		
	}

	private void fansHinzufuegenMitConsumerUndLambda( Schauspieler schauspieler, List<Mitarbeiter> neueFans ) {
		Consumer<Mitarbeiter> schauspielerFuegtFanHinzu  = mitarbeiter -> schauspieler.fanHinzufuegen(mitarbeiter);
		neueFans.forEach(schauspielerFuegtFanHinzu);		
	}

	@Test
	public void testeFansHinzufuegenMitConsumerUndLambda() {
		Schauspieler arnold = new Schauspieler("I'll be back");
		List<Mitarbeiter> mitarbeiterListe = Arrays.asList(new Mitarbeiter( "Karl" ), new Mitarbeiter( "Hans" ), new Mitarbeiter( "Egon" ));

		fansHinzufuegenMitConsumerUndLambda(arnold, mitarbeiterListe);		
		
		assertEquals(mitarbeiterListe, arnold.getFans());
	}

	private void fansHinzufuegenMitConsumerUndMethodReferenz( Schauspieler schauspieler, List<Mitarbeiter> neueFans ) {
		Consumer<Mitarbeiter> schauspielerFuegtFanHinzu  = schauspieler::fanHinzufuegen;
		neueFans.forEach(schauspielerFuegtFanHinzu);
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
	 * Mitarbeiter mit dem als Parameter übergebenen Namen.
	 */
	private Mitarbeiter nameZuMitarbeiterMitLambdaUndFunction( String mitarbeiterName ) {
		Function<String, Mitarbeiter> stringZuPerson = name -> new Mitarbeiter(name); 
		
		return stringZuPerson.apply(mitarbeiterName);				
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
	 * Mitarbeiter mit dem als Parameter übergebenen Namen.
	 */
	private Mitarbeiter nameZuMitarbeiterMitMethodReferenzUndFunction( String mitarbeiterName ) {
		// Erst sinnvoll, wenn es als Parameter übergeben wird.
		Function<String, Mitarbeiter> stringZuPerson = Mitarbeiter::new;		// s -> new Mitarbeiter(s);
		
		return stringZuPerson.apply(mitarbeiterName);
	}
	
	@Test
	public void testeNameZuMitarbeiterMitMethodReferenzUndFunction() {
		assertEquals(new Mitarbeiter("Karl"), nameZuMitarbeiterMitMethodReferenzUndFunction("Karl"));
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
		
		Function<String, Mitarbeiter> stringZuMitarbeiter = Mitarbeiter::new;	// s -> new Mitarbeiter(s);

		mitarbeiterMap.computeIfAbsent(mitarbeiterName, stringZuMitarbeiter);
		
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
		Function<Double, String> doubleToString = String::valueOf; 		// n -> String.valueOf(n)
		
		return doubleToString.apply(zahl);
	}

	@Test
	public void testeDoubleZuStringMitFunctionUndMethodReferenz() {
		assertEquals("42.3", doubleZuStringMitFunctionUndMethodReferenz(42.3));
	}

	/**
	 * Mitarbeiter zu den besten Mitarbeitern hinzufuegen
	 * Mit Referenz auf statische Methode ( von Mitarbeiter )
	 * @param mitarbeiters
	 * Mitarbeiter, die zu den besten Mitarbeitern hinzugefügt werden sollen.
	 */
	private static void mitarbeiterZuBestenMitarbeiternHinzufuegenMitReferenzAufStatischeMethode( List<Mitarbeiter> mitarbeiters ) {		
		Consumer<Mitarbeiter> zuGrossBuchstaben = Mitarbeiter::fuegeBestenMitarbeiterHinzu;
		mitarbeiters.forEach(zuGrossBuchstaben);
	}

	@Test
	public void testeMitarbeiterZuBestenMitarbeiternHinzufuegenMitReferenzAufStatischeMethode( ) {
		List<Mitarbeiter> mitarbeiterListe = Arrays.asList(new Mitarbeiter( "Karl" ), new Mitarbeiter( "Hans" ), new Mitarbeiter( "Egon" ));
	
		mitarbeiterZuBestenMitarbeiternHinzufuegenMitReferenzAufStatischeMethode(mitarbeiterListe);

		assertEquals( mitarbeiterListe, Mitarbeiter.getBestenMitarbeiter() );
	}
	
}
