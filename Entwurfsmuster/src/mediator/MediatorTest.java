package mediator;

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

		GemeinschaftsKontoinhaber karl = new GemeinschaftsKontoinhaber( "Karl", gemeinschaftskonto );		
		GemeinschaftsKontoinhaber egon = new GemeinschaftsKontoinhaber( "Egon", gemeinschaftskonto );
		
		karl.bewegeGeld( new BigDecimal( 100 ) );
		egon.bewegeGeld( new BigDecimal( -50 ) );		
		
		List<String> karlsKontoauszug = karl.getKontoauszug();
		List<String> egonsKontoauszug = egon.getKontoauszug();
		assertEquals(
				"Karl hat diese Nachricht erhalten: 100 Euro wurden bewegt.", 
				karlsKontoauszug.get( 0 ) );
		assertEquals(
				"Karl hat diese Nachricht erhalten: -50 Euro wurden bewegt.", 
				karlsKontoauszug.get( 1 ) );
		assertEquals(
				"Egon hat diese Nachricht erhalten: 100 Euro wurden bewegt.", 
				egonsKontoauszug.get( 0 ) );
		assertEquals(
				"Egon hat diese Nachricht erhalten: -50 Euro wurden bewegt.", 
				egonsKontoauszug.get( 1 ) );
	}	
}
