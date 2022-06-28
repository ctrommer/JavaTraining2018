package abstrakteFabrik;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class KampfsportschuleTest {
	
	@DisplayName("Wurde das Entwurfsmuster abstrakte Fabrik für das Boxtraining richtig verwendet?")
	@Test
	public void test01() {
		KampfsportSchule kampfsportSchule = new KampfsportSchule(new BoxtrainingFabrik());
		String kampfsportWorkshop = kampfsportSchule.workshopDurchfuehren();
		
		assertEquals("Ich habe Boxen trainiert mit Boxhandschuh", kampfsportWorkshop);
	}
	
	@DisplayName("Wurde das Entwurfsmuster abstrakte Fabrik für das Waffentraining richtig verwendet?")
	@Test
	public void test02() {
		KampfsportSchule kampfsportSchule = new KampfsportSchule(new WaffentrainingFabrik());
		String kampfsportWorkshop = kampfsportSchule.workshopDurchfuehren();
		
		assertEquals("Ich habe Waffen trainiert mit Messer", kampfsportWorkshop);
	}	

}
