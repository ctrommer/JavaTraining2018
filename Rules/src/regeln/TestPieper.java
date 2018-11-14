package regeln;

import org.junit.Rule;
import org.junit.Test;

public class TestPieper {
	
	@Rule
	public MeinePieperRule meinePieperRule = new MeinePieperRule();
	
	/**
	 * Testet die eigene Exception, die piept.
	 */
	@Test
	public void testePiepen() {
		int[] zahlen = {1,2,3};		
		System.out.println(zahlen[3]);
	}
}