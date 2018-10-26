package regeln;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestExpectedException {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	/**
	 * Erwartete Exception soll geworfen werden und den erwarteten Text haben. 
	 */
	@Test
	public void testeBruch() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("Nenner darf nicht null sein.");
		Bruch bruch = new Bruch(1, 0);
		System.out.println(bruch);
	}
}
