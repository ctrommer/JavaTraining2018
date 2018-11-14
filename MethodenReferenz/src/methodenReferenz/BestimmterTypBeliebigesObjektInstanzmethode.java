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

	}	
	
	/**
	 * Verwandelt Kleinbuchstaben in Großbuchstaben mit Function mit Lambda.
	 */	
	private static void mitLambda() {

	}	

	/**
	 * Verwandelt Kleinbuchstaben in Großbuchstaben mit Function mit Method Referenz.
	 * 
	 * Nur zum Demonstrieren der Syntax, es ginge natürlich einfacher ohne Method Referenz. 
	 */
	private static void referenzAufInstanzmethodeEinesBeliebigenObjektsEinesBestimmtenTyps() {

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
	}

}
