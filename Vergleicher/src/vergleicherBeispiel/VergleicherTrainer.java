package vergleicherBeispiel;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VergleicherTrainer {

	private static final Spieler KARL_11 = new Spieler("Karl", 11, "Kalle");
	private static final Spieler ALBERT_22 = new Spieler("Albert", 22, "Albi");
	private static final Spieler GUSTAV_11 = new Spieler("Gustav", 11, "Gustel");
	private static final Spieler BERTRAM_33 = new Spieler("Bertram", 33, "Bert");

	private int vergleicheSpielerNachAlterMitAnonymerInnererKlasse(Spieler links, Spieler rechts) {

		Vergleicher<Spieler> spielerVergleicher = new Vergleicher<Spieler>() {
			@Override
			public int vergleiche(Spieler p1, Spieler p2) {
				return p1.getAlter().compareTo(p2.getAlter());
			}
		};

		return spielerVergleicher.vergleiche(links, rechts);
	}

	@Test
	@DisplayName("vergleiche Spieler nach Alter mit anonymer innerer Klasse")
	public void test01() {		
		assertEquals(-1, vergleicheSpielerNachAlterMitAnonymerInnererKlasse(KARL_11, ALBERT_22) );		
		assertEquals(0, vergleicheSpielerNachAlterMitAnonymerInnererKlasse(KARL_11, GUSTAV_11));		
		assertEquals(1, vergleicheSpielerNachAlterMitAnonymerInnererKlasse(ALBERT_22, KARL_11 ));
	}

	private int vergleicheSpielerNachAlterMitLambda(Spieler links, Spieler rechts ) {
		Vergleicher<Spieler> spielerVergleicher = ( p1,  p2) -> p1.getAlter().compareTo(p2.getAlter());
		return spielerVergleicher.vergleiche(links, rechts);
	}

	@Test
	@DisplayName("vergleiche Spieler nach Alter mit Lamda")
	public void test02() {		
		assertEquals(-1, vergleicheSpielerNachAlterMitLambda(KARL_11, ALBERT_22) );		
		assertEquals(0, vergleicheSpielerNachAlterMitLambda(KARL_11, GUSTAV_11));		
		assertEquals(1, vergleicheSpielerNachAlterMitLambda(ALBERT_22, KARL_11 ));
	}	

	private int vergleicheSpielerNachAlterMitLambdaRueckwaerts(Spieler links, Spieler rechts ) {
		Vergleicher<Spieler> spielerVergleicher = ( t1, t2 ) -> t1.getAlter().compareTo(t2.getAlter());
		Vergleicher<Spieler> spielerRueckwaertsVergleicher = spielerVergleicher.erzeugeDarausRueckwaertsVergleicher();
		return spielerRueckwaertsVergleicher.vergleiche(links, rechts);
	}

	@Test
	@DisplayName("vergleiche Spieler nach Alter rueckwaerts mit Lamda")
	public void test03() {
		assertEquals(1, vergleicheSpielerNachAlterMitLambdaRueckwaerts(KARL_11, ALBERT_22) );
		assertEquals(0, vergleicheSpielerNachAlterMitLambdaRueckwaerts(KARL_11, GUSTAV_11));
		assertEquals(-1, vergleicheSpielerNachAlterMitLambdaRueckwaerts(ALBERT_22, KARL_11 ));
	}

	private int vergleicheSpielerNachAlterMitFunktion(Spieler links, Spieler rechts ) {		
		Funktion<Spieler, Integer> spielerZuAlter =  Spieler::getAlter;		
		Vergleicher<Spieler> spielerVergleicher = (p1,  p2) -> spielerZuAlter.machEtwas(p1).compareTo(spielerZuAlter.machEtwas(p2));		
		return spielerVergleicher.vergleiche(links, rechts);
	}

	@Test
	@DisplayName("vergleiche Spieler nach Alter mit Lamda und ( erst mal unnoetiger ) Funktion")
	public void test04() {
		assertEquals(-1, vergleicheSpielerNachAlterMitFunktion(KARL_11, ALBERT_22) );		
		assertEquals(0, vergleicheSpielerNachAlterMitFunktion(KARL_11, GUSTAV_11));		
		assertEquals(1, vergleicheSpielerNachAlterMitFunktion(ALBERT_22, KARL_11 ));
	}	

	private int vergleicheSpielerNachAlterMitFunktionUndStatischerMethodeVonVergleicher( Spieler links, Spieler rechts ) {
		Funktion<Spieler, Integer> spielerZuAlter =  Spieler::getAlter;
		Vergleicher<Spieler> spielerVergleicher = Vergleicher.erzeugeVergleicher( spielerZuAlter );		
		return spielerVergleicher.vergleiche(links, rechts);
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
		Vergleicher<Integer> rueckwaertsVergleicher = Vergleicher.erzeugeRueckwaertsVergleicher();
		return rueckwaertsVergleicher.vergleiche(links, rechts);
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
		Vergleicher<Spieler> spielerVergleicher = Vergleicher.erzeugeVergleicher( Spieler::getAlter , Vergleicher.erzeugeRueckwaertsVergleicher() );
		return spielerVergleicher.vergleiche(links, rechts);
	}

	@Test
	@DisplayName("vergleiche Spieler nach Alter rueckwaerts mit Vergleichskriteriumextrahierer und Rueckwaertsvergleicher")
	public void test07() {
		assertEquals(1, vergleicheSpielerNachAlterRueckwaertsMitVergleichskriteriumextrahiererUndRueckwaertsvergleicher(KARL_11, ALBERT_22) );
		assertEquals(0, vergleicheSpielerNachAlterRueckwaertsMitVergleichskriteriumextrahiererUndRueckwaertsvergleicher(KARL_11, GUSTAV_11));
		assertEquals(-1, vergleicheSpielerNachAlterRueckwaertsMitVergleichskriteriumextrahiererUndRueckwaertsvergleicher(ALBERT_22, KARL_11 ));
	}

	private int vergleicheZeichenketteGrossKleinSchreibungIgnorierend( Zeichenkette links, Zeichenkette rechts ) {
		Vergleicher<Zeichenkette> zeichenketteVergleicher = Zeichenkette.GROSS_KLEIN_SCHEIBUNG_IGNORIERENDER_VERGLEICHER;
		return zeichenketteVergleicher.vergleiche(links, rechts);
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
		return Vergleicher.erzeugeVergleicher( Spieler::getSpitzname, Zeichenkette.GROSS_KLEIN_SCHEIBUNG_IGNORIERENDER_VERGLEICHER).erzeugeDarausRueckwaertsVergleicher().vergleiche(links, rechts);
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
		Vergleicher<Spieler> spielerVergleicher = Vergleicher.erzeugeVergleicher( Spieler::getAlter ).erzeugeMitNaechstemVergleichsKriterium(Spieler::getName);
		return spielerVergleicher.vergleiche(links, rechts);
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
	 */
	public int vergleicheSpielerNachAlterNullBeruecksichtigend( Spieler links, Spieler rechts ) {
		Vergleicher<Spieler> spielerVergleicher = Vergleicher.erzeugeVergleicher( Spieler::getAlter );
		Vergleicher<Spieler> spielerVergleicherNullZuerst = Vergleicher.erzeugeNullZuerstVergleicher(spielerVergleicher);
		return spielerVergleicherNullZuerst.vergleiche( links, rechts );
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
		Vergleicher<Spieler> spielerVergleicher = Vergleicher.erzeugeVergleicher( Spieler::getAlter );
		Vergleicher<Spieler> spielerVergleicherNullZuerst = Vergleicher.erzeugeNullZuerstVergleicher(spielerVergleicher).erzeugeDarausRueckwaertsVergleicher();

		return  spielerVergleicherNullZuerst.vergleiche(links, rechts);
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
		Vergleicher<Spieler> spielerVergleicher = Vergleicher.erzeugeVergleicher( Spieler::getAlter );
		Vergleicher<Spieler> spielerVergleicherNullZuerst = Vergleicher.erzeugeNullZuerstVergleicher(spielerVergleicher).erzeugeMitNaechstemVergleichsKriterium(Spieler::getName);
		return spielerVergleicherNullZuerst.vergleiche( links, rechts );
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
		Vergleicher<Spieler> nullZuerstVergleicherNull = Vergleicher.erzeugeNullZuerstVergleicher(null);
		Vergleicher<Spieler> nullZuerstVergleicherMitZweitemVergleichskriterium = nullZuerstVergleicherNull.erzeugeMitNaechstemVergleichsKriterium(Spieler::getName);
		return nullZuerstVergleicherMitZweitemVergleichskriterium.vergleiche( links, rechts );
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
	 */
	public int sortiereNachNatuerlicherOrdnung( Fussballer links, Fussballer rechts ) {
		Vergleicher<Fussballer> fussballerNummernVergleicher = Vergleicher.erzeugeVergleicherWieComparable();
		return fussballerNummernVergleicher.vergleiche(links, rechts);
	}

	@Test
	@DisplayName("vergleiche nach natuerlicher Ordnung")
	public void test15() {		
		Fussballer groesser = new Fussballer(42);
		Fussballer kleiner = new Fussballer(40);
		assertTrue( sortiereNachNatuerlicherOrdnung(groesser, kleiner) > 0 );
		assertTrue( sortiereNachNatuerlicherOrdnung(kleiner, groesser) < 0 );
		assertTrue( sortiereNachNatuerlicherOrdnung(kleiner, kleiner) == 0 );
	}

	@Test
	@DisplayName("pruefe ob Parameter validiert wurden, also nicht null sind")
	public void test16() {		
		Vergleicher<Spieler> vergleicher = ( links, rechts ) -> links.getAlter().compareTo(rechts.getAlter());
		Funktion<Spieler, Integer> spielerZuAlter = Spieler::getAlter;

		assertThrows(NullPointerException.class, () -> Vergleicher.erzeugeVergleicher(null));
		
		assertThrows(NullPointerException.class, () -> Vergleicher.erzeugeVergleicher(null, vergleicher));
		assertThrows(NullPointerException.class, () -> Vergleicher.erzeugeVergleicher(spielerZuAlter, null));
		
		assertThrows(NullPointerException.class, () -> vergleicher.erzeugeMitNaechstemVergleichsKriterium(null));
		
		assertThrows(NullPointerException.class, () -> vergleicher.fuegeNaechstenVergleicherHinzu(null));
		
	}

}
