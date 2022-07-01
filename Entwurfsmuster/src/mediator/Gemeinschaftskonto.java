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
	List<Kontoinhaber> kontoinhabers = new ArrayList<Kontoinhaber>();
	
	public void fuegeKontoinhaberHinzu( Kontoinhaber kontoinhaber ) {
		kontoinhabers.add(kontoinhaber);
	}

	public void bewegeGeld(BigDecimal geld) {
		kontoinhabers.forEach(element->element.benachrichtigeUeberGeldbewegung( geld ));		
	}
	
	public static void main( String[] args ) {
		Gemeinschaftskonto gemeinschaftskonto = new Gemeinschaftskonto();
		
		Kontoinhaber karl = new Kontoinhaber( gemeinschaftskonto, "Karl" );		
		Kontoinhaber egon = new Kontoinhaber( gemeinschaftskonto, "Egon" );
		
		karl.bewegeGeld(new BigDecimal(100));
		egon.bewegeGeld(new BigDecimal(-50));		
	}
}
