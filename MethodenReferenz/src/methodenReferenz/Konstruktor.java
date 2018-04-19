package methodenReferenz;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Konstruktor {
	
	public static void main(String[] args) {
		lambdaMitKonstruktorGepaart();
		referenzAufKonstrutor();
		referenzAufKonstruktorAlsParameter();
	}		

	/**
	 * Erzeugt einen Mitarbeiter aus einem String mit einem Lambda und Function.
	 */
	private static void lambdaMitKonstruktorGepaart() {
		Function<String, Mitarbeiter> stringZuPerson = s -> new Mitarbeiter(s); 
		
		Mitarbeiter erzeugt = stringZuPerson.apply("Karl");
		
		System.out.println(erzeugt);				
	}

	/**
	 * Erzeuge einen Mitarbeiter aus einem String mit einer Method Referenz.
	 * 
	 * Wann macht das erst Sinn?
	 * 
	 */
	private static void referenzAufKonstrutor() {
		// Erst sinnvoll, wenn es als Parameter übergeben wird.
		Function<String, Mitarbeiter> stringZuPerson = Mitarbeiter::new;		// s -> new Mitarbeiter(s);
		
		Mitarbeiter neuerMitarbeiter = stringZuPerson.apply("Karl");
		
		System.out.println(neuerMitarbeiter);
	}
	
	/**
	 * Verwende Konstruktor Referenz um eine Map zu füllen, die den Mitarbeiternamen als Key und
	 * den Mitarbeiter als Value hat.
	 * 
	 * Was ist der Nutzen der Konstruktor Referenz?
	 */
	private static void referenzAufKonstruktorAlsParameter() {
		Map<String, Mitarbeiter> mitarbeiterMap = new HashMap<>();
		
		Function<String, Mitarbeiter> stringZuMitarbeiter = Mitarbeiter::new;	// s -> new Mitarbeiter(s);

		// Nutzen Konstruktorreferenz: man kann sie einer Methode als Parameter mitgeben. 
		mitarbeiterMap.computeIfAbsent("Karl", stringZuMitarbeiter);
		
		System.out.println(mitarbeiterMap);
	}
}
