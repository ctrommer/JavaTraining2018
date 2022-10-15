package providenAnnotation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WaldTest {

	@Test
	@DisplayName("Wurde der Wald richtig zusammengebaut?")
	public void test01() {
		Wald wald = Wald.erzeugeWaldMitGuice();
		assertEquals("Wald [foerster=FoersterImpl [name=Karl, alter=42]]", wald.toString());
	}

}
