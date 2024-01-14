package aufWunschBeispiel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VielleichtMitInhaltTester {
	
	@SuppressWarnings("unchecked")
	private VielleichtMitInhalt<Object> erzeugeMitInhaltUngleichNull() {
		
		try {
			return (VielleichtMitInhalt<Object>) VielleichtMitInhalt.class
													.getMethod("erzeugeAus", Object.class)
													.invoke(VielleichtMitInhalt.class, new Object());		
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private VielleichtMitInhalt<Object> erzeugeMitInhaltNull()
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		
		return (VielleichtMitInhalt<Object>) VielleichtMitInhalt.class
															.getMethod("leereInstanz")
															.invoke(VielleichtMitInhalt.class);
	}
	
	@Test
	@DisplayName("Klasse muss final sein.")
	public void test01() {
		Assertions.assertTrue( Modifier.isFinal(VielleichtMitInhalt.class.getModifiers()), "Klasse muss final sein" );
	}

	@Test
	@DisplayName("Testet istInhaltVorhanden und leereInstanz und damit indirekt den argumentlosen Konstruktor.")
	public void test02() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		Object objectSollLeerSein 
			= VielleichtMitInhalt.class
				.getMethod("leereInstanz")
				.invoke(VielleichtMitInhalt.class);

		Assertions.assertFalse( (boolean) VielleichtMitInhalt.class
														.getMethod("istInhaltVorhanden")
														.invoke(objectSollLeerSein) );
	}

	@Test
	@DisplayName("Testet erzeugeAus, wenn null uebergeben wird und damit indirekt den Konstrukor mit einem Argument.")
	public void test03() throws NoSuchMethodException, SecurityException {
		// Ich will hier abprüfen, ob eine NullPointerException geworfen wird, wenn man erzeugeAus mit null aufruft.
		// Diese NullPointerException wird zwar geworfen, dadurch wird dann aber auch eine InvocationTargetException
		// gewofen. Diese hat dann als target die NullPointerException.
		InvocationTargetException exceptionWegenReflektion 
			= Assertions.assertThrows(
					InvocationTargetException.class, 
					() -> VielleichtMitInhalt.class
								.getMethod("erzeugeAus", Object.class)
								.invoke(VielleichtMitInhalt.class, ( Object ) null) );
		
		// Hier kriege ich dann die Exception, die sich hinter der InvocationTargetException versteckt.
		Throwable erwarteteException = exceptionWegenReflektion.getTargetException();
		
		Assertions.assertTrue(
				erwarteteException instanceof NullPointerException, 
				"wenn man erzeugeAus mit null aufruft soll eine NullPointerException geworfen werden." );
	}
	
	@Test
	@DisplayName("Testet erzeugeAus und getInhalt, wenn ein Wert ungleich null uebergeben wird und damit indirekt den Konstrukor mit einem Argument.")
	public void test04() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException {

		Object inhaltUngleichNull = new Object();
		
		@SuppressWarnings("unchecked")
		VielleichtMitInhalt<Object> ergebnisVonErzeugeAus 
			= (VielleichtMitInhalt<Object>) VielleichtMitInhalt.class
													.getMethod("erzeugeAus", Object.class)
													.invoke(VielleichtMitInhalt.class, inhaltUngleichNull);
		
		Assertions.assertEquals(
				inhaltUngleichNull, 
				VielleichtMitInhalt.class
							.getMethod("getInhalt")
							.invoke(ergebnisVonErzeugeAus));								
	}

	@Test
	@DisplayName("Testet erzeugeAusNullErlaubt, wenn null uebergeben wird und damit indirekt den Konstrukor mit einem Argument.")
	public void test05() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		Object mitInhaltLeer 
			= VielleichtMitInhalt.class
				.getMethod("leereInstanz")
				.invoke(VielleichtMitInhalt.class);

		@SuppressWarnings("unchecked")
		VielleichtMitInhalt<Object> ergebnisVonErzeugeAusNullErlaubt
			= (VielleichtMitInhalt<Object>) VielleichtMitInhalt.class
													.getMethod("erzeugeAusNullErlaubt", Object.class)
													.invoke(VielleichtMitInhalt.class, ( Object ) null);

		Assertions.assertEquals(mitInhaltLeer, ergebnisVonErzeugeAusNullErlaubt);
	}

	@Test
	@DisplayName("Testet erzeugeAusNullErlaubt und getInhalt, wenn ein Wert uebergeben wird und damit indirekt den Konstrukor mit einem Argument.")
	public void test06() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		
		Object inhaltUngleichNull = new Object();

		@SuppressWarnings("unchecked")
		VielleichtMitInhalt<Object> ergebnisVonErzeugeAusNullErlaubt
			= (VielleichtMitInhalt<Object>) VielleichtMitInhalt.class
												.getMethod("erzeugeAusNullErlaubt", Object.class)
												.invoke(VielleichtMitInhalt.class, inhaltUngleichNull);

		Assertions.assertEquals( 	inhaltUngleichNull, 
									VielleichtMitInhalt.class
													.getMethod("getInhalt")
													.invoke(ergebnisVonErzeugeAusNullErlaubt));				
	}

	@Test 
	@DisplayName("Testet getInhalt, wenn der Inhalt null ist.")
	public void test07() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {

		// Ich will hier abprüfen, ob eine NoSuchElementException geworfen wird, wenn man getInhalt aufruft, wenn der Inhalt null ist.
		// Diese NoSuchElementException wird zwar geworfen, dadurch wird dann aber auch eine InvocationTargetException
		// gewofen. Diese hat dann als target die NoSuchElementException.
		InvocationTargetException exceptionWegenReflektion 
			= Assertions.assertThrows(
					InvocationTargetException.class, 
					() -> VielleichtMitInhalt.class
								.getMethod("getInhalt")
								.invoke( erzeugeMitInhaltNull()) );
		
		// Hier kriege ich dann die Exception, die sich hinter der InvocationTargetException versteckt.
		Throwable erwarteteException = exceptionWegenReflektion.getTargetException();
		
		Assertions.assertTrue(
				erwarteteException instanceof NoSuchElementException, 
				"wenn man erzeugeAus mit null aufruft soll eine NoSuchElementException geworfen werden. " );
	}

	@Test
	@DisplayName("Testet erzeugeAus und istInhaltVorhanden, wenn ein Wert ungleich null uebergeben wird.")
	public void test08() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {

		Assertions.assertTrue( (boolean) VielleichtMitInhalt.class
												.getMethod("istInhaltVorhanden")
												.invoke( erzeugeMitInhaltUngleichNull()) );
	}

	@Test
	@DisplayName("Testet wennInhaltDannMache wenn Inhalt und Benutzer vorhanden.")
	public void test09() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		Object inhaltUngleichNull = new Object();			
		
		Object mitInhalt 
			= VielleichtMitInhalt.class
				.getMethod("erzeugeAus", Object.class)
				.invoke( VielleichtMitInhalt.class, inhaltUngleichNull );
		
		List<String> testListe = new ArrayList<>();
		
		@SuppressWarnings("rawtypes")	// Das interface Benutzer muss ja erst noch als Uebung geschrieben werden.
		class BenutzerImpl implements Benutzer {	
			public void machWasMit(Object t) {
				testListe.add( t.toString() );
			}								
		}
		
		VielleichtMitInhalt.class
			.getMethod( "wennInhaltDannMache", Benutzer.class )
			.invoke( mitInhalt, new BenutzerImpl() );
					
		Assertions.assertEquals( inhaltUngleichNull.toString(), testListe.get(0) );
	}

	@Test
	@DisplayName("Testet wennInhaltDannMache wenn Inhalt null und Benutzer vorhanden.")
	public void test10() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

		List<String> testListe = new ArrayList<>();
		
		@SuppressWarnings("rawtypes")	// Das interface Benutzer muss ja erst noch als Uebung geschrieben werden.
		class BenutzerImpl implements Benutzer {	
			public void machWasMit(Object t) {
				testListe.add( t.toString() );
			}								
		}

		VielleichtMitInhalt.class
			.getMethod("wennInhaltDannMache", Benutzer.class)
			.invoke(erzeugeMitInhaltNull(), new BenutzerImpl());
					
		Assertions.assertTrue(testListe.isEmpty());			
	}

	@Test
	@DisplayName("Testet wennInhaltDannMache wenn Inhalt vorhanden und Benutzer null.")
	public void test11() throws NoSuchMethodException, SecurityException {

		List<String> testListe = new ArrayList<>();
		
		@SuppressWarnings("rawtypes")	// Das interface Benutzer muss ja erst noch als Uebung geschrieben werden.
		Benutzer benutzer = null;
		// Ich will hier abprüfen, ob eine NullPointerException geworfen wird.
		// Diese NullPointerException wird zwar geworfen, dadurch wird dann aber auch eine InvocationTargetException
		// gewofen. Diese hat dann als target die NullPointerException.
		InvocationTargetException verdeckendeException 
			= Assertions.assertThrows(
					InvocationTargetException.class, 
					() -> VielleichtMitInhalt.class
								.getMethod("wennInhaltDannMache", Benutzer.class)
								.invoke(erzeugeMitInhaltUngleichNull(), benutzer) );
		// Hier kriege ich dann die Exception, die sich hinter der InvocationTargetException versteckt.
		Throwable zuTestendeException = verdeckendeException.getTargetException();

		Assertions.assertTrue(
				zuTestendeException instanceof NullPointerException, 
				"NullPointerException soll geworfen werden. " );

		Assertions.assertTrue(testListe.isEmpty());
	}

	@Test
	@DisplayName("Testet filtere, wenn Inhalt vorhanden und Bedingung null.")
	public void test12() throws NoSuchMethodException, SecurityException {

		@SuppressWarnings("rawtypes")
		Bedingung bedingung = null;
		
		// Ich will hier abprüfen, ob eine NullPointerException geworfen wird.
		// Diese NullPointerException wird zwar geworfen, dadurch wird dann aber auch eine InvocationTargetException
		// gewofen. Diese hat dann als target die NullPointerException.
		InvocationTargetException verdeckendeException 
			= Assertions.assertThrows(
					InvocationTargetException.class, 
					() -> VielleichtMitInhalt.class
								.getMethod("filtere", Bedingung.class)
								.invoke( erzeugeMitInhaltUngleichNull(), bedingung) );
		// Hier kriege ich dann die Exception, die sich hinter der InvocationTargetException versteckt.
		Throwable zuTestendeException = verdeckendeException.getTargetException();

		Assertions.assertTrue(
				zuTestendeException instanceof NullPointerException, 
				"NullPointerException soll geworfen werden. " );							
	}	
	
	@Test
	@DisplayName("Testet filtere, wenn Inhalt vorhanden und Bedingung nicht erfüllt.")
	public void test13() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		@SuppressWarnings("rawtypes")	// Das interface Bedingung muss ja erst noch als Uebung geschrieben werden.
		class BedingungImpl implements Bedingung {
			public boolean istErfuelltFuer(Object zuPruefen) {
				return false;
			}				
		}
		
		Assertions
			.assertFalse( (boolean) VielleichtMitInhalt.class
												.getMethod("istInhaltVorhanden")
												.invoke( VielleichtMitInhalt.class
																.getMethod("filtere", Bedingung.class)
																.invoke( erzeugeMitInhaltUngleichNull(), new BedingungImpl())) );						
	}

	@Test
	@DisplayName("Testet filtere, wenn Inhalt vorhanden und Bedingung erfüllt.")
	public void test14() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		
		@SuppressWarnings("rawtypes")	// Das interface Bedingung muss ja erst noch als Uebung geschrieben werden.
		class BedingungImpl implements Bedingung {
			public boolean istErfuelltFuer(Object zuPruefen) {
				return true;
			}				
		}

		@SuppressWarnings("unchecked")
		VielleichtMitInhalt<Object> gefiltertMitInhalt 
			= (VielleichtMitInhalt<Object>) VielleichtMitInhalt.class
												.getMethod("filtere", Bedingung.class)
												.invoke(erzeugeMitInhaltUngleichNull(), new BedingungImpl());

		Assertions.assertTrue( (boolean) VielleichtMitInhalt.class
												.getMethod("istInhaltVorhanden")
												.invoke( gefiltertMitInhalt ) );
	}

	@Test
	@DisplayName("Testet filtere, wenn kein Inhalt vorhanden und Bedingung nicht erfüllt.")
	public void test15() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		
		@SuppressWarnings("rawtypes")	// Das interface Bedingung muss ja erst noch als Uebung geschrieben werden.
		class BedingungImpl implements Bedingung {
			public boolean istErfuelltFuer(Object zuPruefen) {
				return false;
			}				
		}
		
		Assertions.assertFalse( (boolean) VielleichtMitInhalt.class
												.getMethod("istInhaltVorhanden")
												.invoke( VielleichtMitInhalt.class
																.getMethod("filtere", Bedingung.class)
																.invoke(erzeugeMitInhaltNull(), new BedingungImpl())) );
	}

	@Test
	@DisplayName("Testet filtere, wenn kein Inhalt vorhanden und Bedingung erfüllt.")
	public void test16() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		
		@SuppressWarnings("rawtypes")	// Das interface Bedingung muss ja erst noch als Uebung geschrieben werden.
		class BedingungImpl implements Bedingung {
			public boolean istErfuelltFuer(Object zuPruefen) {
				return true;
			}				
		}
		
		Assertions.assertFalse( (boolean) VielleichtMitInhalt.class
				.getMethod("istInhaltVorhanden")
				.invoke( VielleichtMitInhalt.class
								.getMethod("filtere", Bedingung.class)
								.invoke(erzeugeMitInhaltNull(), new BedingungImpl())) );
	}
	
	@Test
	@DisplayName("Testet filtere, wenn kein Inhalt vorhanden und Bedingung null.")
	public void test17() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		
		@SuppressWarnings("rawtypes")
		Bedingung bedingung = null;
		
		// Ich will hier abprüfen, ob eine NullPointerException geworfen wird.
		// Diese NullPointerException wird zwar geworfen, dadurch wird dann aber auch eine InvocationTargetException
		// gewofen. Diese hat dann als target die NullPointerException.
		InvocationTargetException exceptionWegenReflektion 
			= Assertions.assertThrows(
					InvocationTargetException.class, 
					() -> VielleichtMitInhalt.class
									.getMethod("filtere", Bedingung.class)
									.invoke(erzeugeMitInhaltNull(), bedingung) );
		// Hier kriege ich dann die Exception, die sich hinter der InvocationTargetException versteckt.
		Throwable erwarteteException = exceptionWegenReflektion.getTargetException();

		Assertions.assertTrue(
				erwarteteException instanceof NullPointerException, 
				"NullPointerException soll geworfen werden. " );					
	}

	@Test
	@DisplayName("Testet transformiere, wenn Inhalt vorhanden und das Ergebnis von transformiere ungleich null ist.")
	public void test18() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		
		@SuppressWarnings("rawtypes")	// Das interface Transformierer muss ja erst noch als Uebung geschrieben werden.
		class TransformiererImpl implements Transformierer {
			public Integer transformiere(Object t) {
				return 42;
			}
		}
		
		@SuppressWarnings("unchecked")
		VielleichtMitInhalt<Integer> transformiert 
			=  (VielleichtMitInhalt<Integer>) VielleichtMitInhalt.class
													.getMethod("transformiere", Transformierer.class)
													.invoke( erzeugeMitInhaltUngleichNull(), new TransformiererImpl() );
		
		Assertions.assertEquals(42, VielleichtMitInhalt.class
				.getMethod("getInhalt")
				.invoke(transformiert));
	}
	
	@Test
	@DisplayName("Testet transformiere, wenn Inhalt vorhanden und das Ergebnis von transformiere gleich null ist.")
	public void test19() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		
		@SuppressWarnings("rawtypes")	// Das interface Transformierer muss ja erst noch als Uebung geschrieben werden.
		class TransformiererImpl implements Transformierer {
			public Integer transformiere(Object t) {
				return null;
			}
		}

		@SuppressWarnings("unchecked")
		VielleichtMitInhalt<Integer> transformiert 
			=  (VielleichtMitInhalt<Integer>) VielleichtMitInhalt.class
													.getMethod("transformiere", Transformierer.class)
													.invoke( erzeugeMitInhaltUngleichNull(), new TransformiererImpl() );

		Assertions.assertFalse( (boolean) VielleichtMitInhalt.class
												.getMethod("istInhaltVorhanden").invoke(transformiert) );
	}
	
	@Test
	@DisplayName("Testet transformiere, wenn Inhalt null ist und das Ergebnis von transformiere ungleich null ist.")
	public void test20() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

		@SuppressWarnings("rawtypes")	// Das interface Transformierer muss ja erst noch als Uebung geschrieben werden.
		class TransformiererImpl implements Transformierer {
			public Integer transformiere(Object t) {
				return 42;
			}
		}

		@SuppressWarnings("unchecked")
		VielleichtMitInhalt<Integer> transformiert 
			= (VielleichtMitInhalt<Integer>) VielleichtMitInhalt.class
												.getMethod("transformiere", Transformierer.class)
												.invoke(erzeugeMitInhaltNull(), new TransformiererImpl());

		Method istInhaltVorhandenMethode = VielleichtMitInhalt.class.getMethod("istInhaltVorhanden");
		Assertions.assertFalse( (boolean) istInhaltVorhandenMethode.invoke(transformiert) );
	}

	@Test
	@DisplayName("Testet transformiere, wenn Inhalt vorhanden und transformierer gleich null ist.")
	public void test21() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		
		@SuppressWarnings("rawtypes")
		Transformierer transformierer = null;

		// Ich will hier abprüfen, ob eine NullPointerException geworfen wird.
		// Diese NullPointerException wird zwar geworfen, dadurch wird dann aber auch eine InvocationTargetException
		// gewofen. Diese hat dann als target die NullPointerException.
		InvocationTargetException verdeckendeException 
			= Assertions.assertThrows(
					InvocationTargetException.class, 
					() -> VielleichtMitInhalt.class
								.getMethod("transformiere", Transformierer.class)
								.invoke( erzeugeMitInhaltUngleichNull(), transformierer ) );
		// Hier kriege ich dann die Exception, die sich hinter der InvocationTargetException versteckt.
		Throwable erwarteteException = verdeckendeException.getTargetException();

		Assertions.assertTrue(
				erwarteteException instanceof NullPointerException, 
				"NullPointerException soll geworfen werden. " );			

	}

	@Test
	@DisplayName("Testet transformiereFlach, wenn Inhalt vorhanden und das Ergebnis von transformiere ungleich null ist.")
	public void test22() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {

		@SuppressWarnings("rawtypes")	// Das interface Transformierer muss ja erst noch als Uebung geschrieben werden.
		class TransformiererImpl implements Transformierer {
			public VielleichtMitInhalt<Object> transformiere(Object t) {
				return erzeugeMitInhaltUngleichNull();
			}
		}

		@SuppressWarnings("unchecked")
		VielleichtMitInhalt<Object> transformiert 
			= (VielleichtMitInhalt<Object>) VielleichtMitInhalt.class
												.getMethod("transformiereFlach", Transformierer.class)
												.invoke(erzeugeMitInhaltUngleichNull(), new TransformiererImpl());

		Assertions.assertTrue( (boolean) VielleichtMitInhalt.class.getMethod("istInhaltVorhanden").invoke( transformiert ) );						
	}

	@Test
	@DisplayName("Testet transformiereFlach, wenn Inhalt vorhanden und das Ergebnis von transformiere gleich null ist.")
	public void test23() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {

		@SuppressWarnings("rawtypes")	// Das interface Transformierer muss ja erst noch als Uebung geschrieben werden.
		class TransformiererImpl implements Transformierer {
			public VielleichtMitInhalt<Object> transformiere(Object t) {
				return null;
			}
		}

		// Ich will hier abprüfen, ob eine NullPointerException geworfen wird.
		// Diese NullPointerException wird zwar geworfen, dadurch wird dann aber auch eine InvocationTargetException
		// gewofen. Diese hat dann als target die NullPointerException.
		InvocationTargetException verdeckendeException 
			= Assertions.assertThrows(
					InvocationTargetException.class, 
					() -> VielleichtMitInhalt.class
									.getMethod("transformiereFlach", Transformierer.class)
									.invoke(erzeugeMitInhaltUngleichNull(), new TransformiererImpl()) );
		// Hier kriege ich dann die Exception, die sich hinter der InvocationTargetException versteckt.
		Throwable erwarteteException = verdeckendeException.getTargetException();

		Assertions.assertTrue(
				erwarteteException instanceof NullPointerException, 
				"NullPointerException soll geworfen werden. " );							
	}

	@Test
	@DisplayName("Testet transformiereFlach, wenn Inhalt null ist und das Ergebnis von transformiere ungleich null ist.")
	public void test24() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {

		@SuppressWarnings("rawtypes")	// Das interface Transformierer muss ja erst noch als Uebung geschrieben werden.
		class TransformiererImpl implements Transformierer {
			public VielleichtMitInhalt<Object> transformiere(Object t) {
				return erzeugeMitInhaltUngleichNull();
			}
		}
		
		@SuppressWarnings("unchecked")
		VielleichtMitInhalt<Object> transformiert 
				= (VielleichtMitInhalt<Object>) VielleichtMitInhalt.class
													.getMethod("transformiereFlach", Transformierer.class)
													.invoke( erzeugeMitInhaltNull(), new TransformiererImpl() );
		

		Assertions.assertFalse( (boolean) VielleichtMitInhalt.class
													.getMethod("istInhaltVorhanden")
													.invoke(transformiert) );				
	}
	
	@Test
	@DisplayName("Testet transformiereFlach, wenn Inhalt vorhanden und transformierer gleich null ist.")
	public void test25() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {

		@SuppressWarnings("rawtypes")
		Transformierer transformiererNull = null;

		// Ich will hier abprüfen, ob eine NullPointerException geworfen wird.
		// Diese NullPointerException wird zwar geworfen, dadurch wird dann aber auch eine InvocationTargetException
		// gewofen. Diese hat dann als target die NullPointerException.
		InvocationTargetException verdeckendeException 
			= Assertions.assertThrows(
					InvocationTargetException.class, 
					() -> VielleichtMitInhalt.class
								.getMethod("transformiereFlach", Transformierer.class)
								.invoke( erzeugeMitInhaltUngleichNull(), transformiererNull) );
		// Hier kriege ich dann die Exception, die sich hinter der InvocationTargetException versteckt.
		Throwable erwarteteException = verdeckendeException.getTargetException();

		Assertions.assertTrue(
				erwarteteException instanceof NullPointerException, 
				"NullPointerException soll geworfen werden. " );							
	}	
	
	@Test
	@DisplayName("Testet holeWennVorhandenSonst, wenn Inhalt vorhanden und defaultInhalt vorhanden")
	public void test26() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		
		Object inhaltUngleichNull = new Object();
		
		@SuppressWarnings("unchecked")
		VielleichtMitInhalt<Object> mitInhalt 
			= (VielleichtMitInhalt<Object>) VielleichtMitInhalt.class
													.getMethod("erzeugeAus", Object.class)
													.invoke( VielleichtMitInhalt.class, inhaltUngleichNull );
		
		Object ergebnis =  VielleichtMitInhalt.class
									.getMethod("holeWennVorhandenSonst", Object.class)
									.invoke(mitInhalt, new Object());
		
		Assertions.assertEquals( inhaltUngleichNull, ergebnis );
	}

	@Test
	@DisplayName("Testet holeWennVorhandenSonst, wenn Inhalt null und defaultInhalt vorhanden")
	public void test27() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {

		Object defaultWert = new Object();

		Assertions.assertEquals(defaultWert,
								VielleichtMitInhalt.class
										.getMethod("holeWennVorhandenSonst", Object.class)
										.invoke(erzeugeMitInhaltNull(), defaultWert));
	}

	@Test
	@DisplayName("Testet holeWennVorhandenSonst, wenn Inhalt null und defaultInhalt null")
	public void test28() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		
		Object defaultWertNull = null;
		
		Assertions.assertEquals(defaultWertNull, 
								VielleichtMitInhalt.class
										.getMethod("holeWennVorhandenSonst", Object.class)
										.invoke(erzeugeMitInhaltNull(), defaultWertNull));
	}

	@Test
	@DisplayName("Testet holeWennVorhandenSonstRufeAuf wenn inhalt vorhanden und erzeuger vorhanden")
	public void test29() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		
		Object inhaltUngleichNull = new Object();
		
		@SuppressWarnings("unchecked")
		VielleichtMitInhalt<Object> mitInhalt 
						= (VielleichtMitInhalt<Object>) VielleichtMitInhalt.class
															.getMethod("erzeugeAus", Object.class)
															.invoke( VielleichtMitInhalt.class, inhaltUngleichNull );

		@SuppressWarnings("rawtypes")
		class ErzeugerImpl implements Erzeuger{
			public Integer erzeuge() {
				return 42;
			}
		}

		Assertions.assertEquals(inhaltUngleichNull, 
								VielleichtMitInhalt.class
											.getMethod("holeWennVorhandenSonstRufeAuf", Erzeuger.class)
											.invoke( mitInhalt, new ErzeugerImpl()) );
	}

	@Test
	@DisplayName("Testet holeWennVorhandenSonstRufeAuf wenn inhalt vorhanden und erzeuger null")
	public void test30() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		
		Object inhaltUngleichNull = new Object();
		
		@SuppressWarnings("unchecked")
		VielleichtMitInhalt<Object> mitInhalt 
					= (VielleichtMitInhalt<Object>) VielleichtMitInhalt.class
														.getMethod("erzeugeAus", Object.class)
														.invoke(VielleichtMitInhalt.class, inhaltUngleichNull);

		@SuppressWarnings("rawtypes")
		Erzeuger erzeuger = null;

		Assertions.assertEquals( inhaltUngleichNull, VielleichtMitInhalt.class
														.getMethod("holeWennVorhandenSonstRufeAuf", Erzeuger.class)
														.invoke( mitInhalt, erzeuger ) );
	}

	@Test
	@DisplayName("Testet holeWennVorhandenSonstRufeAuf wenn inhalt null und erzeuger vorhanden")
	public void test31() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {

		List<Integer> testListe = new ArrayList<>();
		
		@SuppressWarnings("rawtypes")
		class ErzeugerImpl implements Erzeuger{
			public Integer erzeuge() {
				testListe.add(42);
				return 42;
			}
		}

		Object ergebnis = VielleichtMitInhalt.class
					.getMethod( "holeWennVorhandenSonstRufeAuf", Erzeuger.class )
					.invoke( erzeugeMitInhaltNull(), new ErzeugerImpl());
		
		Assertions.assertEquals( testListe.get(0), ergebnis );
	}

	@Test
	@DisplayName("Testet holeWennVorhandenSonstRufeAuf wenn inhalt null und erzeuger null")
	public void test32() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		
		@SuppressWarnings("rawtypes")
		Erzeuger erzeuger = null;
		
		// Ich will hier abprüfen, ob eine NullPointerException geworfen wird.
		// Diese NullPointerException wird zwar geworfen, dadurch wird dann aber auch eine InvocationTargetException
		// gewofen. Diese hat dann als target die NullPointerException.
		InvocationTargetException verdeckendeException 
			= Assertions.assertThrows(
					InvocationTargetException.class, 
					() -> VielleichtMitInhalt.class
								.getMethod("holeWennVorhandenSonstRufeAuf", Erzeuger.class)
								.invoke( erzeugeMitInhaltNull(), erzeuger ) );
		// Hier kriege ich dann die Exception, die sich hinter der InvocationTargetException versteckt.
		Throwable erwarteteException = verdeckendeException.getTargetException();
		
		Assertions.assertTrue(
				erwarteteException instanceof NullPointerException, 
				"NullPointerException soll geworfen werden. " );		
	}

	@Test
	@DisplayName("Testet holeWennVorhandenSonstWerfeException, wenn inhalt vorhanden und ausnameErzeuger vorhanden")
	public void test33() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException  {
		
		Object inhaltUngleichNull = new Object();
		
		@SuppressWarnings("unchecked")
		VielleichtMitInhalt<Object> mitInhalt 
				= (VielleichtMitInhalt<Object>) VielleichtMitInhalt.class
													.getMethod("erzeugeAus", Object.class)
													.invoke(VielleichtMitInhalt.class, inhaltUngleichNull);
		
		@SuppressWarnings("rawtypes")
		class ErzeugerImpl implements Erzeuger{
			public IllegalStateException erzeuge() {
				return new IllegalStateException();
			}
		}

		Object ergebnis =  VielleichtMitInhalt.class
									.getMethod("holeWennVorhandenSonstWerfeException", Erzeuger.class)
									.invoke(mitInhalt, new ErzeugerImpl());
		
		Assertions.assertEquals(inhaltUngleichNull, ergebnis);		
	}

	@Test
	@DisplayName("Testet holeWennVorhandenSonstWerfeException wenn inhalt vorhanden und ausnameErzeuger null")
	public void test34() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException  {
		
		Object inhaltUngleichNull = new Object();
		
		@SuppressWarnings("unchecked")
		VielleichtMitInhalt<Object> mitInhalt 
						= (VielleichtMitInhalt<Object>) VielleichtMitInhalt.class
																.getMethod("erzeugeAus", Object.class)
																.invoke(VielleichtMitInhalt.class, inhaltUngleichNull);

		@SuppressWarnings("rawtypes")
		Erzeuger erzeuger = null;
		Object ergebnis =  VielleichtMitInhalt.class
								.getMethod("holeWennVorhandenSonstWerfeException", Erzeuger.class)
								.invoke(mitInhalt, erzeuger);
		
		Assertions.assertEquals(inhaltUngleichNull, ergebnis);
	}

	@Test
	@DisplayName("Testet holeWennVorhandenSonstWerfeException wenn inhalt null und ausnameErzeuger vorhanden")
	public void test35() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException  {

		@SuppressWarnings("rawtypes")
		class ErzeugerImpl implements Erzeuger{
			public IllegalStateException erzeuge() {
				return new IllegalStateException();
			}
		}

		// Ich will hier abprüfen, ob eine IllegalStateException geworfen wird.
		// Diese IllegalStateException wird zwar geworfen, dadurch wird dann aber auch eine InvocationTargetException
		// gewofen. Diese hat dann als target die IllegalStateException.
		InvocationTargetException verdeckendeException 
			= Assertions.assertThrows(
				InvocationTargetException.class,
				() -> VielleichtMitInhalt.class
							.getMethod( "holeWennVorhandenSonstWerfeException", Erzeuger.class )
							.invoke( erzeugeMitInhaltNull(), new ErzeugerImpl()) );
		// Hier kriege ich dann die Exception, die sich hinter der InvocationTargetException versteckt.
		Throwable erwarteteException = verdeckendeException.getTargetException();

		Assertions.assertTrue(
				erwarteteException instanceof IllegalStateException, 
				"IllegalStateException soll geworfen werden. " );
	}

	@Test
	@DisplayName("Testet holeWennVorhandenSonstWerfeException wenn inhalt null und ausnameErzeuger null")
	public void test36() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException  {

		@SuppressWarnings("rawtypes")
		Erzeuger erzeuger = null;

		// Ich will hier abprüfen, ob eine IllegalStateException geworfen wird.
		// Diese IllegalStateException wird zwar geworfen, dadurch wird dann aber auch eine InvocationTargetException
		// gewofen. Diese hat dann als target die IllegalStateException.
		InvocationTargetException verdeckendeException 
			= Assertions.assertThrows(
				InvocationTargetException.class, 
				() -> VielleichtMitInhalt.class
								.getMethod("holeWennVorhandenSonstWerfeException", Erzeuger.class)
								.invoke(erzeugeMitInhaltNull(), erzeuger));
		// Hier kriege ich dann die Exception, die sich hinter der InvocationTargetException versteckt.
		Throwable erwarteteException = verdeckendeException.getTargetException();
		Assertions.assertTrue(
				erwarteteException instanceof NullPointerException, 
				"IllegalStateException soll geworfen werden. " );		
	}

	@Test
	@DisplayName("Testet equals wenn linke und rechte Seite das identische Objekt sind.")
	public void test37() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		VielleichtMitInhalt<Object> mitInhalt = erzeugeMitInhaltUngleichNull();
		
		Assertions.assertTrue(  (boolean) VielleichtMitInhalt.class
												.getMethod("equals", Object.class)
												.invoke(mitInhalt, mitInhalt) );		
	}
	
	@Test
	@DisplayName("Testet equals wenn rechte Seite nicht vom Typ VielleichtMitInhalt ist.")
	public void test38() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		
		Assertions.assertFalse( (boolean) VielleichtMitInhalt.class
													.getMethod("equals", Object.class)
													.invoke( erzeugeMitInhaltUngleichNull(), new Object()) );
	}

	@Test
	@DisplayName("Testet equals wenn rechte und linke Seite vom Typ VielleichtMitInhalt sind, aber unterschiedlichen Inhalt haben.")
	public void test39() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {

		Assertions.assertFalse(  (boolean) VielleichtMitInhalt.class
												.getMethod("equals", Object.class)
												.invoke(erzeugeMitInhaltUngleichNull(), erzeugeMitInhaltUngleichNull()) );
	}

	@Test
	@DisplayName("Testet equals wenn rechte und linke Seite vom Typ VielleichtMitInhalt sind und gleiche Inhalte haben.")
	public void test40() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		
		Object inhaltUngleichNullIdentisch = new Object();
		
		Assertions.assertTrue(  (boolean) VielleichtMitInhalt.class
												.getMethod("equals", Object.class)
												.invoke( VielleichtMitInhalt.class
																.getMethod("erzeugeAus", Object.class)
																.invoke(VielleichtMitInhalt.class, inhaltUngleichNullIdentisch), 
														 VielleichtMitInhalt.class
																.getMethod("erzeugeAus", Object.class)
																.invoke(VielleichtMitInhalt.class, inhaltUngleichNullIdentisch)) );
	}
	
	@Test
	@DisplayName("Testet, dass hashCode den hashCode von Inhalt zurück gibt.")
	public void test41() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		
		Object inhaltUngleichNull = new Object();
		
		@SuppressWarnings("unchecked")
		VielleichtMitInhalt<Object> mitInhalt 
					= ( VielleichtMitInhalt<Object> ) VielleichtMitInhalt.class
															.getMethod( "erzeugeAus", Object.class )
															.invoke( VielleichtMitInhalt.class, inhaltUngleichNull );

		Assertions.assertEquals( 	Objects.hashCode(inhaltUngleichNull),  
									VielleichtMitInhalt.class
												.getMethod("hashCode")
												.invoke(mitInhalt) );
	}

	@Test
	@DisplayName("Testet toString, wenn inhalt vorhanden.")
	public void test42() {
		Assertions.assertTrue( erzeugeMitInhaltUngleichNull()
												.toString()
												.contains("VielleichtMitInhalt [inhalt=") );
	}
	
	@Test
	@DisplayName("Testet toString, wenn inhalt null.")
	public void test43() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Assertions.assertFalse( erzeugeMitInhaltNull()
											.toString()
											.contains("VielleichtMitInhalt [inhalt=") );
	}	
	
	@Test
	@DisplayName("Testet istLeer, wenn inhalt null")
	public void test44() throws 
							IllegalAccessException, 
							InvocationTargetException, 
							NoSuchMethodException, 
							SecurityException {
		
		Assertions.assertTrue ( ( boolean ) VielleichtMitInhalt
															.class
															.getMethod("istLeer")
															.invoke( erzeugeMitInhaltNull() ) );
	}

	@Test
	@DisplayName("Testet istLeer, wenn inhalt ungleich null")
	public void test45() throws 
							IllegalAccessException, 
							InvocationTargetException, 
							NoSuchMethodException, 
							SecurityException {
		
		Assertions.assertFalse ( ( boolean ) VielleichtMitInhalt
															.class
															.getMethod("istLeer")
															.invoke( erzeugeMitInhaltUngleichNull() ) );
	}

	@Test
	@DisplayName("Testet wennVorhandenBenutzerSonstLauffaehig, wenn inhalt ungleich null und benutzer ungleich null")
	public void test46 () throws 
							IllegalAccessException, 
							InvocationTargetException, 
							NoSuchMethodException, 
							SecurityException   {
		Object inhaltUngleichNull = new Object();			
		
		Object mitInhalt 
				= VielleichtMitInhalt
									.class
									.getMethod( 
											"erzeugeAus", 
											Object.class )
									.invoke( 
											VielleichtMitInhalt.class, 
											inhaltUngleichNull );
		
		List<String> testListe = new ArrayList<>();
		
		@SuppressWarnings("rawtypes")	// Das interface Benutzer muss ja erst noch als Uebung geschrieben werden.
		class BenutzerImpl implements Benutzer {	
			public void machWasMit( Object o ) {
				testListe.add( o.toString() );
			}								
		}

		class LauffaehigImpl implements Lauffaehig {
			@Override
			public void laufe() {
				Assertions.assertTrue( false );
			}	
		}
		
		VielleichtMitInhalt
						.class
						.getMethod( 
								"wennVorhandenBenutzerSonstLauffaehig", 
								Benutzer.class, 
								Lauffaehig.class )
						.invoke( 
								mitInhalt, 
								new BenutzerImpl(), 
								new LauffaehigImpl() );
		
		Assertions.assertEquals( 
						inhaltUngleichNull.toString(), 
						testListe.get( 0 ) );
	}

	@Test
	@DisplayName("Testet wennVorhandenBenutzerSonstLauffaehig, wenn inhalt gleich null und lauffaehig ungleich null")
	public void test47 () throws 
							IllegalAccessException, 
							InvocationTargetException, 
							NoSuchMethodException, 
							SecurityException {
		List<String> testListe = new ArrayList<>();
		String erwartet = "Lauffaehig wurde aufgerufen";

		@SuppressWarnings("rawtypes")	// Das interface Benutzer muss ja erst noch als Uebung geschrieben werden.
		class BenutzerImpl implements Benutzer {	
			public void machWasMit( Object t ) {
				Assertions.assertTrue( false );
			}								
		}

		class LauffaehigImpl implements Lauffaehig {
			@Override
			public void laufe() {
				testListe.add( erwartet );				
			}	
		}
		
		VielleichtMitInhalt
						.class
						.getMethod( 
								"wennVorhandenBenutzerSonstLauffaehig", 
								Benutzer.class, 
								Lauffaehig.class )
						.invoke( 
								erzeugeMitInhaltNull(), 
								new BenutzerImpl(), 
								new LauffaehigImpl() );
		
		Assertions.assertEquals( 
							erwartet, 
							testListe.get( 0 ) );		
	}

	@Test
	@DisplayName("Testet wennVorhandenBenutzerSonstLauffaehig, wenn inhalt ungleich null und benutzer gleich null")
	public void test48 () {
		
		class LauffaehigImpl implements Lauffaehig {
			@Override
			public void laufe() {
				Assertions.assertTrue( false );
			}	
		}
	
		// siehe Kommentar zu InvocationTargetException in test03
		InvocationTargetException exceptionWegenReflektion 
									= Assertions.assertThrows( 
													InvocationTargetException.class , 
													() -> VielleichtMitInhalt
																		.class
																		.getMethod( 
																				"wennVorhandenBenutzerSonstLauffaehig", 
																				Benutzer.class, 
																				Lauffaehig.class )
																		.invoke( 
																				erzeugeMitInhaltUngleichNull(), 
																				null, 
																				new LauffaehigImpl() ) );
		Throwable erwarteteException = exceptionWegenReflektion.getTargetException();
		
		Assertions.assertTrue(
						erwarteteException instanceof NullPointerException,
						"wenn man wennVorhandenBenutzerSonstLauffaehig mit "
						+ "inhalt ungleich null und benutzer gleich null aufruft, "
						+ "soll  eine NullPointerException geworfen werden." );		
	}
	
	@Test
	@DisplayName("Testet wennVorhandenBenutzerSonstLauffaehig, wenn inhalt gleich null und lauffaehig gleich null")
	public void test49 () {
		
		@SuppressWarnings("rawtypes")	// Das interface Benutzer muss ja erst noch als Uebung geschrieben werden.
		class BenutzerImpl implements Benutzer {	
			public void machWasMit( Object t ) {
				Assertions.assertTrue( false );
			}								
		}
		
		// siehe Kommentar zu InvocationTargetException in test03
		InvocationTargetException exceptionWegenReflektion 
									= Assertions.assertThrows( 
													InvocationTargetException.class , 
													() -> VielleichtMitInhalt
																		.class
																		.getMethod( 
																				"wennVorhandenBenutzerSonstLauffaehig", 
																				Benutzer.class, 
																				Lauffaehig.class )
																		.invoke( 
																				erzeugeMitInhaltNull(), 
																				new BenutzerImpl(), 
																				null ) );
		Throwable erwarteteException = exceptionWegenReflektion.getTargetException();
		
		Assertions.assertTrue(
						erwarteteException instanceof NullPointerException,
						"wenn man wennVorhandenBenutzerSonstLauffaehig mit "
						+ "inhalt gleich null und lauffaehig gleich null aufruft, "
						+ "soll  eine NullPointerException geworfen werden." );
	}
	
	@Test
	@DisplayName("Testet inhaltOderErzeuge mit erzeuger gleich null")
	public void test50() {
		Erzeuger<Object> erzeuger = null;
		
		// siehe Kommentar zu InvocationTargetException in test03
		InvocationTargetException exceptionWegenReflektion 
									= Assertions.assertThrows( 
													InvocationTargetException.class , 
													() -> VielleichtMitInhalt
																		.class
																		.getMethod( 
																				"inhaltOderErzeuge", 
																				Erzeuger.class )
																		.invoke( 
																				erzeugeMitInhaltUngleichNull(),
																				erzeuger ) );
		Throwable erwarteteException = exceptionWegenReflektion.getTargetException();
		
		Assertions.assertTrue(
						erwarteteException instanceof NullPointerException,
						"wenn man inhaltOderErzeuge mit erzeuger gleich null aufruft, "
						+ "soll  eine NullPointerException geworfen werden." );
	}

	@Test
	@DisplayName("Testet inhaltOderErzeuge wenn erzeuger und inhalt ungleich null")
	public void test51() throws 
							IllegalAccessException, 
							InvocationTargetException, 
							NoSuchMethodException, 
							SecurityException {
		

		VielleichtMitInhalt<Object> mitInhalt = erzeugeMitInhaltUngleichNull(); 

		@SuppressWarnings("rawtypes")
		class ErzeugerImpl implements Erzeuger{
			public Integer erzeuge() {
				return 42;
			}
		}

		Assertions.assertEquals(
						mitInhalt, 
						VielleichtMitInhalt
										.class
										.getMethod( 
												"inhaltOderErzeuge", 
												Erzeuger.class )
										.invoke( 
												mitInhalt, 
												new ErzeugerImpl()) );
	}

	@Test
	@DisplayName("Testet inhaltOderErzeuge wenn inhalt null und erzeuger ungleich null "
			+ "und ein Ergebnis ungleich null liefert")
	public void test52() throws 
							IllegalAccessException, 
							InvocationTargetException, 
							NoSuchMethodException, 
							SecurityException {

		VielleichtMitInhalt<Object> mitInhaltUngleichNull = erzeugeMitInhaltUngleichNull();

		@SuppressWarnings("rawtypes")
		class ErzeugerImpl implements Erzeuger{
			public VielleichtMitInhalt<Object> erzeuge() {
				return mitInhaltUngleichNull;
			}
		}

		Assertions.assertEquals(
						mitInhaltUngleichNull,
						VielleichtMitInhalt
										.class
										.getMethod( 
												"inhaltOderErzeuge", 
												Erzeuger.class )
										.invoke( 
												erzeugeMitInhaltNull(), 
												new ErzeugerImpl() ) );
	}
	
	@Test
	@DisplayName("Testet inhaltOderErzeuge wenn inhalt null und erzeuger ungleich null "
			+ "und ein Ergebnis gleich null liefert")
	public void test53() throws 
							IllegalAccessException, 
							InvocationTargetException, 
							NoSuchMethodException, 
							SecurityException {

		@SuppressWarnings("rawtypes")
		class ErzeugerImpl implements Erzeuger{
			public VielleichtMitInhalt<Object> erzeuge() {
				return null;
			}
		}

		// siehe Kommentar zu InvocationTargetException in test03
		InvocationTargetException exceptionWegenReflektion 
									= Assertions.assertThrows( 
													InvocationTargetException.class , 
													() -> VielleichtMitInhalt
																		.class
																		.getMethod( 
																				"inhaltOderErzeuge", 
																				Erzeuger.class )
																		.invoke( 
																				erzeugeMitInhaltNull(), 
																				new ErzeugerImpl() ) );

		Throwable erwarteteException = exceptionWegenReflektion.getTargetException();
		
		Assertions.assertTrue(
						erwarteteException instanceof NullPointerException,
						"wenn man inhaltOderErzeuge mit erzeuger ungleich null aufruft, "
						+ "erzeuger aber null erzeugt soll Seine NullPointerException geworfen werden." );		
		
	}
	
	@Test
	@DisplayName("Testet erzeugeStream wenn inhalt null")
	public void test54() throws 
							IllegalAccessException, 
							InvocationTargetException, 
							NoSuchMethodException, 
							SecurityException {
		
		Object object = VielleichtMitInhalt
										.class
										.getMethod( "erzeugeStream" )
										.invoke( erzeugeMitInhaltNull() );
		
		try ( Stream<?> stream = ( Stream<?>) object ) {
			Assertions.assertTrue( stream
										.findAny()
										.isEmpty() );
		}

	}

	@Test
	@DisplayName("Testet erzeugeStream wenn inhalt ungleich null")
	public void test55() throws 
							IllegalAccessException, 
							InvocationTargetException, 
							NoSuchMethodException, 
							SecurityException {
		
		Object inhaltUngleichNull = new Object();			
		
		Object mitInhalt = VielleichtMitInhalt
											.class
											.getMethod( 
													"erzeugeAus", 
													Object.class )
											.invoke( 
													VielleichtMitInhalt.class, 
													inhaltUngleichNull );
		
		Object streamOfObject = VielleichtMitInhalt
												.class
												.getMethod( "erzeugeStream" )
												.invoke( mitInhalt );
		
		try ( Stream<?> stream = (Stream<?>) streamOfObject ) {
			Assertions.assertEquals( 
								inhaltUngleichNull, 
								stream
									.findFirst()
									.orElse( null ) 
								);
		}

	}
	
	@Test
	@DisplayName("Testet wertOderException wenn inhalt null")
	public void test56() throws 
							IllegalAccessException, 
							InvocationTargetException, 
							NoSuchMethodException, 
							SecurityException {
		
		// siehe Kommentar zu InvocationTargetException in test03
		InvocationTargetException exceptionWegenReflektion 
									= Assertions.assertThrows( 
													InvocationTargetException.class , 
													() -> VielleichtMitInhalt
																		.class
																		.getMethod( "wertOderException" )
																		.invoke( erzeugeMitInhaltNull() ) );

		Throwable erwarteteException = exceptionWegenReflektion.getTargetException();
		
		Assertions.assertTrue( erwarteteException instanceof NoSuchElementException );				
	}	

	@Test
	@DisplayName("Testet wertOderException wenn inhalt ungleich null")
	public void test57() throws 
							IllegalAccessException, 
							InvocationTargetException, 
							NoSuchMethodException, 
							SecurityException {
		Object inhaltUngleichNull = new Object();			
		
		Object mitInhalt = VielleichtMitInhalt
											.class
											.getMethod( 
													"erzeugeAus", 
													Object.class )
											.invoke( 
													VielleichtMitInhalt.class, 
													inhaltUngleichNull );

		Object ergebnis = VielleichtMitInhalt
										.class
										.getMethod( "wertOderException" )
										.invoke( mitInhalt );

		Assertions.assertEquals( 
							inhaltUngleichNull, 
							ergebnis );
		
	}

}