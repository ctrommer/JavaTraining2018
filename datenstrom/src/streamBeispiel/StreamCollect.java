package streamBeispiel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Quelle: http://www.baeldung.com/java-8-collectors

public class StreamCollect {

	public static void main(String[] args) {
		streamZuListe();
		System.out.println();
		
		streamZuString();
		System.out.println();
		
		streamZuMap();
		System.out.println();
		
		streamZuMapMitDoppeleintraegen();
		System.out.println();
		
		keyUndValueVertauschenOhneDoppelEintraege();
		System.out.println();
		
		keyUndValueVertauschenMitDoppelEintraegen();
		System.out.println();
	}

	/**
	 * Stream von String erzeugen
	 * in Liste umwandeln
	 * und Elemente ausgeben
	 */
	private static void streamZuListe() {		
		
//		namenListe.forEach(System.out::println);
	}
	
	/**
	 * Stream von String erzeugen
	 * in einzigen String umwandeln, der alle Namen durch Komma getrennt enthält
	 * und String ausgeben
	 */
	private static void streamZuString() {		
	}	

	/**
	 * Stream von String erzeugen
	 * in Map umwandeln, die den String als Key und die Stringlänge als Value hat.
	 * und map ausgeben
	 */
	private static void streamZuMap() {		
	}		
	
	/**
	 * Stream von String erzeugen
	 * in Map umwandeln, die den String als Key und die Stringlänge als Value hat.
	 * Dabei auch doppelte Einträge berücksichtigen.
	 * und map ausgeben
	 */
	private static void streamZuMapMitDoppeleintraegen() {		
	}			

	/**
	 * Key und Value einer Map vertauschen ohne Doppeleinträge und Map ausgeben
	 */
	public static void keyUndValueVertauschenOhneDoppelEintraege() {

		Map<String, Integer> textUndHaeufigkeit = new HashMap<>();

		textUndHaeufigkeit.put("einmal", 1);
		textUndHaeufigkeit.put("zweimal", 2);
		textUndHaeufigkeit.put("dreimal", 3);

	}

	/**
	 * Key und Value einer Map vertrauschen mit Doppeleinträgen und Map ausgeben
	 */
	public static void keyUndValueVertauschenMitDoppelEintraegen() {
		
		Map<String, Integer> textUndHaeufigkeit = new HashMap<>();
		
		textUndHaeufigkeit.put("einmal", 1);
		textUndHaeufigkeit.put("zweimal", 2);
		textUndHaeufigkeit.put("dreimal", 3);
		textUndHaeufigkeit.put("auchDreimal", 3);
		
	}

}
