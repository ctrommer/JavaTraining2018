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

	/**
	 * Key und Value einer Map vertauschen ohne Doppeleinträge und Map ausgeben
	 */
	public static void keyUndValueVertauschenOhneDoppelEintraege() {

		Map<String, Integer> textUndHaeufigkeit = new HashMap<>();

		textUndHaeufigkeit.put("einmal", 1);
		textUndHaeufigkeit.put("zweimal", 2);
		textUndHaeufigkeit.put("dreimal", 3);

		Set<Entry<String, Integer>> entrySetTextUndHaeufigkeit = textUndHaeufigkeit.entrySet();

		Map<Integer, String> vertauscht = entrySetTextUndHaeufigkeit
											.stream()
											.collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
		
		System.out.println(vertauscht);
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
		
		Function<? super Entry<String, Integer>, ? extends Integer> wonachGruppiertWird = Map.Entry::getValue;

		Collector<Entry<String, Integer>, ?, List<String>> wieReduziertWird = Collectors.mapping(Map.Entry::getKey, Collectors.toList());

		Set<Entry<String, Integer>> entrySetTextUndHaeufigkeit = textUndHaeufigkeit.entrySet();

		Map<Integer, List<String>> vertauscht = entrySetTextUndHaeufigkeit
													.stream()
													.collect(Collectors.groupingBy(wonachGruppiertWird, wieReduziertWird));

		System.out.println(vertauscht);
	}

}
