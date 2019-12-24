package schiff;

import java.time.LocalDateTime;

import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public abstract class ShipSchiffMapper {
	
	@BeforeMapping
	protected void startKonvertierungZuShipSetzen( Schiff schiff, @MappingTarget Ship ship ) {
		LocalDateTime jetzt = LocalDateTime.now();
		schiff.setStartKonvertierung(jetzt);
		ship.setStartConversion(jetzt);
	}
	
	@BeforeMapping 
	protected void startKonvertierungZuSchiffSetzen( Ship ship, @MappingTarget Schiff schiff ) {
		LocalDateTime jetzt = LocalDateTime.now();
		schiff.setStartKonvertierung(jetzt);
		ship.setStartConversion(jetzt);
	}
	
	public Schiff shipZuSchiff( Ship ship ) {
		return new Schiff(ship.getName(), ship.getColour(), ship.getWeightInLBS()/2.205);
	}
	
	public Ship schiffZuShip( Schiff schiff ) {
		return new Ship(schiff.getName(), schiff.getFarbe(), schiff.getGewichtInKg()*2.205);
	}
	
	@AfterMapping
	protected void endeKonvertierungZuShipSetzen( Schiff schiff, @MappingTarget Ship ship ) {
		LocalDateTime jetzt = LocalDateTime.now();
		schiff.setEndeKonvertierung(jetzt);
		ship.setEndConversion(jetzt);
	}	
	
	@AfterMapping
	protected void endeKonvertierungZuSchiffSetzen( Ship ship, @MappingTarget Schiff schiff ) {	
		LocalDateTime jetzt = LocalDateTime.now();
		schiff.setEndeKonvertierung(jetzt);
		ship.setEndConversion(jetzt);		
	}
	
}
