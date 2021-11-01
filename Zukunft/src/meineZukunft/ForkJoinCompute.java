package meineZukunft;

import java.util.concurrent.RecursiveTask;

/**
 *
 */
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
		
		 ForkJoinCompute f1 = new ForkJoinCompute(zahl * zahl);
		 f1.fork();
		 
		 ForkJoinCompute f2 = new ForkJoinCompute(zahl * 10 );
		 
		 return f2.compute() + f1.join();
	     
	}
	   
	public static void main(String[] args) {
		ForkJoinCompute forkJoinCompute = new ForkJoinCompute(2);
		Integer ergebnis = forkJoinCompute.compute();
		System.out.println("aus main: " + ergebnis);
	}	   
   
 }

