package steuerzahler;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

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
 */
@Mapper
public abstract class TaxpayerSteuerzahlerMapper {

    @Mappings({
        @Mapping( target = "investition", source = "taxpayer"),
      })	
	public abstract Steuerzahler taxpayerZuSteuerzahler( Taxpayer taxpayer );

    @Mappings( {
    	@Mapping( target = "investmentAmount", source = "investition.investitionBetrag" ),
    	@Mapping( target = "investmentCurrency", source = "investition.investitionWaehrung" ),
    })
    public abstract Taxpayer steuerzahlerZuTaxpayer( Steuerzahler steuerzahler );

    public Long map(Long quelle) {
    	return quelle;
    }

    public String map(Investition quelle, @MappingTarget String ziel ) {
    	return quelle.getInvestitionWaehrung();
    }

    protected Investition taxpayerZuInvestition( final Taxpayer taxpayer ) {
    	return new Investition(taxpayer.getInvestmentAmount(), taxpayer.getInvestmentCurrency());
    }

    @AfterMapping
    protected void steuerzahlerZuTaxpayerNullBehandeln( @MappingTarget final Steuerzahler steuerzahler ) {
    	if ( steuerzahler != null ) {
    		Investition investition = steuerzahler.getInvestition();
	    	if ( investition != null ) {
	    		if ( investition.getInvestitionWaehrung() == null ) {
	    			investition.setInvestitionBetrag(null);
	    		}
	    	}
	    	if ( investition != null ) {
	    		if ( investition.getInvestitionBetrag() == null ) {
	    			investition.setInvestitionWaehrung(null);
	    		}
	    	}
    	}
    }
    
    @AfterMapping
    protected void taxpayerZuInvestitionNullBehandeln( @MappingTarget final Taxpayer taxpayer ) {
    	if ( taxpayer != null ) {
    		if ( taxpayer.getInvestmentCurrency() == null ) {
    			taxpayer.setInvestmentAmount(null);
    		}
    		if ( taxpayer.getInvestmentAmount() == null ) {
    			taxpayer.setInvestmentCurrency(null);
    		}
    	}
	}
    
}
