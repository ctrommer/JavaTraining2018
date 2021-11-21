package meineZukunft;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThreadMitCompletableFutureVerknuepfung {
	
	public static void supplierInThread() {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()-> "Hallo aus supplyAssync");
		try {
			System.out.println(completableFuture.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Es gibt zu den Methoden meist eine "Async" Variante. Die wird im eigenen Thread ausgeführt.
	 */
	public static void supplierInThreadDannApplyAsync() {
		CompletableFuture<String> completableFuture 
			= CompletableFuture.supplyAsync(()-> "Hallo aus supplyAssync")
				.thenApplyAsync(ergebnis -> ergebnis + " Welt aus thenApplyAsync");
		try {
			System.out.println(completableFuture.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	public static void supplierInThreadZweiZusammengesetzt() {
		CompletableFuture<String> completableFuture
			= CompletableFuture.supplyAsync(()-> "Erster Teil aus supplyAssync")
				.thenCompose( ergebnis -> CompletableFuture.supplyAsync(()->  ergebnis + " zweiter Teil aus thenCombine"));
		try {
			System.out.println(completableFuture.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	public static void supplierInThreadZweiKombinieren() {
		CompletableFuture<String> completableFuture 
			= CompletableFuture.supplyAsync(()-> "Erster Teil aus supplyAssync")
				.thenCombine(
						CompletableFuture.supplyAsync(()->  " zweiter Teil aus thenCombine"), 
						( ergebnisAusErstemThread, ergebnisAusZweitemThread ) -> ergebnisAusErstemThread + ergebnisAusZweitemThread );
		try {
			System.out.println(completableFuture.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}	
	
	public static void supplierInThreadMehrereParallel() {
		CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(()-> "Parallel 1 aus supplyAssync");
		CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(()-> "Parallel 2 aus supplyAssync");
		CompletableFuture<String> completableFuture3 = CompletableFuture.supplyAsync(()-> "Parallel 3 aus supplyAssync");
		
		CompletableFuture<Void> alleZusammenFuture = CompletableFuture.allOf(completableFuture1, completableFuture2, completableFuture3);
		Stream<String> stream = Stream.of(completableFuture1, completableFuture2, completableFuture3)
			.map(CompletableFuture::join);
		String alleErgebnisseGejoint = stream.collect(Collectors.joining(" "));
		System.out.println(alleErgebnisseGejoint);
		
		try {
			System.out.println(alleZusammenFuture.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}	
	
	public static void supplierInThreadMitException() {
		String name = null;
		
		CompletableFuture<String> completableFuture = 
				CompletableFuture.supplyAsync(()-> {
					if ( name == null ) {
						throw new RuntimeException("Message von Exception");
					}
					return "Hallo aus Assync mit Exception";
				} ).handle(( rueckgabe, ausnahme ) -> rueckgabe == null ? ausnahme.getMessage() : rueckgabe);
		
		try {
			System.out.println(completableFuture.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	public static void runnableInThread() {
		CompletableFuture<Void> future = CompletableFuture.runAsync( () -> System.out.println("aus Runnable"));
		try {
			System.out.println("Ergebnis von Runnable.get: " + future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main ( String[] args ) {		
		supplierInThread();
		supplierInThreadDannApplyAsync();
		supplierInThreadZweiKombinieren();
		supplierInThreadMehrereParallel();
		supplierInThreadMitException();
		runnableInThread();		
	}

}
