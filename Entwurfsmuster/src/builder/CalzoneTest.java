package builder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalzoneTest {
	
	/**
	 * <pre>
	 * Calzone erzeugen mit
	 * Belag Pilze
	 * sosseDrin = true
	 * </pre>
	 * @return Calzone speziell für den Test
	 */
	public static Calzone erzeugeCalzoneFuerTest() {

		return null;
	}
	
	@Test
	@DisplayName("Kann man die Calzon erzeugen?")
	public void test01() {
		Calzone calzone = erzeugeCalzoneFuerTest();
		assertEquals("Calzone [sosseDrin=true, belaege=[PILZE]]", calzone.toString() );
	}

}
