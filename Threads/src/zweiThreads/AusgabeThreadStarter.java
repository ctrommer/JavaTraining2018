package zweiThreads;


public class AusgabeThreadStarter {

	public static void main(String[] args) {
		ohneLambda();
		mitLambda();
	}
	
	public static void ohneLambda() {
		// zwei Console-Ausgeber erzeugen
		
		// 2 Threads mit den Console-Ausgeben initialisieren
		
		// die beiden Threads starten
	}
	
	public static void mitLambda() {
		// Lambda, dass Hallo ausgibt für Thread erzeugen
		
		// Thread mit dem Lambda initialisieren
		
		// Threads starten
	}
	
	public static void gebeHalloInEigenemThreadAus() {
		System.out.println("Hallo");
	}

}