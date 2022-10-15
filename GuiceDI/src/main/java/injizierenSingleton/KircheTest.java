package injizierenSingleton;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class KircheTest {
	
	@Test
	@DisplayName("Wurde die Kirche richtig zusammengebaut?")
	public void test01() {
		Kirche kirche = Kirche.erzeugeKircheMitGuice();
		assertEquals("Kirche [singletonAufKlassenebene=SingletonAufKlassenebeneImpl [], singletonAufKonfigurationsEbene=SingletonAufKonfigurationsEbeneImpl [], singletonAufMethodenEbene=SingletonAufMethodenEbeneImpl []]", kirche.toString());
	}

}
