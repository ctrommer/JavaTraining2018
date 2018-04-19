package methodenReferenz;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class StatischeMethode {
	
	public static void main(String[] args) {
		referenzAufStatischeMethodeSyntax();
		listeVonKelvinAlsCelsiusAusgebenMitLambda();
		referenzAufStatischeMethode();		
	}

	/**
	 * Wandelt double in String mit Function und Method Referenz auf statische Methode von String.
	 */
	private static void referenzAufStatischeMethodeSyntax() {
		Function<Double, String> doubleToString = String::valueOf; 		// n -> String.valueOf(n)
		
		String text = doubleToString.apply(273.15);
		
		System.out.println(text);
	}

	/**
	 * Grad Kelvin wird in Celsius umgerechnet und dann formatiert ausgegeben. ( gradCelsius = gradKelvin - 273.15d ).
	 * 
	 * Die statische Methode, die verwendet wird, um die Referenz auf eine statische Methode zu demonstrieren. 
	 * 
	 * @param gradKelvin
	 * 	Grad in Kelvin
	 */
	private static void kelvinAlsCelsiusAusgeben( Double gradKelvin ) {
		Double gradCelsius = gradKelvin - 273.15d;
		System.out.println("Grad Celsius: " + gradCelsius);
	}

	/**
	 * Gibt eine Liste von Kelvin Werten als Celsius aus. Verwendet dazu Consumer und Lambda.
	 * 
	 * Wann macht es Sinn ein Lambad ( oder eine Method Referenz ) zu verwenden, statt die statische Methode direkt zu verwenden?
	 */
	private static void listeVonKelvinAlsCelsiusAusgebenMitLambda() {		
		List<Double> listeGradKelvin = Arrays.asList( 0.0, 273.15, 300.15 );

		// Vorteil: Man kann sie als Parameter für Methoden verwenden, die Funktional Interfaces als Parameter nehmen.
		// Wann verwendet man für das Lambda eine statische Methode?
		// - Wenn die Methode zu lang für das Lambda ist.
		// - Wenn die Methode an mehreren Stellen verwendet wird. 
		// - Wenn es die statische Methode schon gibt.
		Consumer<Double> verbraucher = n -> kelvinAlsCelsiusAusgeben(n);

		listeGradKelvin.forEach(verbraucher);
	}

	/**
	 * Gibt eine Liste von Kelvin Werten als Celsius aus. Verwendet dazu Referenz auf statische Methode.
	 * 
	 * Was ist der Vorteil der Referenz auf eine statische Methode gegenüber dem direkten Aufruf der statischen Methode?
	 */
	private static void referenzAufStatischeMethode() {
		List<Double> listeGradKelvin = Arrays.asList( 1d, 2d, 3d );
		
		// Man kann die statische Methode wie ein Lambda verwenden, also als Paramter für Methoden.
		Consumer<Double> verbraucherNimmtKelvinGibtCelsiusAus = StatischeMethode::kelvinAlsCelsiusAusgeben; // n -> kelvinAlsCelsiusAusgeben(n)

		listeGradKelvin.forEach(verbraucherNimmtKelvinGibtCelsiusAus);
	}

}
