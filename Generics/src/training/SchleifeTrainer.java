package training;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import org.junit.jupiter.api.BeforeAll;
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
	 * Ermittelt die Summe der Array Elemente mit for Schleife.
	 * 
	 * @param intArray
	 * Feld, dessen Elemente aufsummiert werden
	 * @return
	 * Summe der Elemente
	 */
	private int summeArrayElementeMitForSchleife( int[] intArray ) {
		int summe = 0;

		return summe;
	}

	@Test
	public void testeSummeArrayElementeMitForSchleife() {
		assertEquals(6, summeArrayElementeMitForSchleife(new int[] {1,2,3}));
	}

	/**
	 * Ermittelt die Summe der Array Elemente mit for in loop
	 * 
	 * @param intArray
	 * Feld, dessen Elemente aufsummiert werden
	 * @return
	 * Summe der Elemente
	 */
	private int summeArrayElementeMitForInLoop( int[] intArray ) {
		int summe = 0;

		return summe;
	}

	@Test
	public void testeSummeArrayElementeMitForInLoop() {
		assertEquals(6, summeArrayElementeMitForInLoop( new int[] {1,2,3}) );
	}

	private List<Boolean> primitivesBoolschesArrayMitForInZuListe() {
		List<Boolean> ergebnis = new ArrayList<>();

		return ergebnis;
	}
	
	@Test
	public void testePrimitivesBoolschesArrayMitForInZuListe() {
		List<Boolean> erwartet = Arrays.asList( true, false );
		assertEquals(erwartet, primitivesBoolschesArrayMitForInZuListe());
	}

	private String collectionMitIteratorZuString( Collection<String> namenCollection ) {
		String aneinandergehaengt = new String();

		return aneinandergehaengt;
	}

	@Test
	public void testeCollectionMitIteratorZuString() {
		assertEquals("UweKarlUta", collectionMitIteratorZuString(namenListe));
	}

	private String collectionMitForInZuString( Collection<String> namenCollection ) {
		String aneinandergehaengt = new String();

		return aneinandergehaengt;
	}
	
	@Test
	public void testeCollectionMitForInZuString() {
		assertEquals("UweKarlUta", collectionMitForInZuString(namenListe));		
	}	

	private String collectionMitWhileZuString( Collection<String> namenCollection ) {
		String aneinandergehaengt = new String();

		return aneinandergehaengt;
	}

	@Test
	public void testeCollectionMitWhileZuString() {
		assertEquals("UweKarlUta", collectionMitWhileZuString(namenListe));		
	}

	private List<String> collectionMitForEachZuListe( Collection<String> namenCollection ) {
		List<String> ergebnisListe = new ArrayList<>();

		return ergebnisListe;
	}

	@Test
	public void testeCollectionMitForEachZuListe() {
		assertEquals(namenListe, collectionMitForEachZuListe(namenListe));		
	}

	private void elementAusListeLoeschenMitIterator( Collection<String> liste, String zuLoeschenderEintrag ) {

	}

	@Test
	public void testeElementAusListeLoeschenMitIterator() {

		Collection<String> erwarteteListe = new ArrayList<>();

		erwarteteListe.add("Uwe");
		erwarteteListe.add("Karl");

		
		elementAusListeLoeschenMitIterator(namenListe, "Uta");
		assertEquals(erwarteteListe, namenListe);
		namenListe.add("Uta");
	}

	private void elementAusListeLoeschenMitPredicate( Collection<String> liste, String zuLoeschenderEintrag ) {
	}

	@Test
	public void testeElementAusListeLoeschenMitPredicate() {

		Collection<String> erwarteteListe = new ArrayList<>();

		erwarteteListe.add("Uwe");
		erwarteteListe.add("Karl");

		
		elementAusListeLoeschenMitPredicate(namenListe, "Uta");
		assertEquals(erwarteteListe, namenListe);
		namenListe.add("Uta");
	}

	private String mapMitWhileZuString( Map<String, String> map  ) {
		String aneinandergehaengt = new String();

		return aneinandergehaengt;
	}

	@Test
	public void testeMapMitWhileZuString() {
		assertEquals("UweHamburgKarlBochumUtaAachen", mapMitWhileZuString(nameWohnortMap));		
	}

	private String mapMitIteratorZuString( Map<String, String> map  ) {
		String aneinandergehaengt = new String();

		return aneinandergehaengt;
	}

	@Test
	public void testeMapMitIteratorZuString() {
		assertEquals("UweHamburgKarlBochumUtaAachen", mapMitIteratorZuString(nameWohnortMap));		
	}

	private String mapMitForInZuString( Map<String, String> map  ) {
		String aneinandergehaengt = new String();

		return aneinandergehaengt;
	}

	@Test
	public void testeMapMitForInZuString() {
		assertEquals("UweHamburgKarlBochumUtaAachen", mapMitForInZuString(nameWohnortMap));		
	}	

	private Map<String, String> mapMitForEachZuMapKeyValueVertauscht( Map<String, String> map ) {
		Map<String, String> keyValueVertauscht = new LinkedHashMap<String, String>();
		
		return keyValueVertauscht;
	}

	@Test
	public void testeMapMitForEachZuMapKeyValueVertauscht() {
		Map<String, String> wohnortName = new LinkedHashMap<>();

		wohnortName.put("Hamburg", "Uwe");
		wohnortName.put("Bochum", "Karl");
		wohnortName.put("Aachen", "Uta");
	
		assertEquals(wohnortName, mapMitForEachZuMapKeyValueVertauscht(nameWohnortMap));		
	}		

	private static Map<String, String> sortiereMapNachKey( Map<String, String> map ) {
		Map<String, String> sorted = null;
		return sorted;		
	}
	
	@Test
	public void testeSortiereMapNachKey() {
		Map<String, String> erwartet = new LinkedHashMap<String, String>();

		erwartet.put("Karl", "Bochum");
		erwartet.put("Uta", "Aachen");
		erwartet.put("Uwe", "Hamburg");

		assertEquals(erwartet, sortiereMapNachKey(nameWohnortMap));
	}
	
}
