package training;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OptionalTrainer {

	/**
	 * Erzeuge ein leeres Optional.
	 * @return
	 * Optional ohne Inhalt
	 */
	private Optional<Object> erzeugeLeeresOptional( ) {
		 return null;
	}
	
	@Test
	@DisplayName( "erzeugeLeeresOptional soll ein leeres Optional erzeugen" )
	public void test01() {
		assertEquals( 
				Optional.empty(), 
				erzeugeLeeresOptional() );
	}
	
	/**
	 * Erzeuge ein Optional aus dem übergebenen Wert. Gib den Inhalt des
	 * Optional zurück, wenn der Inhalt ungleich null ist, sonst den defaultwert.   
	 * @param text
	 * darf null sein
	 * @param defaultWert
	 * wird verwendet, wenn der erste Parameter null ist 
	 * @return
	 * Inhalt des Optionals wenn ungleich null sonst der Defaultwert
	 * 
	 */
	private String wennTextNullDannDefault( String text, String defaultWert ) {
		return null;
	}

	@Test
	@DisplayName( "wennTextNullDannDefault soll Optional aus dem übergebenen Text erzeugen " )
	public void test02() {
		String erwartetesErgebnis = "Inhalt des Optionals";
		
		assertSame(
				erwartetesErgebnis, 
				wennTextNullDannDefault( erwartetesErgebnis, "nicht verwendeter default Wert" ) );		
	}

	@Test
	@DisplayName( "wennTextNullDannDefault soll Default Wert verwenden, wenn der übergebene Text null ist" )
	public void test03() {
		String erwartetesErgebnis = "kein Text";
		assertSame( 
				erwartetesErgebnis, 
				wennTextNullDannDefault( null, erwartetesErgebnis) );
	}	

	/**
	 * Erzeuge aus dem übergebenen Wert ein Optional.
	 * @param text
	 * Darf nicht null sein.
	 * @return
	 * Optional wenn parameter ungleich null.
	 * @throws
	 * NullPointerException wenn text null.
	 * 
	 */
	private Optional<String> erzeugeOderWirfExceptionWennNull( String text ) {
		return null;
	}

	@Test
	@DisplayName( "erzeugeOderWirfExceptionWennNull soll ein Optional erzeugen, wenn der übergebene Wert ungleich null ist" )
	public void test04() {
		String erwartetesErgebnis = "Hallo";

		assertSame( 
				erwartetesErgebnis, 
				erzeugeOderWirfExceptionWennNull( erwartetesErgebnis ).orElse("falscher Wert") );
	}

	@Test
	@DisplayName( "erzeugeOderWirfExceptionWennNull soll Nullpointer exception werfen, wenn der übergebene Wert null ist" )
	public void test05() {
		assertThrows(
				NullPointerException.class, 
				()-> erzeugeOderWirfExceptionWennNull( null ) );
	}
	
	/**
	 * Mit anonymer innerer Klasse.
	 * 
	 * Wenn inhalt vorhanden, gib diesen Inhalt zurueck.
	 * Sonst wirf eine IllegalStateException.
	 * 
	 * @param vielleichtText
	 * @return inhalt, wenn dieser ungleich null
	 */
	private String inhaltOderIllegalStateExceptionMitAnonymerKlasse( Optional<String> vielleichtText ) {
		return null;
	}

	@Test
	@DisplayName("inhaltOderIllegalStateExceptionMitAnonymerKlasse soll Inhalt zurueckgegeben, wenn er vorhanden ist")
	public void test06() {
		String erwarteterWert = "Inhalt von Optional";
		Optional<String> optionalMitInhaltHallo = Optional.ofNullable( erwarteterWert );

		assertSame(
				erwarteterWert, 
				inhaltOderIllegalStateExceptionMitAnonymerKlasse( optionalMitInhaltHallo ) );
	}
	
	@Test
	@DisplayName("inhaltOderIllegalStateExceptionMitAnonymerKlasse soll eine IllegalStateException werfen, wenn Inhalt null ist")
	public void test07() {
		Assertions.assertThrows(
							IllegalStateException.class, 
							() -> inhaltOderIllegalStateExceptionMitAnonymerKlasse( Optional.empty() ) );
	}

	/**
	 * Mit Lambda.
	 * 
	 * Wenn inhalt vorhanden, gib diesen Inhalt zurueck.
	 * Sonst wirf eine IllegalStateException.
	 * 
	 * @param vielleichtText
	 * @return inhalt, wenn dieser ungleich null
	 */
	private String inhaltOderIllegalStateExceptionMitLambda( Optional<String> vielleichtText ) {
		return null;
	}
	
	@Test
	@DisplayName("inhaltOderIllegalStateExceptionMitLambda soll Inhalt zurueckgegeben, wenn er vorhanden ist")
	public void test08() {
		String erwarteterWert = "Inhalt von Optional";
		assertSame(
				erwarteterWert, 
				inhaltOderIllegalStateExceptionMitLambda( Optional.ofNullable( erwarteterWert ) ) );
	}
	
	@Test
	@DisplayName("inhaltOderIllegalStateExceptionMitLambda soll IllegalStateException werfen, wenn Inhalt null ist")
	public void test09() {
		Assertions.assertThrows(
							IllegalStateException.class, 
							() -> inhaltOderIllegalStateExceptionMitLambda( Optional.empty() ) );
	}

	/**
	 * Mit Method Referenz.
	 * 
	 * Wenn inhalt vorhanden, gib diesen Inhalt zurueck.
	 * Sonst wirf eine IllegalStateException.
	 * 
	 * @param vielleichtText
	 * @return inhalt, wenn dieser ungleich null
	 */
	private String inhaltOderIllegalStateExceptionMitMethodReferenz( Optional<String> vielleichtText ) {
		return null;
	}

	@Test
	@DisplayName("inhaltOderIllegalStateExceptionMitMethodReferenz soll Inhalt zurueckgegeben, wenn er vorhanden ist")
	public void test10() {
		String erwarteterWert = "Inhalt von Optional";
		assertSame(
				erwarteterWert, 
				inhaltOderIllegalStateExceptionMitMethodReferenz( Optional.ofNullable( erwarteterWert ) ) );
	}
	
	@Test
	@DisplayName("inhaltOderIllegalStateExceptionMitMethodReferenz soll IllegalStateException werfen, wenn Inhalt null ist")
	public void test11() {
		Assertions.assertThrows(
							IllegalStateException.class, 
							() -> inhaltOderIllegalStateExceptionMitMethodReferenz( Optional.empty() ) );
	}	

	/**
	 * Wenn Person ungleich null ist,  
	 * Beruf von Person ungleich null ist 
	 * und Beruf einen Inhalt ungleich Whitespaces hat,
	 * wird dem Beruf der Person ein ":in" angehaengt.
	 * @param person
	 * person, darf auch null sein.
	 */
	private void berufGendern( Person person  ) {
		person.setBeruf("Damit Unittest fehlschlaegt.");
	}

	@Test
	@DisplayName("berufGendern soll Beruf nicht gendern, wenn Person null ist")
	public void test12() {
		Person person = null;
		berufGendern( person );

		assertNull( person );	
	}

	@Test
	@DisplayName("berufGendern soll Beruf nicht gegendern, wenn Beruf null ist")
	public void test13() {
		Person person = new Person(null);
		berufGendern( person );
		
		assertNull( person.getBeruf() );
	}

	@Test
	@DisplayName("berufGendern soll Beruf nicht gegendern, wenn Beruf nur whitespaces enthaelt")
	public void test14() {
		Person person = new Person(" ");
		berufGendern( person );
		
		assertTrue( person
						.getBeruf()
						.equals(" ") );		
	}

	@Test
	@DisplayName("berufGendern soll :in an Beruf anhaengen, wenn Beruf vorhanden ist")
	public void test15() {
		Person person = new Person( "Kanzler" );
		berufGendern( person );
		
		assertTrue( person
						.getBeruf()
						.equals( "Kanzler:in" ) );		
	}
	
	/**
	 * Achtung: Sollte man nur im äussersten Notfall verwenden.
	 * 
	 * @param vielleichtText
	 * Inhalt kann auch leer sein.
	 * @param wertWennOptionalLeer
	 * Wert für den Fall, das Optional leer ist
	 * @return
	 * Inhalt wenn vorhanden, sonst wertWennOptionalLeer.
	 */
	private String demonstriereVeraltetenZugriff( Optional<String> vielleichtText, String wertWennOptionalLeer ) {
		return "";
	}

	@Test
	@DisplayName("demonstriereVeraltetenZugriff soll leer liefern, wenn das Optional leer ist")
	public void test16() {
		String defaultWert = "leer";
		
		assertSame( 
				defaultWert,  
				demonstriereVeraltetenZugriff( 
										Optional.empty(), 
										defaultWert ) );
	}
	
	@Test
	@DisplayName("demonstriereVeraltetenZugriff soll Inhalt von Optional liefern, wenn das Optional nicht leer ist")
	public void test17() {
		String erwartetesErgebnis = "inhalt von Optional";
		
		assertSame( 
				erwartetesErgebnis, 
				demonstriereVeraltetenZugriff(
										Optional.ofNullable( erwartetesErgebnis ), 
										"default Wert" ) );		
	}

	/**
	 * Erzeuge aus der Person ein Optional, ermittle daraus das Gewicht.
	 * @param person
	 * Darf null sein, ihr Gewicht darf auch null sein.
	 * @return
	 * Wenn das Gewicht der Person nicht leer ist, das Gewicht der Person, 100 sonst.
	 */
	private Integer vielleichtGewichtOder100( Person person ) {
		return null;
	}

	@Test
	@DisplayName("vielleichtGewichtOder100 soll 100 liefern, wenn die Person null ist")
	public void test18() {
		assertSame( 
				100, 
				vielleichtGewichtOder100( null ) );
	}
	
	@Test
	@DisplayName("vielleichtGewichtOder100 soll 100 liefern, wenn das Gewicht der Person null ist")
	public void test19() {
		Person arnold = new Person( "Arnold" );		
		
		assertSame( 
				100, 
				vielleichtGewichtOder100( arnold ) );

	}
	
	@Test
	@DisplayName("vielleichtGewichtOder100 soll 120 liefern, wenn das Gewicht der Person 120 ist")
	public void test20() {
		Person arnold = new Person( "Arnold" );
		arnold.setVielleichtGewicht( Optional.ofNullable( 120 ) );
		
		assertSame( 
				120, 
				vielleichtGewichtOder100( arnold ) );
	}
	
}
