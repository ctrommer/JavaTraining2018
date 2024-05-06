package meineZukunft;

import java.util.concurrent.RecursiveTask;

public class ForkJoin extends RecursiveTask<Integer> {

	private static final long serialVersionUID = 1L;

	private final int zahl;

	public ForkJoin(int zahl) {
		this.zahl = zahl;
	}

	/**
	 * Gibt die Zahlen von 1 bis 3 Rekursiv aus.
	 */
	@Override
	protected Integer compute() {
		
		System.out.println( "aus Thread mit Zahl: " + zahl );
		
		if ( zahl >= 3 ) {
			return zahl;
		}

		// erzeuge neuen Task
		ForkJoin forkJoinRekursiv = new ForkJoin( zahl + 1 );
		// starte neuen Task
		forkJoinRekursiv.fork();
		
		// gebe Ergebnis von Task zurück, sobald "Berechnung" beendet.
		return forkJoinRekursiv.join();
   }

	public static void main(String[] args) {
		ForkJoin forkJoin = new ForkJoin( 1 );
		Integer ergebnis = forkJoin.compute();
		System.out.println("aus main: " + ergebnis);
	}	
}
