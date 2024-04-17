package training;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import training.StreamTrainer.Person;

public class StreamTrainerTest {
	@Test
	@DisplayName("zumQuadratUndDurchschnitt soll die geforderten Berechnungen durchfuehren")
	public void test01() {		
		assertEquals( 
				Arrays.asList( 66.0 ), 
				zumQuadratUndDurchschnitt( 
									IntStream.rangeClosed( 1, 10 ), 
									5 ) );		
	}

	@Test
	@DisplayName("anzahlElemente soll bei 3 Elementen 3 liefern")
	public void test02() {
		assertEquals(
				3, 
				anzahlElemente("Karl", "Arnold", "Franz") );
	}
	
	@Test
	@DisplayName("nurDieMitAStarten soll nur die mit A starten zurueckgeben")
	public void test03() {
		String[] namen =  { "Karl", "Arnold", "Franz" };
		assertEquals(
				Arrays.asList("Arnold"), 
				nurDieMitAStarten( namen ) );
	}
	

	@Test
	@DisplayName("sortierenUndErstenZurueckgeben fuer Liste mit Elementen")
	public void test04() {
		List<String> list = Arrays.asList( "Karl", "Arnold", "Franz" );
		String erster = sortierenUndErstenZurueckgeben( list );
		assertEquals( "Arnold", erster );		
	}

	@Test
	@DisplayName("sortierenUndErstenZurueckgeben fuer leere Liste")
	public void test05() {
		String leer = sortierenUndErstenZurueckgeben( Arrays.asList() );
		assertEquals( null, leer );
	}
	

	@Test
	@DisplayName("dateiLesenMitStream soll Dateiinhalt als Liste zurueckgeben")
	public void test06() {
		List<String> namenAusDatei = dateiLesenMitStream("namen.txt");
		List<String> erwarteteNamen = Arrays.asList("Arnold", "Karl", "Albert", "Hans");   

		assertEquals( erwarteteNamen, namenAusDatei );
	}
	
	@Test
	@DisplayName("summeVonZahlenAusgeben soll die summe der Zahlen 1 bis 10 ausgeben")
	public void test07() {
		assertEquals( 
				55, 
				summeVonZahlenAusgeben( 1, 10 ) );
	}
	
	@Test
	@DisplayName("zahlenMultiplizieren von 1 bis 5")
	public void test08() {
		assertEquals(120, zahlenMultiplizieren(1,5));
	}
	
	@Test
	@DisplayName("ueberStreamZuGrossbuchstaben soll mit Stream in Grossbuchstaben umwandeln")
	public void test09() {
		 assertEquals( 
				 Arrays.asList("HALLO", "WELT"), 
				 ueberStreamZuGrossbuchstaben( "Hallo", "Welt") );
	}
	
	@Test
	@DisplayName("zuEinemDurchKommaGetrenntenString")
	public void test10( ) {
		assertEquals(
				"Hallo, Welt", 
				zuEinemDurchKommaGetrenntenString( "Hallo", "Welt" ) );
	}
	
	@Test
	@DisplayName("streamZuMap soll Texte in Map einfuegen")
	public void test11( ) {
		Map<String, Integer> streamZuMap = streamZuMap("Hallo", "Welt", "Welt");
		Map<String, Integer> erwartet = new LinkedHashMap<>();
		erwartet.put( "Hallo", 5 );
		erwartet.put( "Welt", 4 );
		assertEquals( erwartet, streamZuMap );
	}
	
	@Test
	@DisplayName("listeVonListeZuEinemStream soll Liste von Liste in einen Stream umwandeln")
	public void test12() {
		List<String> ersteListe = Arrays.asList("eins","zwei","drei");
		List<String> zweiteListe = Arrays.asList("vier","fuenf","sechs");

		List<List<String>> listeVonListe = Arrays.asList(
													ersteListe,
													zweiteListe);

		Stream<String> erwartetesErgebnis = Stream.concat( 
													ersteListe.stream(), 
													zweiteListe.stream());
		
		Stream<String> wirklichesErgebnis = listeVonListeZuEinemStream( listeVonListe );

		assertEquals( 
				erwartetesErgebnis.collect( Collectors.toList() ), 
				wirklichesErgebnis.collect( Collectors.toList() ) );
	}
	
	@Test
	@DisplayName("ausDateiInMap soll Werte aus Datei in Map einfuegen")
	public void test13() {
		Map<String,Integer> erwartetesErgebnis = new TreeMap<>();
		erwartetesErgebnis.put("auchDreimal", 3);
		erwartetesErgebnis.put("dreimal", 3);
		erwartetesErgebnis.put("einmal", 1);
		erwartetesErgebnis.put("viermal", 4);
		erwartetesErgebnis.put("zweimal", 2);
		
		Map<String, Integer> stringsNachHaeufigkeit = ausDateiInMap("mehrzeiligerText.txt");
		assertEquals(erwartetesErgebnis, stringsNachHaeufigkeit);		
	}
	
	@Test
	@DisplayName("woerterNachLaengeGruppieren soll die Woerter nach ihrer Laenge gruppieren")
	public void test14() {
		
		List<String> woerterUnterschiedlicherLaenge = List.of("sie", "die", "was", "vier", "Baum", "Auto", "fuenf");
		
		Map<Integer, List<String>> woerterNachLaengeGruppiert = woerterNachLaengeGruppieren( woerterUnterschiedlicherLaenge );
		
		Map<Integer, List<String>> haeufigkeitUndText = new TreeMap<>();
		haeufigkeitUndText.put( 3, Arrays.asList("sie", "die", "was") );
		haeufigkeitUndText.put( 4, Arrays.asList("vier", "Baum", "Auto") );
		haeufigkeitUndText.put( 5, Arrays.asList("fuenf") );
		
		assertEquals( 
				haeufigkeitUndText, 
				woerterNachLaengeGruppiert );		
	}
	
	@Test
	@DisplayName("woerterNachHaeufigkeitGruppieren soll nach Haeufigkeit gruppieren")
	public void test15() {
		
		List<String> woerter = List.of(
				"auchDreimal", "auchDreimal", "auchDreimal",
				"dreimal", "dreimal", "dreimal", 
				"einmal", 				 
				"zweimal", "zweimal" );

		Map<String, Long> woerterNachHaeufigkeitGruppiert = new TreeMap<>( woerterNachHaeufigkeitGruppieren( woerter ) ); 

		Map<String, Long> haeufigkeitUndText = new TreeMap<>();
		haeufigkeitUndText.put("einmal", 1L);
		haeufigkeitUndText.put("dreimal", 3L);
		haeufigkeitUndText.put("auchDreimal", 3L);
		haeufigkeitUndText.put("zweimal", 2L);
		
		assertEquals( haeufigkeitUndText, woerterNachHaeufigkeitGruppiert );
	}
	
	@Test
	@DisplayName("personenNachAlterGruppieren soll die Personen nach Alter gruppieren")
	public void test16() {
		
		List<Person> personenUnterschiedlicherLaenge 
											= List.of(
													new Person( "Kevin", 12 ), 
													new Person( "Karl", 42 ), 
													new Person( "Walter", 42 ), 
													new Person( "Walter", 42 ), 
													new Person( "Arnold", 43 ), 
													new Person( "Arnold", 44 ) );

		Map<Integer, List<String>> personenNachAlterGruppiert = personenNachAlterGruppieren( personenUnterschiedlicherLaenge );

		Map<Integer, List<String>> alterUndNamenliste = new TreeMap<>();
		alterUndNamenliste.put(12, Arrays.asList("Kevin"));
		alterUndNamenliste.put(42, Arrays.asList("Karl", "Walter", "Walter"));
		alterUndNamenliste.put(43, Arrays.asList("Arnold"));
		alterUndNamenliste.put(44, Arrays.asList("Arnold"));

		assertEquals( alterUndNamenliste, personenNachAlterGruppiert );
	}
	
	@Test
	@DisplayName("keyUndValueVertauschen soll key und value vertauschen")
	public void test17() {
		
		Map<String, Integer> textUndHaeufigkeit = new HashMap<>();
		
		textUndHaeufigkeit.put( "einmal", 1 );
		textUndHaeufigkeit.put( "dreimal", 3 );
		textUndHaeufigkeit.put( "auchDreimal", 3 );
		textUndHaeufigkeit.put( "zweimal", 2 );
		
		Map<Integer, List<String>> vertauscht = keyUndValueVertauschen( textUndHaeufigkeit );
		
		Map<Integer, List<String>> haeufigkeitUndText = new TreeMap<>();
		haeufigkeitUndText.put( 1, Arrays.asList("einmal") );
		haeufigkeitUndText.put( 2, Arrays.asList("zweimal") );
		haeufigkeitUndText.put( 3, Arrays.asList("auchDreimal", "dreimal") );

		assertEquals( haeufigkeitUndText, vertauscht );
	}

}
