package mediator;

import java.math.BigDecimal;

public class Kontoinhaber {

	private String name;
	
	public void bewegeGeld( BigDecimal geld ) {
	}

	public void benachrichtigeUeberGeldbewegung(BigDecimal geld) {
		System.out.println( name + " hat diese Nachricht erhalten: " + geld + " Euro wurden bewegt." );
	}

}
