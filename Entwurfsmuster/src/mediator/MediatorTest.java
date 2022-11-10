package mediator;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MediatorTest {
	
	@DisplayName("Wurde das Entwurfsmuster Mediator richtig angewendet?")
	@Test
	public void test01() {
		Gemeinschaftskonto gemeinschaftskonto = new Gemeinschaftskonto();

		Kontoinhaber karl = new Kontoinhaber( "Karl", gemeinschaftskonto );		
		Kontoinhaber egon = new Kontoinhaber( "Egon", gemeinschaftskonto );
		
		karl.bewegeGeld(new BigDecimal(100));
		egon.bewegeGeld(new BigDecimal(-50));		
		
		List<String> karlsKontoauszug = karl.getKontoauszug();
		List<String> egonsKontoauszug = egon.getKontoauszug();
		assertEquals("Karl hat diese Nachricht erhalten: 100 Euro wurden bewegt.", karlsKontoauszug.get(0));
		assertEquals("Karl hat diese Nachricht erhalten: -50 Euro wurden bewegt.", karlsKontoauszug.get(1));
		assertEquals("Egon hat diese Nachricht erhalten: 100 Euro wurden bewegt.", egonsKontoauszug.get(0));
		assertEquals("Egon hat diese Nachricht erhalten: -50 Euro wurden bewegt.", egonsKontoauszug.get(1));
	}

	@DisplayName("Wurde beruecksichtigt, dass das Gemeinschaftskonto null sein kann?")
	@Test
	public void test02() {
		
		Kontoinhaber alleine = new Kontoinhaber( "John" );
		
		alleine.bewegeGeld(new BigDecimal( 66) );
		List<String> kontoauszug = alleine.getKontoauszug();
		assertTrue( kontoauszug.isEmpty());		
	}
	
}
