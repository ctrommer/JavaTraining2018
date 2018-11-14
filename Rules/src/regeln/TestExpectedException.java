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
		expectedException.expect(ArrayIndexOutOfBoundsException.class);
		expectedException.expectMessage("3");
		int[] zahlen = {1,2,3};		
		System.out.println(zahlen[3]);
	}
}
