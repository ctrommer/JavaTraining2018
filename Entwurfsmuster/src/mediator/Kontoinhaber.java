package mediator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Kontoinhaber {
	
	private String name;
	private Gemeinschaftskonto gemeinschaftskonto;
	private List<String> kontoauszug = new ArrayList<>();
	
	public Kontoinhaber(String name) {
		this.name = name;
	}

	public Kontoinhaber( String name, Gemeinschaftskonto gemeinschaftskonto ) {
		this.name = name;
		this.gemeinschaftskonto = gemeinschaftskonto;

		if ( gemeinschaftskonto != null ) {
			gemeinschaftskonto.fuegeKontoinhaberHinzu(this);
		}
	}

	public void bewegeGeld( BigDecimal geld ) {
		if ( gemeinschaftskonto != null ) {
			gemeinschaftskonto.bewegeGeld(geld);
		}
	}

	public void benachrichtigeUeberGeldbewegung(BigDecimal geld) {
		kontoauszug.add( name + " hat diese Nachricht erhalten: " + geld + " Euro wurden bewegt." );
	}

	public List<String> getKontoauszug() {
		return kontoauszug;
	}

}
