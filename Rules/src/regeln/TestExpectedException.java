package regeln;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestExpectedException {


	/**
	 * Erwartete Exception soll geworfen werden und den erwarteten Text haben. 
	 */
	@Test
	public void testeBruch() {
		int[] zahlen = {1,2,3};		
		System.out.println(zahlen[3]);
	}
}
