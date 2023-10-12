package meineZukunft;

import java.util.concurrent.RecursiveTask;

public class ForkJoinCompute extends RecursiveTask<Integer>{
	
	private static final long serialVersionUID = 1L;
	
	private final String threadName;
	private final int zahl;
	
	public ForkJoinCompute(String threadName, int zahl) {
		this.threadName = threadName;
		this.zahl = zahl;
	}

	protected Integer compute() {
		
		System.out.println("aus Thread " + threadName + ": " + zahl);
		
		if ( zahl > 100 ) {
			System.out.println("aus Thread " + threadName + ": Ende, weil " + zahl + " groesser 100");
			System.out.println("");
			return zahl;
		}
		
		// erzeuge ersten neuen Task mit zahl * zahl
		ForkJoinCompute task1 = new ForkJoinCompute("thread quadrieren", zahl * zahl);
		// starte neuen Task
		task1.fork();

		// erzeuge zweiten neuen Task mit zahl * 10
		ForkJoinCompute task2 = new ForkJoinCompute("thread mit 10 multiplizieren", zahl * 10 );
		 
		// gebe Ergebnis von ersten Task plus zweiten Task zurück, sobald "Berechnungen" beendet.
		return task2.compute() + task1.join();
	     
	}
	   
	public static void main(String[] args) {
		ForkJoinCompute forkJoinCompute = new ForkJoinCompute("Startthread", 2);
		Integer ergebnis = forkJoinCompute.compute();
		System.out.println("aus main: " + ergebnis);
	}	   
   
 }

