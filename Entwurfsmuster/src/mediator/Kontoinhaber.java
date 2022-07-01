package mediator;

import java.math.BigDecimal;

public class Kontoinhaber {
	
	private Gemeinschaftskonto gemeinschaftskonto;
	private String name;

	public Kontoinhaber( Gemeinschaftskonto gemeinschaftskonto, String name ) {
		this.gemeinschaftskonto = gemeinschaftskonto;
		this.name = name;
		gemeinschaftskonto.fuegeKontoinhaberHinzu(this);
	}
	
	public void bewegeGeld( BigDecimal geld ) {
		gemeinschaftskonto.bewegeGeld( geld );
	}

	public void benachrichtigeUeberGeldbewegung(BigDecimal geld) {
		System.out.println( name + " hat diese Nachricht erhalten: " + geld + " Euro wurden bewegt." );
	}

}
