package syntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
	static int gebeAnzahlStringsZurueck( String durchVarArgsErsetzen1, 
										String durchVarArgsErsetzen2, 
										String durchVarArgsErsetzen3) {
		
		// Verwende Varargs.
		
		// Ist die Methode Varargs Safe? Warum?

		// Was macht der Compiler aus String ... strings, wenn "Hallo" und "Welt" uebergeben wird? 

		return 0;
	}

	static <T> int gebeAnzahlElementeZurueck( T durchVarArgsErsetzen1, T durchVarArgsErsetzen2 ) {
		// Verwende Varargs.
		
		// Ist diese Methode varargs safe? Warum?
		
		// Wenn die übergebenen Parameter selber parameterisiert sind, 
		// kann Java daraus kein Array erzeugen.
		// Das kann Java also nicht: new T[] { ... }.
		// Statt dessen macht Java dann:
		// new Object[] { ... }
		// Ist aber hier egal, da der Typ der Elemente
		// des Arrays hier ruhig Object sein kann.
		
		return 0;		
	}
	
	static <T> int demonstriereVarargsSafe( T erster, T zweiter ) {
		return gebeAnzahlElementeZurueck(erster, zweiter);
	}

	static <U> U[] gebeAlsArrayZurueckTypUnbekannt( U durchVarArgsErsetzen1, 
													U durchVarArgsErsetzen2 ) {

		// Verwende Varargs.

		// Ist diese Methode varargs safe? Warum?

		// Was macht der Compiler aus T ... beliebige, wenn T zwar parameterisiert, aber bekannt ist
		// also z.B. beim Aufruf gebeAlsArrayZurueckTypBekannt( "erster", "zweiter" ) ?

		// Dann macht Java daraus:
		// new Object[] { ... } wobei Object die kleinste 
		// gemeinsame Basisklasse der Parameter ist, könnte 
		// also statt Object auch Fahrzeug sein, wenn das die kleinste
		// gemeinsame Basisklasse ist.
		// new Fahrzeug[] { die Fahrzeuge }
		// In diesem Fall ist alles OK, die Methode macht keine Probleme.
		
		// *
		
		// Was macht der Compiler aus T ... beliebige, wenn T KEIN konreter Typ ist, 
		// also die übergebenen Parameter selber paramterisiert sind?
		// Wann wird das zum Problem?
		
		// Wenn die übergebenen Parameter selber parameterisiert sind, 
		// kann Java daraus kein Array erzeugen.
		// Das kann Java also nicht: new T[] { ... }.
		// Statt dessen macht Java dann:
		// new Object[] { ... }
		
		// Zur Laufzeit kennt Java aber den richtigen Typ. Wenn man dann Object z.B. 
		// in String umwandeln möchte, knallt es.

		return null;
	}

	static <V> V[] demonstriereNichtVarargsSafe( V erster, 
													V zweiter ) {
		return gebeAlsArrayZurueckTypUnbekannt(erster, zweiter);
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
}