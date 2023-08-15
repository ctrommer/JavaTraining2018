package builder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FitnessstudioTest {
	
	/**
	 * <pre>
	 * Fitnesstudio erzeugen mit 
	 * Trainingsmoeglichkeit FREIHANTEL KURSE
	 * 
	 * </pre>
	 * @return ein Fitnessstudio speziell für den Test
	 */
	public static Fitnessstudio erzeugeFitnessstudioFuerTest() {
		return null;
	}
	
	@Test
	@DisplayName("Kann man das Fitnesstudio erzeugen?")
	public void test02() {
		Fitnessstudio fitnessstudio = erzeugeFitnessstudioFuerTest();
		assertEquals("Fitnessstudio [trainingsarten=[FREIHANTEL, KURSE]]", fitnessstudio.toString());
	}

}
