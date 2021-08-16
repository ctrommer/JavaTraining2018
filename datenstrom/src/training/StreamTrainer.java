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
		return 1;
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
		 return null;
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
		return null;
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
		return 1;
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
		return 1;
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
		return null;
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
		return null;
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
		return null;
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
		return null;
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
	 * Die durch Leerzeichen getrennten W�rter werden aus der Datei gelesen
	 * und in eine Map gespeichert. Die Map hat im Key die W�rter der Datei, 
	 * im Value wie oft das Wort in der Datei vorkommt. Die Map wird
	 * alphabetisch sortiert zur�ckgegeben.
	 * @param dateiname Name der einzulesenden Datei
	 * @return Map mit Namen aus Datei als Key und H�ufigkeit als Value
	 */
	private Map<String, Integer> ausDateiInMap( String dateiname ) {
		
		Map<String,Integer> wortUndHaeufigkeit = new TreeMap<>();
		
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
	 * F�r die als Parameter �bergebene Map sollen Key ( Text ) und Value 
	 * ( wie oft der Text vorkommt ) vertauscht werden.
	 * Zum Key mit der H�ufigkeit des Vorkommens ist dann im Value eine Liste
	 * der Strings, die diese H�ufigkeit haben. 
	 * Die Map soll nach dem Key sortiert sein.
	 * @param Map, deren Key und Value vertauscht werden sollen 	
	 * @return Map, die als Key die H�ufigkeit des Strings und als Value 
	 * eine Liste der Strings mit dieser H�ufigkeit enth�lt
	 */
	private Map<Integer, List<String>> keyUndValueVertauschen( Map<String, Integer> textUndHaeufigkeit ) {

		return null;		
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

