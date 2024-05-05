package training;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class FutureTraining {
	
	/**
	 * Quadriert die Zahl ohne eigenen Thread.
	 * @param zahl zu quadrieren
	 * @return Future, dass die quadrierte Zahl enthält
	 */
	private Future<Integer> ohneThreadQuadrieren( int zahl ) {
		return CompletableFuture.completedFuture( zahl * zahl );
	}
	
	/**
	 * Quadriert die Zahl in eigenem Thread.
	 * @param zahl zu quadrieren
	 * @return Future, dass die quadrierte Zahl enthält
	 */	
	private Future<Integer> inEigenemThreadQuadrieren( int zahl ) {
		Supplier<Integer> inThreadAuszufuehren = () -> zahl * zahl;
		CompletableFuture<Integer> beinhaltetZukuenftigesErgebnis = CompletableFuture.supplyAsync( inThreadAuszufuehren );
		return beinhaltetZukuenftigesErgebnis;
	}
	
	/**
	 * Quadriert die Zahl in eigenem Thread. 
	 * Das Ergebnis wird mit 2 multipliziert, aber nicht in einem eigenen Thread.
	 * @param zahl als Eingabe
	 * @return Future, dass das Ergebnis enthält
	 */	
	private Future<Integer> inEigenemThreadQuadrierenDannMit2Multiplizieren( int zahl ) {
		Supplier<Integer> inThreadAuszufuehren = () -> zahl * zahl;

		CompletableFuture<Integer> beinhaltetZukuenftigesErgebnis 
										= CompletableFuture.supplyAsync( inThreadAuszufuehren );
		
		CompletableFuture<Integer> beinhaltetZukuenftigesErgebnisKombiniert 
										= beinhaltetZukuenftigesErgebnis.thenApply( ergebnis -> ergebnis * 2 );
		
		return beinhaltetZukuenftigesErgebnisKombiniert;
	}
	
	
	/**
	 * Quadriert die Zahl in eigenem Thread. 
	 * Das Ergebnis wird in eigenem Thrad mit 2 multipliziert.
	 * @param zahl als Eingabe
	 * @return Future, dass das Ergebnis enthält
	 */		
	private Future<Integer> inEigenemThreadQuadrierenDannMit2InThreadMultiplizieren( int zahl ) {
		CompletableFuture<Integer> beinhaltetZukuenftigesErgebnis 
										= CompletableFuture.supplyAsync( () -> zahl * zahl );

		CompletableFuture<Integer> beinhaltetZukuenftigesErgebnisVerkettet 
										= beinhaltetZukuenftigesErgebnis.thenApplyAsync( ergebnis -> ergebnis * 2 );
		
		return beinhaltetZukuenftigesErgebnisVerkettet; 
	}

	/**
	 * Quadriert die Zahl in eigenem Thread. 
	 * Setze das Ergebnis zusammen mit dem Ergebnis eines zweiten Threads, 
	 * der das Ergebnis des ersten Threads verwendet, um es mit 2 zu multiplizieren.
	 * @param zahl als Eingabe
	 * @return Future, dass das Ergebnis enthält
	 */
	private Future<Integer> inEigenemThreadQuadrierenDannMitMit2InThreadMultiplizieren( int zahl ) {
		CompletableFuture<Integer> beinhaltetZukuenftigesErgebnis 
												= CompletableFuture.supplyAsync( () -> zahl * zahl );
		
		CompletableFuture<Integer> beinhaltetZukuenftigesErgebnisVerkettet 
												= beinhaltetZukuenftigesErgebnis.thenCompose( 
																						ergebnis 
																						-> CompletableFuture.supplyAsync( 
																													() ->  
																													ergebnis * 2 ) );
			
		return beinhaltetZukuenftigesErgebnisVerkettet;
	}
	
	/**
	 * Quadriert die Zahl in eigenem Thread.
	 * Multipliziere die Zahl in einem zweiten Thread mit zwei. 
	 * Kombiniere beiden Futures zu drittem Future, indem der Inhalt der Futures addiert wird.
	 * @param zahl als Eingabe
	 * @return Future, dass das Ergebnis enthält
	 */
	private Future<Integer> ersterThreadQuadriertZweiterThreadMultipliziertMit2Kombiniert( int zahl ) {
		
		CompletableFuture<Integer> beinhaltetErstesZukuenftigesTeilergebnis 
															= CompletableFuture.supplyAsync( () -> zahl * zahl );
		CompletableFuture<Integer> beinhaltetZweitesZukuenftigesTeilergebnis 
															= CompletableFuture.supplyAsync( () -> zahl * 2 );
		

		CompletableFuture<Integer> beinhaltetZukuenftigesErgebnisKombiniert 
															= beinhaltetErstesZukuenftigesTeilergebnis
																						.thenCombine( 
																								beinhaltetZweitesZukuenftigesTeilergebnis,
																								( ergebnisAusErstemThread, ergebnisAusZweitemThread ) 
																								-> ergebnisAusErstemThread + ergebnisAusZweitemThread );
		
		return beinhaltetZukuenftigesErgebnisKombiniert;
	}

	/**
	 * Quadriert die Zahl in eigenem Thread.
	 * Multipliziere die Zahl in einem zweiten Thread mit zwei.
	 * Multipliziere die Zahl in einem dritten Thread mit 10. 
	 * Erzeuge aus den Teilergebnissen einen Stream von CompletableFuture.
	 * Transformiere die Teilergebnisse in einen Stream von Integer.
	 * 
	 * @param zahl als Eingabe
	 * @return Future, dass das Ergebnis enthält
	 */
	private Stream<Integer> dreiTheadsParallelDannGejoint( int zahl ) {
		
		CompletableFuture<Integer> beinhaltetZukuenftigesErgebnis1 = CompletableFuture.supplyAsync( () -> zahl * zahl );
		CompletableFuture<Integer> beinhaltetZukuenftigesErgebnis2 = CompletableFuture.supplyAsync( () -> zahl * 2 );
		CompletableFuture<Integer> beinhaltetZukuenftigesErgebnis3 = CompletableFuture.supplyAsync( () -> zahl * 10 );

		Stream<Integer> zukuenftigeErgebnisse 
			= Stream
				.of(
					beinhaltetZukuenftigesErgebnis1, 
					beinhaltetZukuenftigesErgebnis2, 
					beinhaltetZukuenftigesErgebnis3)
				.map( CompletableFuture::join );
		
		// CompletableFuture<Void> erstFertigWennAlleThreadsFertig = 
				CompletableFuture.allOf(
									beinhaltetZukuenftigesErgebnis1, 
									beinhaltetZukuenftigesErgebnis2, 
									beinhaltetZukuenftigesErgebnis3);
				
		return zukuenftigeErgebnisse;
	}
	
	/**
	 * Quadriert die Zahl in eigenem Thread. Wenn zahl > 46340, dann wirf IllegalArgumentException.
	 * 
	 * @param zahl als Eingabe
	 * @return Future, dass das Ergebnis enthält. 
	 * Wenn keine Exception: Zahl quadriert als String.
	 * Wenn Exception: "Zahl zu gross."
	 */	
	private Future<String> inEigenemThreadQuadrierenAusnameBehandeln( int zahl ) {
		Supplier<String> inThreadAuszufuehren = 
											() 
											-> { if ( zahl > 46340 ) {
													throw new IllegalArgumentException("Zahl zu gross.");
												}
												return String.valueOf( zahl * zahl );
											};
		
		CompletableFuture<String> beinhaltetZukuenftigesErgebnis 
													= CompletableFuture
														.supplyAsync( inThreadAuszufuehren )
														.handle(
																( rueckgabe, ausnahme ) 
																-> rueckgabe == null ? 
																		ausnahme.getCause().getMessage() 
																		: rueckgabe );
		
		return beinhaltetZukuenftigesErgebnis;
	}

	/**
	 * Quadriert die Zahl in eigenem Thread.
	 * Bis der Thread Ergebnis liefert, wird ausgegeben:
	 * 
	 * Aus main: Ich mach solange was anderes, bis Thread Ergebnis liefert."
	 * 
	 * @param zahl zu quadrieren
	 * @return quadrierte Zahl
	 */	
	public Integer erledigeAufgabeUndParallelDazuUnteraufgabeInThread( int zahl ) {
		
		// zeitintensive Aufgabe in eigenem Thread starten
		Supplier<Integer> inThreadAuszufuehren = () -> zahl * zahl;
		CompletableFuture<Integer> beinhaltetZukuenftigesErgebnis 
										= CompletableFuture.supplyAsync( inThreadAuszufuehren );
		
		// solange der Thread noch kein Ergebnis geliefert hat, kann man was anderes machen
		while ( !beinhaltetZukuenftigesErgebnis.isDone() ) {
			System.out.println("Aus main: Ich mach solange was anderes, bis Thread Ergebnis liefert.");
		}
		
		// Ergebnis von Thread abrufen
		try {
			// gibt erst Wert zurück, wenn Thread beendet
			Integer ergebnisVonThread = beinhaltetZukuenftigesErgebnis.get();
			return ergebnisVonThread;			
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}	


}
