package meineZukunft;

import java.util.concurrent.RecursiveTask;

public class ForkJoin extends RecursiveTask<Integer> {

	private static final long serialVersionUID = 1L;

	private final int zahl;

	public ForkJoin(int zahl) {
		this.zahl = zahl;
	}

	@Override
	protected Integer compute() {
		
		if ( zahl >= 3 ) {
			System.out.println("aus Thread mit Zahl: " + zahl);
			return zahl;
		}
		
		System.out.println(zahl);

		ForkJoin forkJoinRekursiv = new ForkJoin(zahl+1);
		forkJoinRekursiv.fork();
		
		return forkJoinRekursiv.join();
   }

	public static void main(String[] args) {
		ForkJoin forkJoin = new ForkJoin(1);
		Integer ergebnis = forkJoin.compute();
		System.out.println("aus main: " + ergebnis);
	}

}
