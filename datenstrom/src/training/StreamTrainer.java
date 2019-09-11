package training;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class StreamTrainer {

	/**
	 * �berspringe die ersten Elemente
	 * Zahlen quadrieren
	 * durchschnitt bilden
	 * wenn vorhanden in zahlenListe einf�gen
	 * @param intStream
	 * liste der Zahlen
	 * @param zuUeberspringen
	 * zu ueberspringende Zahlen
	 * @return
	 * Liste, die den Durchschnitt der quadrierten Zahlen enth�lt. 
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
	 * String zur�ckgeben, wenn vorhanden
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
	 * texte zu einem Text �ber Stream
	 * @param texte
	 *  texte, die zusammengef�gt werden sollen
	 * @return
	 * String, der die Werte der Liste durch Komma getrennt enth�lt
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
	 * Stream von String in Map umwandeln, die den String als Key und die Stringl�nge als Value hat.
	 * Dabei auch doppelte Eintr�ge ber�cksichtigen.
	 * @param texte
	 * Was in Map umgewandelt werden soll.
	 * @return 
	 * Map, die den String als Key und die Stringl�nge als Value hat.
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
	
}

