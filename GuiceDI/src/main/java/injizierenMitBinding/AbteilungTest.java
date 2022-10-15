package injizierenMitBinding;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AbteilungTest {
	
	@Test
	@DisplayName("Wurde die Abteilung richtig zusammengebaut?")
	public void test01() {
		Abteilung abteilung = Abteilung.erzeugeAbteilungMitGuice();
		assertEquals("Abteilung [weihnachtsfeier=Weihnachtsfeier [findetStatt=true], abteilungsleiter=AbteilungsleiterImpl [], adresse=AdresseImpl [], name=Forschung und Entw, spitzname=Nerds]", abteilung.toString());
	}
}
