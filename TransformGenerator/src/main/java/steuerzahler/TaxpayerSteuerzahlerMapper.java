package steuerzahler;

import java.time.LocalDateTime;
import java.util.Optional;

import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
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
 * Setze Start der Konvertierung.
 *
 */
@Mapper
public abstract class TaxpayerSteuerzahlerMapper {
	
	private void setzeStartKonvertierung( Steuerzahler steuerzahler, Taxpayer taxpayer ) {
		LocalDateTime jetzt = LocalDateTime.now();
		steuerzahler.setStartKonvertierung(jetzt);
		taxpayer.setStartConversion(jetzt);
	}

	@BeforeMapping
	protected void startKonvertierungZuTaxpayerSetzen( Steuerzahler steuerzahler, @MappingTarget Taxpayer taxpayer ) {
		setzeStartKonvertierung( steuerzahler, taxpayer );
	}
	
	@BeforeMapping 
	protected void startKonvertierungZuSteuerzahlerSetzen( Taxpayer taxpayer, @MappingTarget Steuerzahler steuerzahler ) {
		setzeStartKonvertierung( steuerzahler, taxpayer );
	}

    @Mappings({
        @Mapping( 
        		target = "investition", 
        		source = "taxpayer" ),
      })	
	public abstract Steuerzahler taxpayerZuSteuerzahler( Taxpayer taxpayer );

    @Mappings( {
    	@Mapping( 
    			target = "investmentAmount", 
    			source = "investition.investitionBetrag" ),
    	@Mapping( 
    			target = "investmentCurrency", 
    			source = "investition.investitionWaehrung" ),
    })
    public abstract Taxpayer steuerzahlerZuTaxpayer( Steuerzahler steuerzahler );

    protected Investition taxpayerZuInvestition( final Taxpayer taxpayer ) {
    	return new Investition( 
    						taxpayer.getInvestmentAmount(), 
    						taxpayer.getInvestmentCurrency() );
    }

    @AfterMapping
    protected void taxpayerZuSteuerzahlerNullBeruecksichtigen( @MappingTarget Steuerzahler steuerzahler ) {
    	
    	Optional.of( steuerzahler )
    		.map( zahler -> zahler.getInvestition() )
    		.ifPresent( inv -> {
    			if ( inv.getInvestitionBetrag() == null ) { inv.setInvestitionWaehrung(null); }
    			if ( inv.getInvestitionWaehrung() == null ) { inv.setInvestitionBetrag(null); }
    		});
    }

    @AfterMapping
    protected void steuerzahlerZuTaxpayerNullBeruecksichtigen( @MappingTarget Taxpayer taxpayer ) {
    	
    	Optional.of( taxpayer )
    		.ifPresent( payer-> {
    			if ( payer.getInvestmentAmount() == null ) { payer.setInvestmentCurrency(null); }
    			if ( payer.getInvestmentCurrency() == null ) { payer.setInvestmentAmount(null); }
    		});
    }
    
}
