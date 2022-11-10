package mediator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Kontoinhaber {

	private String name;

	private List<String> kontoauszug = new ArrayList<>();
	
	public Kontoinhaber(String name) {
	}
	
	public Kontoinhaber(String name, Gemeinschaftskonto gemeinschaftskonto) {
	}

	public void bewegeGeld( BigDecimal geld ) {
	}

	public void benachrichtigeUeberGeldbewegung(BigDecimal geld) {
		kontoauszug.add( name + " hat diese Nachricht erhalten: " + geld + " Euro wurden bewegt." );
	}

	public List<String> getKontoauszug() {
		return kontoauszug;
	}

}
