package syntax;


import javax.management.BadStringOperationException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Zeigt checked exceptions ( besserer Name waere gewesen: check-mandated ... muss man checken )
 * und unchecked exceptions ( besserer Name waere gewesen: check-not-mandated ... darf man checken ).
 * 
 * Ob checked exceptions in der Praxis mehr Schaden anrichten als sie nutzen, ist strittig.
 * In C# gibt es sie z.B. nicht. 
 * ( https://stackoverflow.com/questions/6115896/understanding-checked-vs-unchecked-exceptions-in-java )
 *
 */
public class AusnahmeTrainer {
	
	private boolean methodeWurdeAufgerufen;

	/**
	 * Wirft eine Ausnahme, die nicht behandelt werden muss ( aber kann ).
	 */
	private void wirfUncheckedException() {
	}

	/**
	 * Die Methode soll eine BadStringOperationException werfen, 
	 * die gecheckt werden muss.
	 * 
	 * @throws BadStringOperationException
	 */
	private void wirfCheckedException() {		
	}

	/**
	 * Ruft eine Methode, die eine checked Exception wirft auf und zeigt, wie man 
	 * die checked exception behandeln muss. 
	 * 
	 * Im Teil, der immer aufgerufen wird setzen:
	 * methodeWurdeAufgerufen = true;
	 */
	public void ruftCheckedExceptionAuf() {
	}

	@Test
	@DisplayName("Unchecked Ausnahme soll geworfen werden.") 
	public void test01() {
		Assertions.assertThrows(
				RuntimeException.class, 
				() -> wirfUncheckedException() );
	}
	
	@Test
	@DisplayName("Exception BadStringOperationException soll geworfen werden.")
	public void test02() {
		Assertions.assertThrowsExactly( 
				BadStringOperationException.class, 
				() -> wirfCheckedException() );
	}
	
	@Test
	@DisplayName("Teil, der bei Exception immer ausgefuehrt wird, soll aufgerufen werden.")
	public void test03() {
		ruftCheckedExceptionAuf();
		Assertions.assertTrue( methodeWurdeAufgerufen );				
	}	

}