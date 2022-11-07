package chainOfResponsibility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Function;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SchreienTrainer {

	/**
	 * Zeigt chain of Responsibility, indem ein Text zuerst in Grossbuchstaben verwandelt wird 
	 * und dann ein Ausrufezeichen angefuegt wird.
	 * 
	 * z.B.:
	 * Hallo -> HALLO!
	 * 
	 * @param args
	 */
	public String verwandleInSchreien( String gesprochen ) {

		return null;
	}

	@DisplayName("Hallo soll in HALLO! umgewandelt werden.")
	@Test
	public void test01() {
		assertEquals( "HALLO!", verwandleInSchreien("Hallo") );		
	}

}
