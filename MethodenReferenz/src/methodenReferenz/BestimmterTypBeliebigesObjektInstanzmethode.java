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
	 * Verwandelt Kleinbuchstaben in Gro�buchstaben mit Function ohne Lambda.
	 */
	private static void mitAbstrakterMethode() {

	}	
	
	/**
	 * Verwandelt Kleinbuchstaben in Gro�buchstaben mit Function mit Lambda.
	 */	
	private static void mitLambda() {

	}	

	/**
	 * Verwandelt Kleinbuchstaben in Gro�buchstaben mit Function mit Method Referenz.
	 * 
	 * Nur zum Demonstrieren der Syntax, es ginge nat�rlich einfacher ohne Method Referenz. 
	 */
	private static void referenzAufInstanzmethodeEinesBeliebigenObjektsEinesBestimmtenTyps() {

		// ginge nat�rlich auch so:
		// System.out.println(new String ( "kleinbuchstaben" ).toUpperCase());
	}	

	/**
	 * Erzeuge Liste von Mitarbeitern und gebe ihre Namen aus.
	 * 
	 * Der Nutzen wird erst klar, wenn man die Method Referenz braucht, um sie einer Methode als Parameter zu �bergeben. 
	 */
	private static void nutzenVonReferenzAufInstanzmethodeEinesBeliebigenObjektsEinesBestimmtenTyps() {
		
		List<Mitarbeiter> mitarbeiterListe = Arrays.asList(new Mitarbeiter("Albert"), new Mitarbeiter("Bert" ), new Mitarbeiter( "Karl-Dietrich") );
	}

}
