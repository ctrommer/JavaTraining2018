package streamBeispiel;

import java.util.stream.IntStream;

public class StreamAufgaben {

	public static void main(String[] args) {
		zahlenAusgeben();
		
	}

	/**
	 * Gebe die Zahlen von 1 bis 10 aus. 
	 * Mit Stream von int.
	 */
	private static void zahlenAusgeben() {
		IntStream
			.rangeClosed(1, 10)
			.forEach(System.out::print);		
	}
	
	

}
