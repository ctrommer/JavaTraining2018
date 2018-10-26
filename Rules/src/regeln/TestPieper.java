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
		Bruch bruch = new Bruch(0, 0);		
		System.out.println(bruch);
	}
}