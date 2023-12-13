package fabrikMethode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SalsaTanzschuleTest {
	
	@Test
	@DisplayName("Wurde Salsa Tanzlehrer ueber Fabrikmehtode erzeugt?")
	public void teste01() {
		SalsaTanzschule salsaTanzschule = new SalsaTanzschule();
		String ergebnis = salsaTanzschule.workshopDurchfuehren();
		assertEquals(
				"Ich habe Salsa unterrichtet.", 
				ergebnis);
	}

}
