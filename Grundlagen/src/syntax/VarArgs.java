package syntax;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://stackoverflow.com/questions/14231037/java-safevarargs-annotation-does-a-standard-or-best-practice-exist
 *
 */
public class VarArgs {

	/**
	 * Gebe die Anzahl der uebergebenen Strings zurueck.
	 * Verwende Varargs.
	 * @param strings beliebig viele Strings
	 * @return Anzahl der uebergebenen Strings
	 * 
	 */
	@SafeVarargs
	static int gebeAnzahlStringsZurueck( String ... strings ) {	

		// Was macht der Compiler aus String ... strings, wenn "Hallo" und "Welt" uebergeben wird? 
		
		// String[] strings = new String[] { "Hallo", "Welt" };

		return strings.length;
	}

	@SafeVarargs
	static <T> int gebeAnzahlElementeZurueck( T ... beliebige ) {

		// Ist diese Methode varargs safe? Warum?
		
		// Wenn die übergebenen Parameter selber parameterisiert sind, 
		// kann Java daraus kein Array erzeugen.
		// Das kann Java also nicht: 
		// 		new T[] { ... }.
		// Statt dessen macht Java dann:
		// 		new KleinsteGemeinsameBasisklasseDerParameter[] { ... }
		// Kann also dann auch
		// 		new Object[] { ... }
		// sein, wenn das die kleinste gemeinsame Basisklasse ist.
		// Auch fuer diesen Fall muss die Methode funktionieren.
		// Die Methode ist Varargs-Safe, weil nur eine Methode von Object aufgerufen wird:		
		return beliebige.length;		
	}
	
	static <T> int demonstriereVarargsSafe( T erster, T zweiter ) {
		return gebeAnzahlElementeZurueck(erster, zweiter);
	}


	static <U> U[] gebeAlsArrayZurueckTypUnbekannt( U ... beliebige ) {
		
		// Ist diese Methode varargs safe? Warum?

		// Was macht der Compiler aus U ... beliebige, wenn U zwar parameterisiert, aber bekannt ist
		// also z.B. beim Aufruf gebeAlsArrayZurueckTypBekannt( "erster", "zweiter" ) ?

		// Dann macht Java daraus:
		// new String[] { ... } 
		// In diesem Fall ist alles OK, die Methode funktioniert.
		
		// *
		
		// Was macht der Compiler aus T ... beliebige, wenn T KEIN konreter Typ ist, 
		// also die übergebenen Parameter selber paramterisiert sind?
		// Wann wird das zum Problem?

		// Wenn die übergebenen Parameter selber parameterisiert sind, 
		// kann Java daraus kein Array erzeugen.
		// Das kann Java also nicht: 
		// 		new T[] { ... }.
		// Statt dessen macht Java dann:
		// 		new KleinsteGemeinsameBasisklasseDerParameter[] { ... }
		// Kann also dann auch
		// 		new Object[] { ... }
		// sein, wenn das die kleinste gemeinsame Basisklasse ist.
		// Auch fuer diesen Fall muss die Methode funktionieren.
		//
		// Die Methode ist also NICHT Varargs-Safe, weil hier ein
		// Array von Object zurückgegeben wird.

		return beliebige;
	}

	static <V> V[] demonstriereNichtVarargsSafe( V erster, V zweiter ) {
		return gebeAlsArrayZurueckTypUnbekannt(erster, zweiter);
	}
	
	/**
	 * Demonstriert best Practices fuer SafeVarargs.
	 * 
	 * @param <Z>
	 * @param beliebige
	 * @return Erstes Element, wenn vorhanden, sonst null
	 */
	@SafeVarargs
	static <Z> Z gebeErstesElementZurueck( Z ... beliebige ) {
		// Wie kann man sicher gehen, dass diese Methode auf alle Faelle Varargs-Safe ist?
		
		// Ich nutze hier aus, dass Arrays.asList Varargs-Safe ist. 
		return gebeErstesElementZurueck( Arrays.asList( beliebige ) );		
	}
	
	/**
	 * Demonstriert best Practices fuer SafeVarargs.
	 * @param <Z>
	 * @param beliebige
	 * @return Erstes Element, wenn vorhanden, sonst null
	 */
	static <Z> Z gebeErstesElementZurueck( List<Z> beliebige  ) {
		return beliebige.isEmpty() ? null : beliebige.getFirst();
	}

	@Test
	@DisplayName("Varargs mit konkretem Typ, hier String")
	public void teste01() {
		int anzahlStrings = gebeAnzahlStringsZurueck("eins", "zwei", "drei");
		assertEquals(
				3, 
				anzahlStrings );
	}	
	
	@Test
	@DisplayName("@SafeVarargs richtig verwendet")
	public void test02() {
		int anzahlElemente = demonstriereVarargsSafe("erster", "zweiter");
		assertEquals(
				2, 
				anzahlElemente );
	}	
	
	@Test
	@DisplayName("Wenn die Methode nicht Varargs Safe ist, aber mit konkretem Typ aufgerufen wird, ist es OK")
	public void test03() {
		String[] ergebnis = gebeAlsArrayZurueckTypUnbekannt("erster", "zweiter");

		assertEquals(
				"erster", 
				ergebnis[0] );
		assertEquals(
				"zweiter", 
				ergebnis[1] );
	}

	@Test
	@DisplayName("Wenn die Methode nicht Varargs Safe ist und mit parameterisierten Typen aufgerufen wird, "
			+ "soll sie eine Exception werfen")
	@SuppressWarnings("unused")
	public void test04() {
		assertThrows(
				ClassCastException.class, 
				()-> { String[] ergebnisString = demonstriereNichtVarargsSafe("erster", "zweiter");	}
		);			
	}
	
	@Test
	@DisplayName("Wenn ein erstes Element vorhanden ist, soll es zurueckgegeben werden.")
	public void test05() {
		assertEquals(
				"erster", 
				gebeErstesElementZurueck( "erster", "zweiter" ) );
	}
	
	@Test
	@DisplayName("Wenn kein Element vorhanden ist, soll null zurueckgegeben werden.")
	public void test06() {
		assertNull( gebeErstesElementZurueck( ) );
	}	
		
}