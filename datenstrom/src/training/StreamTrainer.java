package training;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
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
	private List<Double> zumQuadratUndDurchschnitt( 
										IntStream intStream, 
										int zuUeberspringen ) {
		List<Double> zahlenListe = new ArrayList<>();
		return zahlenListe;
	}


	/**
	 * Anzahl Elemente mit Stream ermitteln
	 * @return
	 * Anzahl Elemente
	 */
	private long anzahlElemente( String ... strings ) {
		return 1;
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
		 return "Damit Test fehlschlaegt";
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
		return 1;
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
		return 1;
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


	/**
	 * texte zu einem Text �ber Stream
	 * @param texte
	 *  texte, die zusammengef�gt werden sollen
	 * @return
	 * 	String, der die Werte der Liste durch Komma getrennt enth�lt
	 */
	private String zuEinemDurchKommaGetrenntenString( String ... texte ) {		
		return null;
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

	
	private Stream<String> listeVonListeZuEinemStream( List<List<String>> listeVonListe ) {
		return null;
	}


	/**
	 * Die durch Leerzeichen getrennten W�rter werden aus der Datei gelesen
	 * und in eine Map gespeichert.
	 *  
	 * Die Map hat im Key die W�rter der Datei, 
	 * im Value wie oft das Wort in der Datei vorkommt.
	 *  
	 * Die Map wird alphabetisch sortiert zur�ckgegeben.
	 * 
	 * @param dateiname Name der einzulesenden Datei
	 * @return Map mit Namen aus Datei als Key und H�ufigkeit als Value
	 */
	private Map<String, Integer> ausDateiInMap( String dateiname ) {

		Map<String,Integer> wortUndHaeufigkeit = new TreeMap<>();
		
		return wortUndHaeufigkeit;
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
		return null;		
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
		return null;
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
	private Map<Integer, List<String>> personenNachAlterGruppieren(List<Person> personen) {
        return null;
	}


	/**
	 * F�r die als Parameter �bergebene Map sollen Key ( Text ) und Value 
	 * ( wie oft der Text vorkommt ) vertauscht werden.
	 * 
	 * Zum Key mit der H�ufigkeit des Vorkommens ist dann im Value eine Liste
	 * der Strings, die diese H�ufigkeit haben.
	 *  
	 * Die Map soll nach dem Key sortiert sein.
	 * 
	 * @param Map, deren Key und Value vertauscht werden sollen 	
	 * @return Map, die als Key die H�ufigkeit des Strings und als Value 
	 * eine Liste der Strings mit dieser H�ufigkeit enth�lt
	 */
	private Map<Integer, List<String>> keyUndValueVertauschen( Map<String, Integer> textUndHaeufigkeit ) {
		return null;
	}

}

