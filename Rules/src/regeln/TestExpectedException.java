package regeln;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestExpectedException {

	// Deprecated Variante:
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	/**
	 * Erwartete Exception soll geworfen werden und den erwarteten Text haben. 
	 */
	@Test
	public void testeBruchDeprecated() {
		expectedException.expect(ArrayIndexOutOfBoundsException.class);
		expectedException.expectMessage("3");
		int[] zahlen = {1,2,3};		
		System.out.println(zahlen[3]);
	}
	
	// Aktuelle Variante:
	@Test
	public void testeBruchSeidJava8() {
		ArrayIndexOutOfBoundsException geworfeneAusnahme = assertThrows(ArrayIndexOutOfBoundsException.class, ()-> {
			int[] zahlen = {1,2,3};		
			System.out.println(zahlen[3]);			
		});
		assertTrue(geworfeneAusnahme.getMessage().contains("3"));
	}
	
	
}
