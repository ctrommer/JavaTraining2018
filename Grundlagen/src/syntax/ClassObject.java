package syntax;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClassObject {

	private String nameDerKlasseMotorrad() {
		return null;
	}
	
	/**
	 * Klasse erzeugen aus Klassename als String
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	private Motorrad motorradErzeugenAusKlassenname() throws InstantiationException, IllegalAccessException, 
															IllegalArgumentException, InvocationTargetException, 
															NoSuchMethodException, SecurityException, 
															ClassNotFoundException  {
		return null;
	}
	
	private boolean istMotorrad1( Fahrzeug fahrzeug ) {
		return fahrzeug instanceof Motorrad;
	}
	
	private boolean istMotorrad2( Fahrzeug fahrzeug ) {
		return Motorrad.class.isInstance( fahrzeug );
	}
	
	private boolean istMotorrad3( Fahrzeug fahrzeug ) {
		return fahrzeug.getClass() == Motorrad.class;
	}
	
	@Test
	@DisplayName("Wurde der Name der Klasse Motorrad richtig ermittelt?")
	public void test1() {
		assertEquals(
				"Motorrad", 
				nameDerKlasseMotorrad() );
	}

	@Test
	@DisplayName("Wurde die Klasse Motorrad aus dem Klassennamen erzeugt?")
	public void  test2() {
		try {
			assertTrue( motorradErzeugenAusKlassenname() instanceof Motorrad );
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
			assertFalse( 
					"Klasse Motorrad wurde nicht erzeugt.", 
					true );
		}
	}

	@Test
	@DisplayName("Erste Variante, die testet, ob das Fahrzeug ein Motorrad ist.")
	public void test3() {
		assertTrue( istMotorrad1( new Motorrad() ) );
	}

	@Test
	@DisplayName("Erste Variante, die testet, ob das Fahrzeug KEIN Motorrad ist.")
	public void test4() {
		assertFalse( istMotorrad1( new Fahrzeug(42) { } ) );
	}
	
	@Test
	@DisplayName("Zweite Variante, die testet, ob das Fahrzeug ein Motorrad ist.")
	public void test5() {
		assertTrue( istMotorrad2( new Motorrad() ) );
	}

	@Test
	@DisplayName("Zweite Variante, die testet, ob das Fahrzeug KEIN Motorrad ist.")
	public void test6() {
		assertFalse( istMotorrad2( new Fahrzeug( 42 ) {	} ) );
	}

	@Test
	@DisplayName("Dritte Variante, die testet, ob das Fahrzeug ein Motorrad ist.")
	public void test7() {
		assertTrue( istMotorrad3( new Motorrad() ) );
	}

	@Test
	@DisplayName("Dritte Variante, die testet, ob das Fahrzeug KEIN Motorrad ist.")
	public void test8() {
		assertFalse( istMotorrad3( new Fahrzeug(42) { } ) );
	}
	
}
