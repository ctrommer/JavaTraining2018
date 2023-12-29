package meineZukunft;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorLiefertFuture {
	
	/**
	 * Hier wird nur ein Thread verwendet. Wenn man mehrere Threads verwenden möchte,
	 * verwendet man = Executors.newFixedThreadPool(2); 
	 */
	private ExecutorService dienstDerThreadAusfuehrt = Executors.newSingleThreadExecutor();

	/**
	 * Mit Hilfe eines ExecutorService wird ein einziger Thread gestartet, der Zahlen ausgibt.
	 * Lohnt sich in der realen Welt nur für Rechenoperationen, die lange dauern und auf deren
	 * Ergebnis man nicht untaetig warten moechte.
	 *  
	 * @param anzahlZahlen wieviele Zahlen ausgegeben werden
	 * @return Ein Future, in das der Thread das Ergebnis schreibt, sobald er es ermittelt hat.
	 */
	public Future<Integer> gebeZahlenAusInEigenemThread( Integer anzahlZahlen ) {
		
		Callable<Integer> inThreadAuszufuehren = () -> {
			for ( int zahl = 1; zahl <= anzahlZahlen; zahl++ ) {
				System.out.println("Aus Thread: " + zahl);
			}			
			return 42;	// Ergebnis, das man vom Feature aus abrufen kann.
		};
		
		Future<Integer> beinhaltetZukuenftigesErgebnis = dienstDerThreadAusfuehrt.submit( inThreadAuszufuehren );
		
		return beinhaltetZukuenftigesErgebnis;		
	}

	/**
	 * Erledigt Aufgabe und parallel dazu Unteraufgabe in eigenem Thread.
	 */
	public void erledigeAufgabeUndParallelDazuUnteraufgabeInThread() {
		
		// zeitintensive Aufgabe in eigenem Thread starten
		Future<Integer> zukuenftigesErgebnisVonThread = gebeZahlenAusInEigenemThread( 10 );
		
		// solange der Thread noch kein Ergebnis geliefert hat, kann man was anderes machen
		while ( !zukuenftigesErgebnisVonThread.isDone() ) {
			System.out.println("Aus main: Ich mach solange was anderes, bis Thread Ergebnis liefert.");
		}
		
		// Ergebnis von Thread abrufen
		try {
			// gibt erst Wert zurück, wenn Thread beendet
			Integer ergebnisVonThread = zukuenftigesErgebnisVonThread.get();
			System.out.println( ergebnisVonThread );
			dienstDerThreadAusfuehrt.shutdown();
		} catch ( InterruptedException | ExecutionException e ) {
			e.printStackTrace();
		}		
	}
	
	public static void main( String[] args ) {
		// Im Debug Modus ausführen, damit langsam genug.
		ExecutorLiefertFuture zweiAufgabenParallel = new ExecutorLiefertFuture();
		zweiAufgabenParallel.erledigeAufgabeUndParallelDazuUnteraufgabeInThread();
	}

}