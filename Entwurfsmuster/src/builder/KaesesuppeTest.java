package builder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class KaesesuppeTest {
			
	/**
	 * <pre>
	 * Kaesesuppe erzeugen mit
	 * Wasser 100
	 * Gemuese 30
	 * Kaese 20
	 * </pre>
	 * @return Kaesesuppe speziell für den Test
	 */
	public static Kaesesuppe erzeugeKaesesuppeFuerTest() {
		return null;
	}
	
	@Test
	@DisplayName("Kann man die Kaesesuppe erzeugen?")
	public void test01() {
		Kaesesuppe kaesesuppe = erzeugeKaesesuppeFuerTest();
		assertEquals(
				"Kaesesuppe [kaese=20, toString()=Suppe [wasser=100, gemuese=30]]", 
				kaesesuppe.toString());
	}

}
