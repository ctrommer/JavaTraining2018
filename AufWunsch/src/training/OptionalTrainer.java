package training;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;
import java.util.function.Supplier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import optionalBeispiel.Person;

public class OptionalTrainer {

	private void setzeVielleichtGewichtLeer( Person person ) {

	}
	
	@Test
	public void testeSetzeVielleichtGewichtLeer() {
		Person person = new Person("Arnold");
		person.setVielleichtGewicht(Optional.of(100));
		assertNotEquals(Optional.empty(), person.getVielleichtGewicht());
		
		setzeVielleichtGewichtLeer(person);
		assertEquals(Optional.empty(), person.getVielleichtGewicht());		
	}
	
	/**
	 * Erzeuge aus dem übergebenen Wert ein Optional.
	 * @param text
	 * Darf null sein.
	 * @return
	 * Inhalt des Optionals wenn ungleich null sonst "kein Text".
	 * 
	 */
	private String textOderKeinTextNullErlaubt( String text ) {
		String defaultWert = "kein Text";
		return null;
	}

	@Test
	public void testeTextOderKeinTextNullErlaubt() {
		String hallo = "Hallo";
		
		assertSame(hallo, textOderKeinTextNullErlaubt(hallo));
		
		assertSame("kein Text", textOderKeinTextNullErlaubt(null));
	}

	/**
	 * Erzeuge aus dem übergebenen Wert ein Optional.
	 * @param text
	 * Darf nicht null sein.
	 * @return
	 * Inhalt des Optionals wenn ungleich null.
	 * @throws
	 * NullPointerException wenn text null.
	 * 
	 */
	private String textOderKeinTextNullVerboten( String text ) {
		return null;
	}

	@Test
	public void testeTextOderKeinTextNullVerboten() {
		String hallo = "Hallo";
		
		assertSame(hallo, textOderKeinTextNullVerboten(hallo));
		
		assertThrows(NullPointerException.class, ()-> textOderKeinTextNullVerboten(null));
	}	

	private String inhaltOderIllegalStateExceptionMitAnonymerKlasse( Optional<String> vielleichtText ) {
		return null;
	}

	private String inhaltOderIllegalStateExceptionMitLambda( Optional<String> vielleichtText ) {
		return null;
	}	

	private String inhaltOderIllegalStateExceptionMitMethodReferenz( Optional<String> vielleichtText ) {
		return null;
	}

	@Test
	public void testeOptionalOderException() {
		String hallo = "Hallo";
		Optional<String> optionalMitInhaltHallo = Optional.ofNullable(hallo);
		Optional<String> leeresOptional = Optional.empty();

		assertSame(hallo, inhaltOderIllegalStateExceptionMitAnonymerKlasse(optionalMitInhaltHallo));
    	Assertions.assertThrows(IllegalStateException.class, () -> inhaltOderIllegalStateExceptionMitAnonymerKlasse(leeresOptional));

		assertSame(hallo, inhaltOderIllegalStateExceptionMitLambda(optionalMitInhaltHallo));
    	Assertions.assertThrows(IllegalStateException.class, () -> inhaltOderIllegalStateExceptionMitLambda(leeresOptional));

		assertSame(hallo, inhaltOderIllegalStateExceptionMitMethodReferenz(optionalMitInhaltHallo));
    	Assertions.assertThrows(IllegalStateException.class, () -> inhaltOderIllegalStateExceptionMitMethodReferenz(leeresOptional));
	}

	/**
	 * Wenn Person oder Name von Person null ist wird nichts gemacht, 
	 * sonst wird bei leerem Namen der Name auf NN gesetzt.
	 * @param person
	 * person, darf auch null sein.
	 */
	private void wennNameLeerSetzeNameNN( Person person ) {
	}

	@Test
	public void testeWennNameLeerSetzeNameNN() {
		Person person = null;
		wennNameLeerSetzeNameNN(person);
		assertNull(person);
		
		person = new Person(null);
		wennNameLeerSetzeNameNN(person);
		assertNull(person.getName());

		String john = "John";
		person = new Person(john);
		wennNameLeerSetzeNameNN(person);
		assertTrue(person.getName().equals(john));
		
		person = new Person("");
		wennNameLeerSetzeNameNN(person);
		
		assertTrue(person.getName().equals("NN"));
	}
	
	/**
	 * Achtung: Sollte man nur im äussersten Notfall verwenden.
	 * 
	 * @param vielleichtText
	 * Inhalt kann auch leer sein.
	 * @return
	 * Inhalt wenn vorhanden, sonst den String "leer".
	 */
	private String demonstriereVeraltetenZugriff( Optional<String> vielleichtText ) {
		return "leer";
	}

	@Test
	public void testeDemonstriereVeraltetenZugriff() {
		assertSame( "leer",  demonstriereVeraltetenZugriff( Optional.empty() ) );

		String hallo = "Hallo";
		assertSame(hallo, demonstriereVeraltetenZugriff(Optional.ofNullable( hallo )));		
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
	public void testeGewichtOderDefault() {

		assertSame( 100, vielleichtGewichtOder100( null ) );

		Person arnold = new Person("Arnold");		
		assertSame( 100, vielleichtGewichtOder100( arnold ) );

		arnold.setVielleichtGewicht(Optional.ofNullable(120));
		assertSame(120, vielleichtGewichtOder100(arnold));

	}
	
}
