package regeln;

import org.junit.Test;

public class TestTimeout {
	
	private static final int SEKUNDEN_BIS_TIMEOUT = 1;
	
	/**
	 * Regel, die nach einer Sekunde zum Timeout führt.
	 */
	
	/**
	 * Provoziert Timeout.
	 */
	@Test
	public void testeTimeout() {
		for ( int index1 = 1; index1 <= 30000; index1++ ) {
			for ( int index2 = 1; index2 <= 30000; index2++ ) {			
				System.out.println( index1 + " " + index2 );
			}
		}			
	}
}
