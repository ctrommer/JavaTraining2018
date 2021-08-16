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
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
	private List<Double> zumQuadratUndDurchschnitt( IntStream intStream, int zuUeberspringen ) {
		List<Double> zahlenListe = new ArrayList<>();
		intStream
			.skip(zuUeberspringen)
			.map( x -> x*x )
			.average()
			.ifPresent(zahl->zahlenListe.add( zahl ) );
		return zahlenListe;
	}

	@Test
	public void testeZumQuadratUndDurchschnitt() {		
		assertEquals( Arrays.asList(66.0), zumQuadratUndDurchschnitt(IntStream.rangeClosed(1, 10), 5 ) );		
	}

	/**
	 * Anzahl Elemente mit Stream ermitteln
	 * @return
	 * Anzahl Elemente
	 */
	private long anzahlElemente( String ... strings ) {		
		return Stream.of(strings)
			.count();
	}

	@Test
	public void testeAnzahlElemente() {
		assertEquals(3, anzahlElemente("Karl", "Arnold", "Franz") );
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
		Stream.of(texte)
			.filter(s->s.startsWith("A"))
			.forEach(name->namenListe.add(name));
		return namenListe;
	}

	@Test
	public void testeNurDieMitAStarten() {
		String[] namen =  { "Karl", "Arnold", "Franz" };
		assertEquals(Arrays.asList("Arnold"), nurDieMitAStarten( namen ));
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
			.orElse(null);
	}

	@Test
	public void testeSortierenUndErstenZurueckgeben() {
		List<String> list = Arrays.asList( "Karl", "Arnold", "Franz" );
		String erster = sortierenUndErstenZurueckgeben(list);
		assertEquals("Arnold", erster);
		
		String leer = sortierenUndErstenZurueckgeben(Arrays.asList());
		assertEquals(null, leer);
	}

	/** 
	 * Dateiinhalt zu stream zu Liste
	 * @param dateiname
	 * @return
	 * Liste der Namen
	 */
	private List<String> dateiLesenMitStream( String dateiname ){
		try (Stream<String> namen = Files.lines(Paths.get(dateiname))) {
			return namen.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Test
	public void testeDateiZuStream() {
		List<String> namenAusDatei = dateiLesenMitStream("namen.txt");
		List<String> erwarteteNamen = Arrays.asList("Arnold", "Karl", "Albert", "Hans");   

		assertEquals(erwarteteNamen, namenAusDatei);
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
	private int summeVonZahlenAusgeben(int erste, int letzte ) {
		return IntStream
				.rangeClosed(erste, letzte)
				.sum();
	}

	@Test
	public void testeSummeVonZahlenAusgeben() {
		assertEquals(55, summeVonZahlenAusgeben(1,10));
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
	private int zahlenMultiplizieren( int erste, int letzte) {
		return IntStream.rangeClosed(erste, letzte)
			.reduce(1, (a,b)->a*b);
	}
	
	@Test
	public void testeZahlenMultiplizieren() {
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
		return Stream.of(texte)
			.map(String::toUpperCase)
			.collect(Collectors.toList());
	}

	@Test
	public void testeUeberStreamZuGrossbuchstaben() {
		 assertEquals(Arrays.asList("HALLO", "WELT"), ueberStreamZuGrossbuchstaben("Hallo", "Welt"));
	}

	/**
	 * texte zu einem Text über Stream
	 * @param texte
	 *  texte, die zusammengefügt werden sollen
	 * @return
	 * String, der die Werte der Liste durch Komma getrennt enthält
	 */
	private String zuEinemDurchKommaGetrenntenString( String ... texte ) {		
		return Stream.of(texte)
			.collect(Collectors.joining(", "));
	}

	@Test
	public void testeZuEinemDurchKommaGetrenntenString( ) {
		assertEquals("Hallo, Welt", zuEinemDurchKommaGetrenntenString("Hallo", "Welt"));
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
		return Stream.of(texte)
			.collect(Collectors.toMap(Function.identity(), String::length, (text1, text2) -> text1));
	}

	@Test
	public void testeStreamZuMap( ) {
		Map<String, Integer> streamZuMap = streamZuMap("Hallo", "Welt");
		Map<String, Integer> erwartet = new LinkedHashMap<>();
		erwartet.put( "Hallo", 5);
		erwartet.put("Welt", 4);
		assertEquals(erwartet, streamZuMap);
	}
	
	private Stream<String> listeVonListeZuEinemStream( List<List<String>> listeVonListe ) {
		return listeVonListe
				.stream()
				.flatMap(Collection::stream);
	}

	@Test
	public void testeListeVonListeZuEinemStream() {
		List<String> ersteListe = Arrays.asList("eins","zwei","drei");
		List<String> zweiteListe = Arrays.asList("vier","fuenf","sechs");

		List<List<String>> listeVonListe = Arrays.asList(ersteListe,zweiteListe);

		Stream<String> erwartetesErgebnis = Stream.concat( ersteListe.stream(), zweiteListe.stream());
		Stream<String> wirklichesErgebnis = listeVonListeZuEinemStream(listeVonListe);

		assertEquals(erwartetesErgebnis.collect(Collectors.toList()), wirklichesErgebnis.collect(Collectors.toList()));
	}

	/**
	 * Die durch Leerzeichen getrennten Wörter werden aus der Datei gelesen
	 * und in eine Map gespeichert. Die Map hat im Key die Wörter der Datei, 
	 * im Value wie oft das Wort in der Datei vorkommt. Die Map wird
	 * alphabetisch sortiert zurückgegeben.
	 * @param dateiname Name der einzulesenden Datei
	 * @return Map mit Namen aus Datei als Key und Häufigkeit als Value
	 */
	private Map<String, Integer> ausDateiInMap( String dateiname ) {
		
		Map<String,Integer> wortUndHaeufigkeit = new TreeMap<>();
		
		try (Stream<String> zeilen = Files.lines(Paths.get(dateiname))) {
			
			zeilen.forEach(zeile-> {
				String[] woerter = zeile.split(" ");
				for ( String wort : woerter ) {					
					Integer haeufigkeit = wortUndHaeufigkeit.get(wort);					
					wortUndHaeufigkeit.put(wort, haeufigkeit == null ? 1 : haeufigkeit + 1 );					
				}
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return wortUndHaeufigkeit;		
	}
	
	@Test
	public void testeAusDateiInMap() {
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
	 * Für die als Parameter übergebene Map sollen Key ( Text ) und Value 
	 * ( wie oft der Text vorkommt ) vertauscht werden.
	 * Zum Key mit der Häufigkeit des Vorkommens ist dann im Value eine Liste
	 * der Strings, die diese Häufigkeit haben. 
	 * Die Map soll nach dem Key sortiert sein.
	 * @param Map, deren Key und Value vertauscht werden sollen 	
	 * @return Map, die als Key die Häufigkeit des Strings und als Value 
	 * eine Liste der Strings mit dieser Häufigkeit enthält
	 */
	private Map<Integer, List<String>> keyUndValueVertauschen( Map<String, Integer> textUndHaeufigkeit ) {
		
		Function<? super Entry<String, Integer>, ? extends Integer> wonachGruppiertWird = Map.Entry::getValue;

		Collector<Entry<String, Integer>, ?, List<String>> wieReduziertWird = Collectors.mapping(Map.Entry::getKey, Collectors.toList());

		Set<Entry<String, Integer>> entrySetTextUndHaeufigkeit = textUndHaeufigkeit.entrySet();

		Map<Integer, List<String>> vertauscht = entrySetTextUndHaeufigkeit
													.stream()
													.collect(Collectors.groupingBy(wonachGruppiertWird, wieReduziertWird));		

		return new TreeMap<>(vertauscht);		
	}

	@Test
	public void testStringsNachHaeufigkeit() {
		
		Map<String, Integer> textUndHaeufigkeit = new HashMap<>();
		
		textUndHaeufigkeit.put("einmal", 1);
		textUndHaeufigkeit.put("dreimal", 3);
		textUndHaeufigkeit.put("auchDreimal", 3);
		textUndHaeufigkeit.put("zweimal", 2);
		
		Map<Integer, List<String>> vertauscht = keyUndValueVertauschen(textUndHaeufigkeit);
		
		Map<Integer, List<String>> haeufigkeitUndText = new TreeMap<>();
		haeufigkeitUndText.put(1, Arrays.asList("einmal"));
		haeufigkeitUndText.put(2, Arrays.asList("zweimal"));
		haeufigkeitUndText.put(3, Arrays.asList("auchDreimal", "dreimal"));
		
		assertEquals( haeufigkeitUndText, vertauscht );		
	}

}

