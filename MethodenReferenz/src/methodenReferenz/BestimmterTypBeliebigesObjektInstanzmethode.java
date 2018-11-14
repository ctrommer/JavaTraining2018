package methodenReferenz;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class BestimmterTypBeliebigesObjektInstanzmethode {
	
	public static void main(String[] args) {
		mitAbstrakterMethode();		
		mitLambda();		
		referenzAufInstanzmethodeEinesBeliebigenObjektsEinesBestimmtenTyps();
		nutzenVonReferenzAufInstanzmethodeEinesBeliebigenObjektsEinesBestimmtenTyps();		
	}

	/**
	 * Verwandelt Kleinbuchstaben in Großbuchstaben mit Function ohne Lambda.
	 */
	private static void mitAbstrakterMethode() {
		Function<String, String> zuGrossbuchstaben = new Function<String, String>() {
			@Override
			public String apply(String m) {
				return m.toUpperCase();
			}
		};
		
		String inGrossbuchstaben = zuGrossbuchstaben.apply("kleinbuchstaben");
		
		System.out.println(inGrossbuchstaben);
	}	
	
	/**
	 * Verwandelt Kleinbuchstaben in Großbuchstaben mit Function mit Lambda.
	 */	
	private static void mitLambda() {
		Function<String, String> zuGrossbuchstaben = m -> m.toUpperCase();
		
		String inGrossbuchstaben = zuGrossbuchstaben.apply("kleinbuchstaben");
		
		System.out.println(inGrossbuchstaben);
	}	

	/**
	 * Verwandelt Kleinbuchstaben in Großbuchstaben mit Function mit Method Referenz.
	 * 
	 * Nur zum Demonstrieren der Syntax, es ginge natürlich einfacher ohne Method Referenz. 
	 */
	private static void referenzAufInstanzmethodeEinesBeliebigenObjektsEinesBestimmtenTyps() {
		Function<String, String> zuGrossbuchstaben = String::toUpperCase;
		
		String inGrossbuchstaben = zuGrossbuchstaben.apply("kleinbuchstaben");
		
		System.out.println(inGrossbuchstaben);
		// ginge natürlich auch so:
		// System.out.println(new String ( "kleinbuchstaben" ).toUpperCase());
	}	

	/**
	 * Erzeuge Liste von Mitarbeitern und gebe ihre Namen aus.
	 * 
	 * Der Nutzen wird erst klar, wenn man die Method Referenz braucht, um sie einer Methode als Parameter zu übergeben. 
	 */
	private static void nutzenVonReferenzAufInstanzmethodeEinesBeliebigenObjektsEinesBestimmtenTyps() {
		
		List<Mitarbeiter> mitarbeiterListe = Arrays.asList(new Mitarbeiter("Albert"), new Mitarbeiter("Bert" ), new Mitarbeiter( "Karl-Dietrich") );
		
		Consumer<Mitarbeiter> nameAusgeber = Mitarbeiter::gebeNameAus; // t -> t.gebeNameAus()
		
		mitarbeiterListe.forEach(nameAusgeber);		
	}

}
