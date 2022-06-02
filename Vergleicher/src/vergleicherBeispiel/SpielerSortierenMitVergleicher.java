package vergleicherBeispiel;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpielerSortierenMitVergleicher {

	private static final Spieler KARL_11 = new Spieler("Karl", 11, "Kalle");
	private static final Spieler ALBERT_22 = new Spieler("Albert", 22, "Albi");
	private static final Spieler GUSTAV_11 = new Spieler("Gustav", 11, "Gustel");
	private static final Spieler BERTRAM_33 = new Spieler("Bertram", 33, "Bert");

	private int vergleicheSpielerNachAlterMitAnonymerInnererKlasse(Spieler links, Spieler rechts) {

		return 0;
	}

	@Test
	@DisplayName("vergleiche Spieler nach Alter mit anonymer innerer Klasse")
	public void test01() {		
		assertEquals(-1, vergleicheSpielerNachAlterMitAnonymerInnererKlasse(KARL_11, ALBERT_22) );		
		assertEquals(0, vergleicheSpielerNachAlterMitAnonymerInnererKlasse(KARL_11, GUSTAV_11));		
		assertEquals(1, vergleicheSpielerNachAlterMitAnonymerInnererKlasse(ALBERT_22, KARL_11 ));
	}

	private int vergleicheSpielerNachAlterMitLambda(Spieler links, Spieler rechts ) {

		return 0;
	}

	@Test
	@DisplayName("vergleiche Spieler nach Alter mit Lamda")
	public void test02() {		
		assertEquals(-1, vergleicheSpielerNachAlterMitLambda(KARL_11, ALBERT_22) );		
		assertEquals(0, vergleicheSpielerNachAlterMitLambda(KARL_11, GUSTAV_11));		
		assertEquals(1, vergleicheSpielerNachAlterMitLambda(ALBERT_22, KARL_11 ));
	}	
	
	/**
	 * Ein bereits existierender Vergleicher soll in einen R�ckw�rtsvergleicher verwandelt werden.
	 */
	private int vergleicheSpielerNachAlterMitLambdaRueckwaerts(Spieler links, Spieler rechts ) {

		return 0;
	}

	@Test
	@DisplayName("vergleiche Spieler nach Alter rueckwaerts mit Lamda")
	public void test03() {
		assertEquals(1, vergleicheSpielerNachAlterMitLambdaRueckwaerts(KARL_11, ALBERT_22) );
		assertEquals(0, vergleicheSpielerNachAlterMitLambdaRueckwaerts(KARL_11, GUSTAV_11));
		assertEquals(-1, vergleicheSpielerNachAlterMitLambdaRueckwaerts(ALBERT_22, KARL_11 ));
	}

	private int vergleicheSpielerNachAlterMitFunktion(Spieler links, Spieler rechts ) {		

		return 0;
	}

	@Test
	@DisplayName("vergleiche Spieler nach Alter mit Lamda und ( erst mal unnoetiger ) Funktion")
	public void test04() {
		assertEquals(-1, vergleicheSpielerNachAlterMitFunktion(KARL_11, ALBERT_22) );		
		assertEquals(0, vergleicheSpielerNachAlterMitFunktion(KARL_11, GUSTAV_11));		
		assertEquals(1, vergleicheSpielerNachAlterMitFunktion(ALBERT_22, KARL_11 ));
	}	

	private int vergleicheSpielerNachAlterMitFunktionUndStatischerMethodeVonVergleicher( Spieler links, Spieler rechts ) {

		return 0;
	}

	@Test
	@DisplayName("vergleiche Spieler nach Alter mit Lamda, Funktion und statischer Methode von Vergleicher")
	public void test05() {
		assertEquals(-1, vergleicheSpielerNachAlterMitFunktionUndStatischerMethodeVonVergleicher(KARL_11, ALBERT_22));
		assertEquals(0, vergleicheSpielerNachAlterMitFunktionUndStatischerMethodeVonVergleicher(KARL_11, GUSTAV_11));
		assertEquals(1, vergleicheSpielerNachAlterMitFunktionUndStatischerMethodeVonVergleicher(ALBERT_22, KARL_11 ));
	}

	/**
	 * Schreibe Methode von MyVergleicher, die einen Vergleicher erzeugt, der Elemente r�ckw�rts vergleicht, die
	 * Comparable implementieren.
	 * Verwende die Methode, um Integer r�ckw�rts zu sortieren.
	 */
	private int vergleicheIntegerRueckwaerts(Integer links, Integer rechts) {

		return 0;
	}

	@Test
	@DisplayName("Integer rueckwaerts vergleichen")
	public void test06() {
		assertEquals(1, vergleicheIntegerRueckwaerts(11, 22));
		assertEquals(0, vergleicheIntegerRueckwaerts(11,11));
		assertEquals(-1, vergleicheIntegerRueckwaerts(22,11));
	}
	
	/**
	 * Mit Methode, die einen Vergleichskriteriumextrahierer und einen Rueckwaertsvergleicher nimmt.  
	 * 	  
	 * Beachte dabei den Unterschied zwischen anonymer innerer Klasse und lambda.
	 * 
	 * F�r die �bung mit eigenem Vergleicher starke Vereinfachung akzeptabel.
	 * 
	 */
	private int vergleicheSpielerNachAlterRueckwaertsMitVergleichskriteriumextrahiererUndRueckwaertsvergleicher( Spieler links, Spieler rechts ) {

		return 0;
	}

	@Test
	@DisplayName("vergleiche Spieler nach Alter rueckwaerts mit Vergleichskriteriumextrahierer und Rueckwaertsvergleicher")
	public void test07() {
		assertEquals(1, vergleicheSpielerNachAlterRueckwaertsMitVergleichskriteriumextrahiererUndRueckwaertsvergleicher(KARL_11, ALBERT_22) );
		assertEquals(0, vergleicheSpielerNachAlterRueckwaertsMitVergleichskriteriumextrahiererUndRueckwaertsvergleicher(KARL_11, GUSTAV_11));
		assertEquals(-1, vergleicheSpielerNachAlterRueckwaertsMitVergleichskriteriumextrahiererUndRueckwaertsvergleicher(ALBERT_22, KARL_11 ));
	}

	/**
	 * Hierzu nested class in Zeichenkette, von der dann in Zeichenkette eine Konstante erzeugt wird.
	 */	
	private int vergleicheZeichenketteGrossKleinSchreibungIgnorierend( Zeichenkette links, Zeichenkette rechts ) {

		return 0;
	}

	@Test
	@DisplayName("Zeichenkette vergleichen, dabei Grosskleinschreibung ignorieren")
	public void test08() {
		Zeichenkette eins = new Zeichenkette( "eins" );
		Zeichenkette zwei = new Zeichenkette( "zwei" );
		Zeichenkette einsGross = new Zeichenkette("EINS");
		assertTrue( vergleicheZeichenketteGrossKleinSchreibungIgnorierend(eins, zwei) < 0 );		
		assertEquals(0, vergleicheZeichenketteGrossKleinSchreibungIgnorierend(eins, einsGross));
		assertTrue( vergleicheZeichenketteGrossKleinSchreibungIgnorierend(zwei, eins ) > 0 );
	}	

	/**
	 * Sortieren nach Spitzname
	 */
	private int vergleicheSpielerNachSpitznameRueckwaertsGrossKleinSchreibungIgnorierend( Spieler links, Spieler rechts ) {
		return 0;
	}

	@Test
	@DisplayName("vergleiche Spieler nach Spitzname rueckwaerts Grosskleinschreibung ignorierend")
	public void test09() {
		assertTrue( vergleicheSpielerNachSpitznameRueckwaertsGrossKleinSchreibungIgnorierend( ALBERT_22, KARL_11 ) > 0);
		assertTrue( vergleicheSpielerNachSpitznameRueckwaertsGrossKleinSchreibungIgnorierend( KARL_11, ALBERT_22 ) < 0);
		assertTrue( vergleicheSpielerNachSpitznameRueckwaertsGrossKleinSchreibungIgnorierend( KARL_11, KARL_11 ) == 0);
	}

	/**
	 * Hierzu 2 Methoden schreiben:
	 * - Methode, die einem Vergleicher einen weiteren Vergleicher hinzuf�gt. 
	 * - Methode die die zwei Vergleicher zusammenf�gt 
	 */
	private int vergleicheSpielerNachAlterUndDannNachName( Spieler links, Spieler rechts ) {
		return 0;
	}

	@Test
	@DisplayName("vergleiche Spieler nach Alter und dann nach Name")
	public void test10() {
		assertTrue( vergleicheSpielerNachAlterUndDannNachName( KARL_11, ALBERT_22 ) < 0 );
		assertTrue( vergleicheSpielerNachAlterUndDannNachName( ALBERT_22, KARL_11 ) > 0);

		assertTrue( vergleicheSpielerNachAlterUndDannNachName( GUSTAV_11, KARL_11 ) < 0 );
		assertTrue( vergleicheSpielerNachAlterUndDannNachName( KARL_11, GUSTAV_11 ) > 0 );

		assertTrue( vergleicheSpielerNachAlterUndDannNachName( GUSTAV_11, BERTRAM_33 ) < 0 );
		assertTrue( vergleicheSpielerNachAlterUndDannNachName( BERTRAM_33, GUSTAV_11 ) > 0 );
		
		assertTrue( vergleicheSpielerNachAlterUndDannNachName( BERTRAM_33, BERTRAM_33 ) == 0);
	}

	/**
	 * NullVergleicher zum Vergleichen erstellen.
	 * Parameter ist ein Vergleicher, also nicht eine Method-Referenz.
	 * �ber Vergleicherunterst�tzer und nestend class.
	 */
	public int vergleicheSpielerNachAlterNullBeruecksichtigend( Spieler links, Spieler rechts ) {

		return 0;
	}

	@Test
	@DisplayName("vergleiche Spieler nach Alter null beruecksichtigend")
	public void test11() {
		assertEquals (-1, vergleicheSpielerNachAlterNullBeruecksichtigend( KARL_11, ALBERT_22 ) );
		assertEquals( 1, vergleicheSpielerNachAlterNullBeruecksichtigend( ALBERT_22, KARL_11 ) );
		assertEquals( -1, vergleicheSpielerNachAlterNullBeruecksichtigend( null, ALBERT_22 ) );
		assertEquals( 1, vergleicheSpielerNachAlterNullBeruecksichtigend( KARL_11, null ) );
		assertEquals( 0, vergleicheSpielerNachAlterNullBeruecksichtigend( null, null) );		
	}

	public int vergleicheSpielerNachAlterNullBeruecksichtigendRueckwaerts( Spieler links, Spieler rechts ) {

		return 0;
	}

	@Test
	@DisplayName("vergleiche Spieler nach Alter null beruecksichtigend rueckwaerts")
	public void test12() {
		assertEquals (1, vergleicheSpielerNachAlterNullBeruecksichtigendRueckwaerts( KARL_11, ALBERT_22 ) );
		assertEquals( -1, vergleicheSpielerNachAlterNullBeruecksichtigendRueckwaerts( ALBERT_22, KARL_11 ) );
		assertEquals( 1, vergleicheSpielerNachAlterNullBeruecksichtigendRueckwaerts( null, ALBERT_22 ) );
		assertEquals( -1, vergleicheSpielerNachAlterNullBeruecksichtigendRueckwaerts( KARL_11, null ) );
		assertEquals( 0, vergleicheSpielerNachAlterNullBeruecksichtigendRueckwaerts( null, null) );		
	}	

	private int vergleicheSpielerNachAlterNullBeruecksichtigendUndDannNachName( Spieler links, Spieler rechts ) {

		return 0;
	}

	@Test
	@DisplayName("vergleiche Spieler nach Alter Null beruecksichtigend und dann nach Name")
	public void test13() {
		assertTrue( vergleicheSpielerNachAlterNullBeruecksichtigendUndDannNachName( KARL_11, ALBERT_22 ) < 0 );
		assertTrue( vergleicheSpielerNachAlterNullBeruecksichtigendUndDannNachName( ALBERT_22, KARL_11 ) > 0);

		assertTrue( vergleicheSpielerNachAlterNullBeruecksichtigendUndDannNachName( GUSTAV_11, KARL_11 ) < 0 );
		assertTrue( vergleicheSpielerNachAlterNullBeruecksichtigendUndDannNachName( KARL_11, GUSTAV_11 ) > 0 );

		assertTrue( vergleicheSpielerNachAlterNullBeruecksichtigendUndDannNachName( GUSTAV_11, BERTRAM_33 ) < 0 );
		assertTrue( vergleicheSpielerNachAlterNullBeruecksichtigendUndDannNachName( BERTRAM_33, GUSTAV_11 ) > 0 );
		
		assertTrue( vergleicheSpielerNachAlterNullBeruecksichtigendUndDannNachName( BERTRAM_33, BERTRAM_33 ) == 0);

		assertTrue( vergleicheSpielerNachAlterNullBeruecksichtigendUndDannNachName( null, BERTRAM_33 ) < 0 );
		assertTrue( vergleicheSpielerNachAlterNullBeruecksichtigendUndDannNachName( BERTRAM_33, null ) > 0 );
		
		assertTrue( vergleicheSpielerNachAlterNullBeruecksichtigendUndDannNachName( null, null ) == 0);
	}

	/**
	 * Null beruecksichtigenden Vergleicher, bei dem Null zuerst kommt erstellen.
	 * Als zweites Vergleichskriterium nach Name vergleichen.
	 * @param links
	 * @param rechts
	 * @return
	 */
	private int vergleicheSpielerErsterVergleicherNullZweiterVergleicherNachName( Spieler links, Spieler rechts ) {

		// Soll auch funktionieren, wenn null als Comparator �bergeben wird.
		return 0;
	}

	@Test
	@DisplayName("vergleiche Spieler erster Vergleicher Null zweiter Vergleicher nach Name")
	public void test14() {
		
		assertTrue( vergleicheSpielerErsterVergleicherNullZweiterVergleicherNachName( KARL_11, ALBERT_22 ) > 0 );
		assertTrue( vergleicheSpielerErsterVergleicherNullZweiterVergleicherNachName( ALBERT_22, KARL_11 ) < 0);

		assertTrue( vergleicheSpielerErsterVergleicherNullZweiterVergleicherNachName( GUSTAV_11, KARL_11 ) < 0 );
		assertTrue( vergleicheSpielerErsterVergleicherNullZweiterVergleicherNachName( KARL_11, GUSTAV_11 ) > 0 );

		assertTrue( vergleicheSpielerErsterVergleicherNullZweiterVergleicherNachName( GUSTAV_11, BERTRAM_33 ) > 0 );
		assertTrue( vergleicheSpielerErsterVergleicherNullZweiterVergleicherNachName( BERTRAM_33, GUSTAV_11 ) < 0 );
		
		assertTrue( vergleicheSpielerErsterVergleicherNullZweiterVergleicherNachName( BERTRAM_33, BERTRAM_33 ) == 0);

		assertTrue( vergleicheSpielerErsterVergleicherNullZweiterVergleicherNachName( null, BERTRAM_33 ) < 0 );
		assertTrue( vergleicheSpielerErsterVergleicherNullZweiterVergleicherNachName( BERTRAM_33, null ) > 0 );
		
		assertTrue( vergleicheSpielerErsterVergleicherNullZweiterVergleicherNachName( null, null ) == 0);
	}

	/**
	 * Etwas vergleichen, was auf nat�rliche Art verglichen werden kann.
	 * 
	 * �ber Vergleicherunterst�tzer, Enum als Singelton.
	 * 
	 * Hinweise: enum VergleicherWieComparable implements Vergleicher<Comparable<Object>> { 
	 */
	public int sortiereNachNatuerlicherOrdnung( Fussballer links, Fussballer rechts ) {
		return 0;
	}

	@Test
	@DisplayName("sortiere nach natuerlicher Ordnung")
	public void test15() {		
		Fussballer groesser = new Fussballer(42);
		Fussballer kleiner = new Fussballer(40);
		assertTrue( sortiereNachNatuerlicherOrdnung(groesser, kleiner) > 0 );
		assertTrue( sortiereNachNatuerlicherOrdnung(kleiner, groesser) < 0 );
		assertTrue( sortiereNachNatuerlicherOrdnung(kleiner, kleiner) == 0 );
	}
	
}
