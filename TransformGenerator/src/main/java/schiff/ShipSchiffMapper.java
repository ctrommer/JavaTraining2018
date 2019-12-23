package schiff;

import org.mapstruct.Mapper;

@Mapper
public abstract class ShipSchiffMapper {
	
	public Schiff shipZuSchiff( Ship ship ) {
		return new Schiff(ship.getName(), ship.getColour(), ship.getWeightInLBS()/2.205);
	}
	
	public Ship schiffZuship( Schiff schiff ) {
		return new Ship(schiff.getName(), schiff.getFarbe(), schiff.getGewichtInKg()*2.205);
	}
}
