package steuerzahler;

import org.mapstruct.Mapper;

/**
 * Besonderheit in diesem Beispiel:
 * Source und Ziel haben unterschiedliche Klassenstruktur.
 * Steuerzahler - Investition hat investitionBetrag und investitionWaehrung
 * Taxpayer hat investmentAmount und investmentCurrency.
 * Es ist also bei Steuerzahler eine Klasse dazwischen, bei Taxpayer nicht.
 * 
 * Wenn Betrag oder Waehrung null ist, soll der jewails andere Wert auch null sein. 
 * Dies wird in AfterMapping realisiert. 
 * 
 * Setze Start der Konvertierung.
 *
 */
@Mapper
public abstract class TaxpayerSteuerzahlerMapper {

	public abstract Steuerzahler taxpayerZuSteuerzahler( Taxpayer taxpayer );

    public abstract Taxpayer steuerzahlerZuTaxpayer( Steuerzahler steuerzahler );
}
