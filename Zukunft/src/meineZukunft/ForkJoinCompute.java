package meineZukunft;

import java.util.concurrent.RecursiveTask;

public class ForkJoinCompute extends RecursiveTask<Integer>{
	
	private static final long serialVersionUID = 1L;
	
	private final int zahl;
	
	public ForkJoinCompute(int zahl) {
		this.zahl = zahl;
	}

	protected Integer compute() {
		
		System.out.println(zahl);
		
		if ( zahl > 100 ) {
			System.out.println("Ende, weil " + zahl + " groesser 100");
			return zahl;
		}
		
		// erzeuge ersten neuen Task mit zahl * zahl
		ForkJoinCompute task1 = new ForkJoinCompute(zahl * zahl);
		// starte neuen Task
		task1.fork();

		// erzeuge zweiten neuen Task mit zahl * 10
		ForkJoinCompute task2 = new ForkJoinCompute(zahl * 10 );
		 
		// gebe Ergebnis von ersten Task plus zweiten Task zurück, sobald "Berechnungen" beendet.
		return task2.compute() + task1.join();
	     
	}
	   
	public static void main(String[] args) {
		ForkJoinCompute forkJoinCompute = new ForkJoinCompute(2);
		Integer ergebnis = forkJoinCompute.compute();
		System.out.println("aus main: " + ergebnis);
	}	   
   
 }

