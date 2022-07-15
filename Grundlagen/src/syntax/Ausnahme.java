package syntax;


import javax.management.BadStringOperationException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Ausnahme {
	
	private boolean methodeWurdeAufgerufen;

	/**
	 * @throws BadStringOperationException
	 */
	private void handeledExceptionDemo() throws BadStringOperationException {
		throw new BadStringOperationException("Falsche String Operation!");
	}

	@Test
	@DisplayName("Exception BadStringOperationException soll geworfen werden.")
	public void test01() {
		Assertions.assertThrowsExactly( BadStringOperationException.class, () -> handeledExceptionDemo() );
	}

	/**
	 * Zeigt handeled Exception, mit Teil, der immer aufgerufen wird.
	 * Setzt 
	 * methodeWurdeAufgerufen = true;
	 */
	public void ruftHandeledExceptionAuf() {
		try {
			handeledExceptionDemo();
		} catch (BadStringOperationException | NullPointerException exception) {
		} finally {
			methodeWurdeAufgerufen = true;
		}
	}
	
	@Test
	@DisplayName("Die handeled exception soll richtig aufgerufen werden und die exception soll gefangen werden.")
	public void test02() {
		ruftHandeledExceptionAuf();
		Assertions.assertTrue(methodeWurdeAufgerufen);				
	}

	@Test
	@DisplayName("Teil, der bei Exception immer ausgefuehrt wird, soll aufgerufen werden.")
	public void test03() {
		ruftHandeledExceptionAuf();
		Assertions.assertTrue(methodeWurdeAufgerufen);				
	}	
	
	/**
	 * Wirft eine unbehandelte Ausnahme.
	 */
	private void unhandeledException() {
		throw new NullPointerException();
	}
	
	@Test
	@DisplayName("Unbehandelte Ausnahme soll geworfen werden.") 
	public void test04() {
		Assertions.assertThrows(RuntimeException.class, ()->unhandeledException());
	}

}
