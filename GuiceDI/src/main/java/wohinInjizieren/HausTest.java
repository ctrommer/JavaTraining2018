package wohinInjizieren;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HausTest {
	
	@Test
	@DisplayName("Wurde das Haus richtig zusammengebaut?")
	public void test01() {
		Haus haus = Haus.erzeugeHausMitGuice();
		assertEquals("Haus [tuer=Tuer [], fenster=Fenster [], wand=Wand [], dach=Dach [text=injiziertes Dach]]", haus.toString());
	}

}
