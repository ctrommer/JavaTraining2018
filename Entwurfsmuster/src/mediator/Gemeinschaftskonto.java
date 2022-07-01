package mediator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementiere das Gemeinschaftskonto als Mediator. Wenn ein Kontoinhaber Geld bewegt, sollen die anderen
 * Kontoinhaber darüber informiert werden.
 *
 */
public class Gemeinschaftskonto {
	
	public static void main( String[] args ) {
		Gemeinschaftskonto gemeinschaftskonto = new Gemeinschaftskonto();
		
		Kontoinhaber karl = new Kontoinhaber(  );		
		Kontoinhaber egon = new Kontoinhaber(  );
		
		karl.bewegeGeld(new BigDecimal(100));
		egon.bewegeGeld(new BigDecimal(-50));		
	}
}
