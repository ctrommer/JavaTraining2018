package methodenReferenz;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class InstanzmethodeVonBestimmtemObjekt {

	public static void main(String[] args) {
		referenzAufInstanzmethodeEinesBestimmtenObjekts();
		listeAusgebenMitLambda();
		listeAusgebenMitMethodReferenz();
	}	

	/**
	 * Demonstriert die Syntax von Referenz auf Instanzmethode eines bestimmten Objekts 
	 * mit Function und Aneinanderhängen von zwei Strings.
	 */
	private static void referenzAufInstanzmethodeEinesBestimmtenObjekts() {

		// bestimmtes Objekt
		String ersterTeil = "erster Teil";			
		
		// Referenz auf Instanzmethode
		Function<String, String> aneinanderhaengen = ersterTeil::concat;	// s -> ersterTeil.concat(s)
		
		String zusammengesetzt = aneinanderhaengen.apply(" zweiter Teil");
		
		System.out.println(zusammengesetzt);
	}

	/**
	 * Gibt eine Liste von Double aus mit Consumer, Lambda und for each.
	 */
	private static void listeAusgebenMitLambda() {
		List<Double> doubleListe = Arrays.asList( 1d, 2d, 3d );
		
		// Vorteil: Man kann sie als Parameter für Methoden verwenden, die Funktional Interfaces als Parameter nehmen.
		Consumer<Double> ausdrucker = e -> {
			PrintStream out = System.out;
			out.println(e);
		};
		doubleListe.forEach(ausdrucker);
	}

	/**
	 * Demonstriert den Nutzen einer Referenz auf Instanzmethode eines bestimmten Objekts am Beispiel der Ausgabe einer Liste
	 * mit for each.
	 */
	private static void listeAusgebenMitMethodReferenz() {
		List<Double> doubleListe = Arrays.asList( 1d, 2d, 3d );
		
		// Die Method Referenz ruft nur eine Instanz-Methode ( println von System.out ) auf. In diesem Fall ist eine Method Referenz 
		// klarer als das Lambda.
		Consumer<Double> ausdrucker = System.out::println;	// e -> System.out.println(e);
		doubleListe.forEach(ausdrucker);
	}
	
}
