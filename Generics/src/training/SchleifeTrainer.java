package training;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SchleifeTrainer {
	
	private static Collection<String> namenListe = new ArrayList<>();
	
	private static Map<String, String> nameWohnortMap = new LinkedHashMap<String, String>();

	@BeforeAll
	public static void bevorDieTestsStarten() {
		namenListe.add("Uwe");
		namenListe.add("Karl");
		namenListe.add("Uta");
		
		nameWohnortMap.put("Uwe", "Hamburg");
		nameWohnortMap.put("Karl", "Bochum");
		nameWohnortMap.put("Uta", "Aachen");
	}

	/**
	 * Erzeuge aus den Zahlen ein Array.
	 * Ermittle die Summe der Array Elemente mit for Schleife.
	 * 
	 * @param zahl1 erstes aufzusummierendes Element
	 * @param zahl2 zweites aufzusummierendes Element
	 * @param zahl3 drittes aufzusummierendes Element
	 * @return
	 * Summe der Elemente
	 */
	private int summeMitForSchleife( int zahl1, int zahl2, int zahl3 ) {
		int summe = 0;
		return summe;
	}

	@Test
	@DisplayName("summeMitForSchleife soll "
			+ "die Summe der Werte aus den uebergebenen Werten berechnen")
	public void test01() {
		assertEquals( 
				111, 
				summeMitForSchleife( 1, 10, 100 ) );
	}

	/**
	 * Ermittle die Summe der Array Elemente mit for in loop
	 * 
	 * @param intArray
	 * Feld, dessen Elemente aufsummiert werden
	 * @return
	 * Summe der Elemente
	 */
	private int summeElementeMitForInLoop( int[] intArray ) {
		int summe = 0;

		return summe;
	}

	@Test
	@DisplayName("summeElementeMitForInLoop soll "
			+ "die Summe der Elemente liefern")
	public void test02() {
		assertEquals( 
				111, 
				summeElementeMitForInLoop( new int[] { 1, 10, 100 } ) );
	}

	/** 
	 * Erzeuge aus den übergebenen Werten ein Array.
	 * Fuege die Elemente des Arrays mit einer for in loop in eine Liste.
	 * 
	 * @param erster erstes in Liste einzufuegendes Element
	 * @param zweiter zweites in Liste einzufuegendes Element
	 * @param dritter drittes in Liste einzufuegendes Element
	 * @return
	 * Liste der Elemente
	 */
	private List<Boolean> booleanMitForInZuListe( 
										boolean erster, 
										boolean zweiter, 
										boolean dritter ) {
		
		List<Boolean> ergebnis = new ArrayList<>();
		return ergebnis;
	}
	
	@Test
	@DisplayName("booleanMitForInZuListe soll die Werte "
			+ "ueber Array und mit for in loop in die Liste einfuegen")
	public void test03() {
		boolean erster = false;
		boolean zweiter = false;
		boolean dritter = true;
		List<Boolean> erwartet = Arrays.asList( erster, zweiter, dritter );
		assertEquals(
				erwartet, 
				booleanMitForInZuListe( erster, zweiter, dritter ) );
	}

	private String collectionMitIteratorZuString( Collection<String> namenCollection ) {
		StringBuilder aneinandergehaengt = new StringBuilder();
		return aneinandergehaengt.toString();
	}

	@Test
	@DisplayName("collectionMitIteratorZuString soll"
			+ "die Werte mit Iterator zu einem String zusammenfuegen")
	public void test04() {
		assertEquals(
				"UweKarlUta", 
				collectionMitIteratorZuString( namenListe ) );
	}

	private String collectionMitForInZuString( Collection<String> namenCollection ) {
		StringBuilder aneinandergehaengt = new StringBuilder();
		return aneinandergehaengt.toString();
	}

	@Test
	@DisplayName("collectionMitForInZuString soll"
			+ "die Werte mit for in loop zu einem String zusammenfuegen")
	public void test05() {
		assertEquals(
				"UweKarlUta", 
				collectionMitForInZuString( namenListe ) );		
	}	

	private String collectionMitWhileZuString( Collection<String> namenCollection ) {
		StringBuilder aneinandergehaengt = new StringBuilder();

		return aneinandergehaengt.toString();
	}

	@Test
	@DisplayName("collectionMitWhileZuString soll"
			+ "die Werte mit while zu einem String zusammenfuegen")
	public void test06() {
		assertEquals( 
				"UweKarlUta", 
				collectionMitWhileZuString( namenListe ) );		
	}

	private List<String> collectionMitForEachZuListe( Collection<String> namenCollection ) {
		List<String> ergebnisListe = new ArrayList<>();
		return ergebnisListe;
	}

	@Test
	@DisplayName("collectionMitForEachZuListe soll"
			+ "die Werte mit for each zu einem String zusammenfuegen")
	public void test07() {
		assertEquals(
				namenListe, 
				collectionMitForEachZuListe(namenListe));		
	}

	private void elementAusListeLoeschenMitIterator( 
											Collection<String> liste, 
											String zuLoeschenderEintrag ) {
	}

	@Test
	@DisplayName("elementAusListeLoeschenMitIterator soll"
			+ "einen Wert durch iterator loeschen")
	public void test08() {

		Collection<String> erwarteteListe = new ArrayList<>();

		erwarteteListe.add( "Uwe" );
		erwarteteListe.add( "Karl" );
		
		elementAusListeLoeschenMitIterator( namenListe, "Uta" );
		assertEquals( 
				erwarteteListe, 
				namenListe );
		
		namenListe.add( "Uta" );
	}

	private void elementAusListeLoeschenMitPredicate( 
												Collection<String> liste, 
												String zuLoeschenderEintrag ) {
	}

	@Test
	@DisplayName("elementAusListeLoeschenMitPredicate soll"
			+ "einen Wert durch predicate loeschen")
	public void test09() {

		Collection<String> erwarteteListe = new ArrayList<>();
		erwarteteListe.add("Uwe");
		erwarteteListe.add("Karl");
		
		elementAusListeLoeschenMitPredicate( namenListe, "Uta" );
		
		assertEquals( 
				erwarteteListe, 
				namenListe );
		
		namenListe.add( "Uta" );
	}

	/**
	 * Fuegt key und value aller map Eintraege ohne Leerzeichen
	 * zu einem String zusammen.
	 * z.B.: UweHamburgKarlBochum 
	 * 
	 * @param map die Werte, die zusammengefuegt werden sollen
	 * @return key und value aller Eintaege ohne Leerzeichen
	 */
	private String mapMitWhileZuString( Map<String, String> map  ) {
		String aneinandergehaengt = "";

		return aneinandergehaengt;
	}

	@Test
	@DisplayName("mapMitWhileZuString soll"
			+ "die Werte der Map mit while zu einem String zusammenfuegen")
	public void test10() {
		assertEquals(
				"UweHamburgKarlBochumUtaAachen", 
				mapMitWhileZuString(nameWohnortMap));		
	}

	private String mapMitIteratorZuString( Map<String, String> map  ) {
		String aneinandergehaengt = new String();
		return aneinandergehaengt;
	}

	@Test
	@DisplayName("mapMitIteratorZuString soll"
			+ "die Werte der Map mit iterator zu einem String zusammenfuegen")
	public void test11() {
		assertEquals( "UweHamburgKarlBochumUtaAachen", mapMitIteratorZuString( nameWohnortMap ) );		
	}

	private String mapMitForInZuString( Map<String, String> map  ) {
		String aneinandergehaengt = "";
		return aneinandergehaengt;
	}

	@Test
	@DisplayName("mapMitForInZuString soll"
			+ "die Werte der Map mit iterator zu einem String zusammenfuegen")
	public void test12() {
		assertEquals(
				"UweHamburgKarlBochumUtaAachen", 
				mapMitForInZuString(nameWohnortMap ) );		
	}	

	private Map<String, String> mapMitForEachZuMapKeyValueVertauscht( Map<String, String> map ) {
		Map<String, String> keyValueVertauscht = new LinkedHashMap<String, String>();
		return keyValueVertauscht;
	}

	@Test
	@DisplayName("mapMitForEachZuMapKeyValueVertauscht soll"
			+ "key und value mit for each vertauschen")
	public void test13() {
		Map<String, String> wohnortName = new LinkedHashMap<>();

		wohnortName.put( "Hamburg", "Uwe" );
		wohnortName.put( "Bochum", "Karl" );
		wohnortName.put( "Aachen", "Uta" );
	
		assertEquals( 
				wohnortName, 
				mapMitForEachZuMapKeyValueVertauscht( nameWohnortMap ) );		
	}

	private static Map<String, String> sortiereMapNachKey( Map<String, String> map ) {
		Map<String, String> sorted = null;
		return sorted;		
	}
	
	@Test
	@DisplayName("sortiereMapNachKey soll"
			+ "map nach key sortieren")
	public void test14() {
		Map<String, String> erwartet = new LinkedHashMap<String, String>();

		erwartet.put("Karl", "Bochum");
		erwartet.put("Uta", "Aachen");
		erwartet.put("Uwe", "Hamburg");

		assertEquals( 
				erwartet, 
				sortiereMapNachKey( nameWohnortMap ) );
	}
	
}
