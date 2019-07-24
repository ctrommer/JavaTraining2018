package training;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
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
	 * String zurückgeben, wenn vorhanden
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
	 * texte zu einem Text über Stream
	 * @param texte
	 *  texte, die zusammengefügt werden sollen
	 * @return
	 * String, der die Werte der Liste durch Komma getrennt enthält
	 */
	private String zuEinemDurchKommaGetrenntenString( String ... texte ) {		
		return null;
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
}

