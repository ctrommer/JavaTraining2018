package providenKlasse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GebauedeTest {
	
	@Test
	@DisplayName("Wurde das Gebaeude richtig zusammengebaut?")
	public void test01() {
		Gebaeude gebaeude = Gebaeude.erzeugeGebaeudeMitGuice();
		assertEquals(
				"Gebaeude [hausmeister=HausmeisterImpl [name=Karl, geburtsjahr=42]]", 
				gebaeude.toString() );
	}
}
