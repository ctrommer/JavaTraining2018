package meineZukunft;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Analog zu {@link ExecutorLiefertFuture}
 *
 */
public class ThreadMitCompletableFuture {

	private ExecutorService dienstDerThreadAusfuehrt = Executors.newCachedThreadPool();

	public CompletableFuture<Integer> gebeZahlenAusInEigenemThread( Integer anzahlZahlen ) {

		CompletableFuture<Integer> beinhaltetZukuenftigesErgebnis = new CompletableFuture<>();

		Callable<Integer> inThreadAuszufuehren = () -> {
			for ( int zahl = 1; zahl <= anzahlZahlen; zahl++ ) {
				System.out.println( "Aus Thread: " + zahl );
			}
			beinhaltetZukuenftigesErgebnis.complete( 42 ); 
			return null;	// wird nicht gebraucht.
		};
		dienstDerThreadAusfuehrt.submit( inThreadAuszufuehren );

		return beinhaltetZukuenftigesErgebnis;
	}
	
	public void erledigeAufgabeUndParallelDazuUnteraufgabeInThread() {
		
		CompletableFuture<Integer> beinhaltetZukuenftigesErgebnis = gebeZahlenAusInEigenemThread( 10 );
		
		while ( !beinhaltetZukuenftigesErgebnis.isDone() ) {
			System.out.println("Aus main: Ich mach solange was anderes, bis Thread Ergebnis liefert.");
		}
		
		try {			
			Integer ergebnisVonThread = beinhaltetZukuenftigesErgebnis.get();
			System.out.println( "aus Main: " + ergebnisVonThread );
			
			// Beispiel für eine der vielen coolen Zusatzfunktion des CompletableFuture
			CompletableFuture<Integer> beinhaltetZukuenftigesErgebnisNachbearbeitet 
											= beinhaltetZukuenftigesErgebnis.thenApply( zahl->zahl*10 );
			System.out.println( "aus Main: " + beinhaltetZukuenftigesErgebnisNachbearbeitet.get() );
			dienstDerThreadAusfuehrt.shutdown();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

	}

	public static void main( String[] args ) {
		// Im Debug Modus ausführen, damit langsam genug.
		ThreadMitCompletableFuture zweiAufgabenParalell = new ThreadMitCompletableFuture();
		zweiAufgabenParalell.erledigeAufgabeUndParallelDazuUnteraufgabeInThread();
	}

}