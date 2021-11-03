package meineZukunft;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Analog zu {@link ExecutorLiefertFuture}
 */
public class ThreadMitCompletedFuture {
	
	private ExecutorService dienstDerThreadAusfuehrt = Executors.newCachedThreadPool();

	public Future<Integer> gebeZahlenAusInEigenemThread( Integer anzahlZahlen ) {
		
		// so wäre es in eigenem Task:
		// CompletableFuture<String> beinhaltetZukuenftigesErgebnis = CompletableFuture.supplyAsync(()->"Hallo");
		
		// gibt direkt einen Wert zurück, ohne einen Thread zu starten, somit abweichend vom Methodennamen
		return CompletableFuture.completedFuture(42);
	}
	
	public void erledigeAufgabeUndParallelDazuUnteraufgabeInThread() {
		
		Future<Integer> beinhaltetZukuenftigesErgebnis = gebeZahlenAusInEigenemThread(10);
		
		while ( !beinhaltetZukuenftigesErgebnis.isDone()) {
			System.out.println("Aus main: Ich mach solange was anderes, bis Thread Ergebnis liefert.");
		}
		
		try {			
			Integer ergebnisVonThread = beinhaltetZukuenftigesErgebnis.get();
			System.out.println("aus Main: " + ergebnisVonThread);
			
			dienstDerThreadAusfuehrt.shutdown();			
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}		
	}

	public static void main( String[] args ) {
		// Im Debug Modus ausführen, damit langsam genug.
		ThreadMitCompletedFuture zweiAufgabenParalell = new ThreadMitCompletedFuture();
		zweiAufgabenParalell.erledigeAufgabeUndParallelDazuUnteraufgabeInThread();
	}

}
