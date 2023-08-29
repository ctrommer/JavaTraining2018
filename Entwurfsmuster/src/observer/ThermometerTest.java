package observer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ThermometerTest {
	
	/**   
	 * Die Heizung ist an, wenn es kaelter als 18 Grad wird 
	 * -> Ausgabe:
	 * "Heizung geht an." : "Heizung bleibt aus."
	 * 
	 * Die Klimaanlage laeuft, wenn es waermer als 20 Grad wird.
	 * -> Ausgabe:
	 * "Klimaanlage geht an." : "Klimaanlage bleibt aus." 
	 */
	public void simuliereClientFuerTest() {
		Thermometer thermometer = new Thermometer();
		
		thermometer.temperaturAenderungSimulieren();
	}	

	@DisplayName("Schalten sich Heizung und Klimaanlage bei Temperaturaenderungen an und aus?")
	@Test
	public void test01() {
		ByteArrayOutputStream umgeleitetesSystemOut = new ByteArrayOutputStream();
		
		System.setOut(new PrintStream(umgeleitetesSystemOut));
		simuliereClientFuerTest();
		
		assertEquals("Es ist 17 Grad.\r\n"
				+ "Heizung geht an.\r\n"
				+ "Klimaanlage bleibt aus.\r\n"
				+ "Es ist 18 Grad.\r\n"
				+ "Heizung bleibt aus.\r\n"
				+ "Klimaanlage bleibt aus.\r\n"
				+ "Es ist 19 Grad.\r\n"
				+ "Heizung bleibt aus.\r\n"
				+ "Klimaanlage bleibt aus.\r\n"
				+ "Es ist 20 Grad.\r\n"
				+ "Heizung bleibt aus.\r\n"
				+ "Klimaanlage bleibt aus.\r\n"
				+ "Es ist 21 Grad.\r\n"
				+ "Heizung bleibt aus.\r\n"
				+ "Klimaanlage geht an.\r\n", 
				umgeleitetesSystemOut.toString());
		System.setOut(System.out);
	}

}
