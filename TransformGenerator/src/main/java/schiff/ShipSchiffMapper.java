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
	
	/**
	 * Wenn man eine Extrawurst braten m�chte, kann man die Mapping Methode auch selber schreiben.
	 * Hier wird zum Beispiel das britische Pfund in kg umgerechnet.
	 * @param ship
	 * ship soll zu Schiff konvertiert werden.
	 * @return
	 * Schiff entstanden aus konvertierem ship.
	 */
	public Schiff shipZuSchiff( Ship ship ) {
		if ( ship == null ) {
			return null;
		}
		return new Schiff(ship.getName(), ship.getColour(), ship.getWeightInLBS()/2.205);
	}

	public Ship schiffZuShip( Schiff schiff ) {
		if ( schiff == null ) {
			return null;
		}
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
