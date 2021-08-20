package regeln;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestExpectedException {

	// Deprecated Variante:

	/**
	 * Erwartete Exception soll geworfen werden und den erwarteten Text haben. 
	 */
	@Test
	public void testeBruchDeprecated() {
		int[] zahlen = {1,2,3};		
		System.out.println(zahlen[3]);
	}
	
	// Aktuelle Variante:
	@Test
	public void testeBruchSeidJava8() {
	}
	
	
}
