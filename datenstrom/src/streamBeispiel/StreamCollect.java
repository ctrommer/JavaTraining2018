package streamBeispiel;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
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
	}

	/**
	 * Stream von String erzeugen
	 * in Liste umwandeln
	 * und Elemente ausgeben
	 */
	private static void streamZuListe() {		
		List<String> namenListe = Stream.of("Karl", "Arnold", "Franz")
			.collect(Collectors.toList());
		
		namenListe.forEach(System.out::println);
	}
	
	/**
	 * Stream von String erzeugen
	 * in einzigen String umwandeln, der alle Namen durch Komma getrennt enthält
	 * und String ausgeben
	 */
	private static void streamZuString() {		
		String alleNamen = Stream.of("Karl", "Arnold", "Franz")
			.collect(Collectors.joining(", "));
		
		System.out.println( alleNamen );
	}	

	/**
	 * Stream von String erzeugen
	 * in Map umwandeln, die den String als Key und die Stringlänge als Value hat.
	 * und map ausgeben
	 */
	private static void streamZuMap() {		
		Map<String, Integer> namenUndLaenge = Stream.of("Karl", "Arnold", "Franz")
			.collect(Collectors.toMap(Function.identity(), String::length));
		
		System.out.println( namenUndLaenge );
	}		
	
	/**
	 * Stream von String erzeugen
	 * in Map umwandeln, die den String als Key und die Stringlänge als Value hat.
	 * Dabei auch doppelte Einträge berücksichtigen.
	 * und map ausgeben
	 */
	private static void streamZuMapMitDoppeleintraegen() {		
		Map<String, Integer> namenUndLaenge = Stream.of("Karl", "Arnold", "Franz", "Franz")
			.collect(Collectors.toMap(Function.identity(), String::length,(name1, name2) -> name1));
		
		System.out.println( namenUndLaenge );
	}			
	
	
}
