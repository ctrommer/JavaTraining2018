package training;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SchleifeTrainerTest {
	@Test
	@DisplayName("summeMitForSchleife soll "
			+ "die Summe der Werte aus den uebergebenen Werten berechnen")
	public void test01() {
		assertEquals( 
				111, 
				summeMitForSchleife( 1, 10, 100 ) );
	}

	@Test
	@DisplayName("summeElementeMitForInLoop soll "
			+ "die Summe der Elemente liefern")
	public void test02() {
		assertEquals( 
				111, 
				summeElementeMitForInLoop( new int[] { 1, 10, 100 } ) );
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

	@Test
	@DisplayName("collectionMitIteratorZuString soll"
			+ "die Werte mit Iterator zu einem String zusammenfuegen")
	public void test04() {
		assertEquals(
				"UweKarlUta", 
				collectionMitIteratorZuString( namenListe ) );
	}

	@Test
	@DisplayName("collectionMitForInZuString soll"
			+ "die Werte mit for in loop zu einem String zusammenfuegen")
	public void test05() {
		assertEquals(
				"UweKarlUta", 
				collectionMitForInZuString( namenListe ) );		
	}	

	@Test
	@DisplayName("collectionMitWhileZuString soll"
			+ "die Werte mit while zu einem String zusammenfuegen")
	public void test06() {
		assertEquals( 
				"UweKarlUta", 
				collectionMitWhileZuString( namenListe ) );		
	}
	@Test
	@DisplayName("collectionMitForEachZuListe soll"
			+ "die Werte mit for each zu einem String zusammenfuegen")
	public void test07() {
		assertEquals(
				namenListe, 
				collectionMitForEachZuListe(namenListe));		
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

	@Test
	@DisplayName("mapMitWhileZuString soll"
			+ "die Werte der Map mit while zu einem String zusammenfuegen")
	public void test10() {
		assertEquals(
				"UweHamburgKarlBochumUtaAachen", 
				mapMitWhileZuString(nameWohnortMap));		
	}
	

	@Test
	@DisplayName("mapMitIteratorZuString soll"
			+ "die Werte der Map mit iterator zu einem String zusammenfuegen")
	public void test11() {
		assertEquals( "UweHamburgKarlBochumUtaAachen", mapMitIteratorZuString( nameWohnortMap ) );		
	}

	@Test
	@DisplayName("mapMitWhileZuString soll"
			+ "die Werte der Map mit while zu einem String zusammenfuegen")
	public void test10() {
		assertEquals(
				"UweHamburgKarlBochumUtaAachen", 
				mapMitWhileZuString(nameWohnortMap));		
	}	

	@Test
	@DisplayName("mapMitForInZuString soll"
			+ "die Werte der Map mit iterator zu einem String zusammenfuegen")
	public void test12() {
		assertEquals(
				"UweHamburgKarlBochumUtaAachen", 
				mapMitForInZuString(nameWohnortMap ) );		
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
