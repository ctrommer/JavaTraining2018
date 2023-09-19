package syntax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Fuer die Anwendung aktivieren mit
 * 
 * ?
 *    
 */
public class AssertTrainer {
	
	/**
	 * Zeige, dass assert Exception wirft
	 * 
	 * @param bedingung 
	 * wenn false, dann Exception
	 */
	public void ersteFormDesAssert( Boolean bedingung ) {
	}

	/**
	 * Zeige, dass assert Exception mit Text wirft
	 * 
	 * @param bedingung 
	 * wenn false, dann Exception
	 * @param fehlerText
	 * Text, der bei Exception angezeigt werden soll
	 */
	public void zweiteFormDesAssert( Boolean bedingung, String fehlerText ) {
	}

	@DisplayName("Wirft assert exception, wenn Bedingung nicht erfuellt?")
	@Test
	public void test01() {
		Assertions.assertThrows(AssertionError.class, ()->ersteFormDesAssert(false));
	}
	
	@DisplayName("Wirft assert keine exception, wenn Bedingung erfuellt?")
	@Test
	public void test02() {
		ersteFormDesAssert(true);
	}

	@DisplayName("Wirft das assert mit Fehlertext exception und gibt Text aus, wenn Bedingung nicht erfuellt?")
	@Test
	public void test03() {
		String fehlertext 
				= Assertions.assertThrows(
								AssertionError.class, 
								()->zweiteFormDesAssert(false,"Fehlertext"))
							.getLocalizedMessage();
		
		Assertions.assertEquals("Fehlertext", fehlertext);
	}
	
	@DisplayName("Wirft das assert mit Fehlertext keine exception, wenn Bedingung erfuellt?")
	@Test
	public void test04() {
		zweiteFormDesAssert(true, "Fehlertext");
	}	
	
}
