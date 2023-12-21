package callBack;

import java.time.LocalDate;
import java.util.function.Function;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FormatiererTester {
	
	/**
	 * Demonstriert die Verwendung des Callbacks
	 * @param geburtsJahr
	 * @return z.B.: Das Alter betraegt: 25
	 */
	public String geburtsjahrZuAlter( LocalDate geburtsJahr ) {
		// besserer Name fuer callBack: call After
		// "Das Alter betraegt: "
		
		return null;
	}
	
	@Test
	@DisplayName("Wird das Geburtsjahr in Alter umgewandelt und formatiert?")
	public void test01() {
		LocalDate now = LocalDate.now();
		Assertions.assertEquals(
						"Das Alter betraegt: 25", 
						geburtsjahrZuAlter( now.minusYears( 25 ) ) );
	}

}