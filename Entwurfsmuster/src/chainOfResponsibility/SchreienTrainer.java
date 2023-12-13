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

		Function<String, String> zuGrossBuchstaben = String::toUpperCase;
		Function<String, String> ausrufezeichenAnfuegen = text -> text + "!";

		Function<String, String> textZuSchreien 
									= zuGrossBuchstaben.andThen( ausrufezeichenAnfuegen );

		return textZuSchreien.apply(gesprochen);
	}

	@DisplayName("Hallo soll in HALLO! umgewandelt werden.")
	@Test
	public void test01() {
		assertEquals( "HALLO!", verwandleInSchreien( "Hallo" ) );		
	}

}
