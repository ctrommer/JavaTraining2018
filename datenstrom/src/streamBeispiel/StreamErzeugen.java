package streamBeispiel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Quelle:
 * https://www.youtube.com/watch?v=t1-YZ6bF-g0
 *
 */
public class StreamErzeugen {

	public static void main(String[] args) {
		intStreamAusgeben();
		System.out.println();
				
		direktErzeugen();
		System.out.println();
		
		primitivesStringArrayZuStream();
		System.out.println();

		listeZuStreamAusgeben();
		System.out.println();
		
		dateiZuStream();
		System.out.println();
	}

	/**
	 * Erzeuge IntStream mit Zahlen von 1 bis 10.
	 * Gebe die Zahlen aus. 
	 */
	private static void intStreamAusgeben() {
		IntStream
			.rangeClosed(1, 10)
			.forEach(System.out::println);		
	}

	/**
	 * Stream von String direkt erzeugen
	 * und Elemente ausgeben
	 */
	private static void direktErzeugen() {		
		Stream.of("Karl", "Arnold", "Franz")
			.forEach(System.out::println);
	}

	/**
	 * primitives Array von Strings erzeugen
	 * daraus stream
	 * und ausgeben
	 */
	private static void primitivesStringArrayZuStream() {
		String[] namen =  {"Karl", "Arnold", "Franz", "Albert" };
		Stream.of(namen)
			.forEach(System.out::println);		
	}

	/**
	 * Liste von Strings erzeugen
	 * in Stream umwandeln
	 * alle ausgeben
	 */
	private static void listeZuStreamAusgeben() {
		List<String> namen = Arrays.asList("Karl", "Arnold", "Franz", "Albert" );
		namen.stream()
			.forEach(System.out::println);			
	}

	/**
	 * Stream aus Datei
	 * alle ausgeben
	 */
	private static void dateiZuStream(){
		try (Stream<String> namen = Files.lines(Paths.get("namen.txt"))) {
			namen.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
