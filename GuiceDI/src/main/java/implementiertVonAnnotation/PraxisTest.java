package implementiertVonAnnotation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PraxisTest {

	@Test
	@DisplayName("Wurde die Paxis richtig zusammengebaut?")
	public void test01() {
		Praxis praxis = Praxis.erzeugePraxisMitGuice();
		assertEquals("Praxis [sprechstundenhilfe=SprechstundenhilfeImpl []]", praxis.toString());								
	}
	
}
