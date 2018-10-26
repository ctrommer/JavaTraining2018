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
		
		Bruch bruch = new Bruch(1, 0);
		System.out.println(bruch);
	}
}
