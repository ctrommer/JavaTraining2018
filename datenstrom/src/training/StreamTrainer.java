package training;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StreamTrainer {

	/**
	 * überspringe die ersten Elemente
	 * Zahlen quadrieren
	 * durchschnitt bilden
	 * wenn vorhanden in zahlenListe einfügen
	 * @param intStream
	 * liste der Zahlen
	 * @param zuUeberspringen
	 * zu ueberspringende Zahlen
	 * @return
	 * Liste, die den Durchschnitt der quadrierten Zahlen enthält. 
	 */
	private List<Double> zumQuadratUndDurchschnitt( 
										IntStream intStream, 
										int zuUeberspringen ) {
		List<Double> zahlenListe = new ArrayList<>();
		intStream
			.skip( zuUeberspringen )
			.map( x -> x*x )
			.average()
			.ifPresent( zahl -> zahlenListe.add( zahl ) );
		return zahlenListe;
	}

	@Test
	@DisplayName("zumQuadratUndDurchschnitt soll die geforderten Berechnungen durchfuehren")
	public void test01() {		
		assertEquals( 
				Arrays.asList( 66.0 ), 
				zumQuadratUndDurchschnitt( 
									IntStream.rangeClosed( 1, 10 ), 
									5 ) );		
	}

	/**
	 * Anzahl Elemente mit Stream ermitteln
	 * @return
	 * Anzahl Elemente
	 */
	private long anzahlElemente( String ... strings ) {		
		return Stream
				.of(strings)
				.count();
	}

	@Test
	@DisplayName("anzahlElemente soll bei 3 Elementen 3 liefern")
	public void test02() {
		assertEquals(
				3, 
				anzahlElemente("Karl", "Arnold", "Franz") );
	}

	/**
	 * primitives Array
	 * zu stream
	 * filtern auf Elemente, die mit A anfangen
	 * jedes Element einzeln ( ! ) in Liste einfuegen
	 * @param texte
	 * zu filternde Texte
	 * @return
	 * Liste mit den Namen, die mit A starten
	 */
	private List<String> nurDieMitAStarten( String[] texte ) {
		List<String> namenListe = new ArrayList<>();
		Stream
			.of( texte )
			.filter( s -> s.startsWith("A") )
			.forEach( name -> namenListe.add( name ) );
		return namenListe;
	}

	@Test
	@DisplayName("nurDieMitAStarten soll nur die mit A starten zurueckgeben")
	public void test03() {
		String[] namen =  { "Karl", "Arnold", "Franz" };
		assertEquals(
				Arrays.asList("Arnold"), 
				nurDieMitAStarten( namen ) );
	}

	/**
	 * Liste von Strings
	 * in Stream umwandeln
	 * sortieren,  
	 * ersten finden  
	 * String zurückgeben, wenn vorhanden
	 * @return
	 * ersten String wenn vorhanden, sonst null
	 */
	private String sortierenUndErstenZurueckgeben( List<String> strings ) {
		 return strings
			.stream()
			.sorted()
			.findFirst()
			.orElse( null );
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
	
	/** 
	 * Dateiinhalt zu stream zu Liste
	 * @param dateiname
	 * @return
	 * Liste der Namen
	 */
	private List<String> dateiLesenMitStream( String dateiname ){
		try ( Stream<String> namen = Files.lines( Paths.get( dateiname ) ) ) {
			return namen.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Test
	@DisplayName("dateiLesenMitStream soll Dateiinhalt als Liste zurueckgeben")
	public void test06() {
		List<String> namenAusDatei = dateiLesenMitStream("namen.txt");
		List<String> erwarteteNamen = Arrays.asList("Arnold", "Karl", "Albert", "Hans");   

		assertEquals( erwarteteNamen, namenAusDatei );
	}

	/**
	 * Stream von Integer 1-10 erzeugen
	 * @param erste
	 * erste Zahl
	 * @param letzte
	 * letzte Zahl
	 * @return
	 * Summe der Zahlen
	 * 
	 */
	private int summeVonZahlenAusgeben( int erste, int letzte ) {
		return IntStream
					.rangeClosed( erste, letzte )
					.sum();
	}

	@Test
	@DisplayName("summeVonZahlenAusgeben soll die summe der Zahlen 1 bis 10 ausgeben")
	public void test07() {
		assertEquals( 
				55, 
				summeVonZahlenAusgeben( 1, 10 ) );
	}

	/**
	 * Stream von Integer von erste bis letzte erzeugen
	 * alle Zahlen miteinander multiplizieren
	 * @param erste
	 * erste Zahl
	 * @param letzte
	 * letzte Zahl
	 * @return
	 * alle Zahlen miteinander multipliziert
	 */
	private int zahlenMultiplizieren( int erste, int letzte ) {
		return IntStream
					.rangeClosed( erste, letzte )
					.reduce( 1, ( a, b ) -> a*b );
	}
	
	@Test
	@DisplayName("zahlenMultiplizieren von 1 bis 5")
	public void test08() {
		assertEquals(120, zahlenMultiplizieren(1,5));
	}

	/**
	 * Liste zu Stream
	 * in Grossbuchstaben
	 * @param texte
	 * Liste von Namen
	 * @return
	 * Texte in Grossbuchstaben umgewandelt
	 */
	private List<String> ueberStreamZuGrossbuchstaben( String ... texte ) {
		return Stream
				.of( texte )
				.map( String::toUpperCase )
				.collect( Collectors.toList() );
	}

	@Test
	@DisplayName("ueberStreamZuGrossbuchstaben soll mit Stream in Grossbuchstaben umwandeln")
	public void test09() {
		 assertEquals( 
				 Arrays.asList("HALLO", "WELT"), 
				 ueberStreamZuGrossbuchstaben( "Hallo", "Welt") );
	}

	/**
	 * texte zu einem Text über Stream
	 * @param texte
	 *  texte, die zusammengefügt werden sollen
	 * @return
	 * 	String, der die Werte der Liste durch Komma getrennt enthält
	 */
	private String zuEinemDurchKommaGetrenntenString( String ... texte ) {		
		return Stream
				.of(texte)
				.collect( Collectors.joining(", ") );
	}

	@Test
	@DisplayName("zuEinemDurchKommaGetrenntenString")
	public void test10( ) {
		assertEquals(
				"Hallo, Welt", 
				zuEinemDurchKommaGetrenntenString( "Hallo", "Welt" ) );
	}
	
	/**
	 * Stream von String in Map umwandeln, die den String als Key und die Stringlänge als Value hat.
	 * Dabei auch doppelte Einträge berücksichtigen.
	 * @param texte
	 * Was in Map umgewandelt werden soll.
	 * @return 
	 * Map, die den String als Key und die Stringlänge als Value hat.
	 * 
	 */
	private Map<String, Integer> streamZuMap( String ... texte ) {		
		return Stream
					.of( texte )
					.collect( Collectors.toMap( 
											Function.identity(), 
											String::length, 
											( text1, text2 ) -> text1 ) );
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
	
	private Stream<String> listeVonListeZuEinemStream( List<List<String>> listeVonListe ) {
		return listeVonListe
						.stream()
						.flatMap( Collection::stream );
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

	/**
	 * Die durch Leerzeichen getrennten Wörter werden aus der Datei gelesen
	 * und in eine Map gespeichert.
	 *  
	 * Die Map hat im Key die Wörter der Datei, 
	 * im Value wie oft das Wort in der Datei vorkommt.
	 *  
	 * Die Map wird alphabetisch sortiert zurückgegeben.
	 * 
	 * @param dateiname Name der einzulesenden Datei
	 * @return Map mit Namen aus Datei als Key und Häufigkeit als Value
	 */
	private Map<String, Integer> ausDateiInMap( String dateiname ) {

		Map<String,Integer> wortUndHaeufigkeit = new TreeMap<>();

		try( Stream<String> zeilen = Files.lines( Paths.get( dateiname ) ) ) {
			zeilen.forEach( zeile -> {
				Stream
					.of( zeile.split(" ") )
							.forEach( wort -> wortUndHaeufigkeit.put( 
																	wort, 
																	Optional.ofNullable( wortUndHaeufigkeit.get( wort ) ).orElse( 0 ) + 1) );
			});
		} catch (IOException e) {
			e.printStackTrace();
		};

		return wortUndHaeufigkeit;
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

	/**
	 * Aus der Liste von Woertern wird eine Map erzeugt. Key dieser Map
	 * ist die Wortlaenge. Value ist eine Liste der Woerter mit dieser
	 * Wortlaenge.
	 * z.B.:
	 * List.of("sie", "die", "was", "vier", "Baum", "Auto", "fuenf")
	 * ->
	 * key 	value
	 * 3	=[sie, die, was], 
	 * 4	=[vier, Baum, Auto], 
	 * 5	=[fuenf]
	 *  
	 * @param woerterUnterschiedlicherLaenge
	 * @return map mit wortlaenge als key und Liste der Woerter mit dieser 
	 * Wortlaenge als value.
	 */
	private Map<Integer,List<String>> woerterNachLaengeGruppieren( List<String> woerterUnterschiedlicherLaenge ) {		
		return woerterUnterschiedlicherLaenge
				.stream()
				.collect( Collectors.groupingBy( String::length ) );		
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

	/**
	 * Aus der Liste von Woertern wird eine Map erzeugt. 
	 * Key dieser Map sind die unterschiedlichen Woerter. 
	 * Im Value steht, wie oft das Wort vorkommt. 
	 *  
	 * @param woerterUnterschiedlicherLaenge
	 * @return Map mit Wort als key und Haeufigkeit des Wortes als value. 
	 */
	private Map<String, Long> woerterNachHaeufigkeitGruppieren( List<String> woerter ) {
        return woerter
        			.stream()
        			.collect( Collectors
        						.groupingBy( 
        								Function.identity(), 
        								Collectors.counting() ) );
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

	static class Person {
		String name;
		Integer alter;

		public Person(String name, Integer alter) {
			this.name = name;
			this.alter = alter;
		}
		public Integer getAlter() {
			return alter;
		}
		public String getName() {
			return name;
		}		
	}

	/**
	 * Liste von Personen wird zu Map gruppiert nach Alter der Personen. 
	 * Key ist das Alter, der Value eine Liste der Namen mit diesem Alter. 
	 * @param personen
	 * 	Liste der nach Alter zu gruppierenden Personen
	 * @return
	 * 	Map mit Alter als Key und der Liste der Namen als Value
	 */
	private Map<Integer, List<String>> personenNachAlterGruppieren( List<Person> personen ) {
        return personen
    			.stream()
    			.collect( Collectors
    					.groupingBy( 
    							Person::getAlter, 
    							Collectors.mapping(
    											Person::getName, 
    											Collectors.toList() ) ) );
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

	/**
	 * Für die als Parameter übergebene Map sollen Key ( Text ) und Value 
	 * ( wie oft der Text vorkommt ) vertauscht werden.
	 * 
	 * Zum Key mit der Häufigkeit des Vorkommens ist dann im Value eine Liste
	 * der Strings, die diese Häufigkeit haben.
	 *  
	 * Die Map soll nach dem Key sortiert sein.
	 * 
	 * @param Map, deren Key und Value vertauscht werden sollen 	
	 * @return Map, die als Key die Häufigkeit des Strings und als Value 
	 * eine Liste der Strings mit dieser Häufigkeit enthält
	 */
	private Map<Integer, List<String>> keyUndValueVertauschen( Map<String, Integer> textUndHaeufigkeit ) {

		Set<Entry<String, Integer>> entrySetTextUndHaeufigkeit = textUndHaeufigkeit.entrySet();
		Map<Integer, List<String>> vertauscht 
										= entrySetTextUndHaeufigkeit
																.stream()
																.collect( Collectors.groupingBy( 
																							entry -> entry.getValue(), 
																							Collectors.mapping( 
																											Map.Entry::getKey, 
																											Collectors.toList() ) ) );
		return new TreeMap<>( vertauscht );
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

