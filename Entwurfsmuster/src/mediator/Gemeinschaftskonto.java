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
	List<GemeinschaftsKontoinhaber> kontoinhabers = new ArrayList<GemeinschaftsKontoinhaber>();

	public void fuegeKontoinhaberHinzu( GemeinschaftsKontoinhaber kontoinhaber ) {
		kontoinhabers.add( kontoinhaber );
	}

	public void bewegeGeld( BigDecimal geld ) {
		kontoinhabers.forEach( element -> element.benachrichtigeUeberGeldbewegung( geld ) );		
	}

}
