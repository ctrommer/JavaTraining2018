package methodenReferenz;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class InstanzmethodeVonBestimmtemObjekt {

	public static void main(String[] args) {
		aneinanderhaengenMitFunctionOhneLambda();
		aneinanderhaengenMitFunctionUndLambda();
		referenzAufInstanzmethodeEinesBestimmtenObjekts();
		listeAusgebenMitLambda();
		listeAusgebenMitMethodReferenz();
	}	
	
	/**
	 * Hängt zwei Strings aneinander mit Function ohne Lambda.
	 */
	private static void aneinanderhaengenMitFunctionOhneLambda() {

		// bestimmtes Objekt
		String ersterTeil = "erster Teil";			
		
	}
	
	/**
	 * Hängt zwei Strings aneinander mit Function und Lambda.
	 */
	private static void aneinanderhaengenMitFunctionUndLambda() {

		// bestimmtes Objekt
		String ersterTeil = "erster Teil";			
		
	}

	/**
	 * Demonstriert die Syntax von Referenz auf Instanzmethode eines bestimmten Objekts 
	 * mit Function und Aneinanderhängen von zwei Strings.
	 */
	private static void referenzAufInstanzmethodeEinesBestimmtenObjekts() {

		// bestimmtes Objekt
		String ersterTeil = "erster Teil";			
		
	}

	/**
	 * Gibt eine Liste von Double aus mit Consumer, Lambda und for each.
	 */
	private static void listeAusgebenMitLambda() {
		List<Double> doubleListe = Arrays.asList( 1d, 2d, 3d );
		
	}

	/**
	 * Demonstriert den Nutzen einer Referenz auf Instanzmethode eines bestimmten Objekts am Beispiel der Ausgabe einer Liste
	 * mit for each.
	 */
	private static void listeAusgebenMitMethodReferenz() {
		List<Double> doubleListe = Arrays.asList( 1d, 2d, 3d );
		
	}
	
}
