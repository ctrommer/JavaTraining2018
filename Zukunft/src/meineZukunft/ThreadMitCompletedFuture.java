package meineZukunft;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Analog zu {@link ExecutorLiefertFuture}
 */
public class ThreadMitCompletedFuture {

	public static void main( String[] args ) {
		
		Future<Integer> completedFuture = CompletableFuture.completedFuture( 42 );
		
		try {
			Integer ergebnis = completedFuture.get();
			System.out.println( ergebnis );
		} catch ( InterruptedException | ExecutionException e ) {
			e.printStackTrace();
		}
	}
}
