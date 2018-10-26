package zweiThreads;


public class AusgabeThreadStarter {

	public static void main(String[] args) {
		// zwei Console-Ausgeber erzeugen
		Runnable ersterAusgabeThreadStarter = new  ConsoleAusgeber("XXX erster Thread XXX", 1000);
		Runnable zweiterAusgabeThreadStarter = new ConsoleAusgeber("OOO zweiter Thread OOO", 2000);
		
		// 2 Threads mit den Console-Ausgeben initialisieren
		Thread ersterThread = new Thread(ersterAusgabeThreadStarter);
		Thread zweiterThread  = new Thread(zweiterAusgabeThreadStarter);
		
		// die beiden Threads starten
		ersterThread.start();
		zweiterThread.start();
	}

}