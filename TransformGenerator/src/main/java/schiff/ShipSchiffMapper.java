package schiff;

import java.time.LocalDateTime;

import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public abstract class ShipSchiffMapper {
	
	/**
	 * 1 kg = 2.205 LBS
	 */
	private static final double LBS_ZU_KG_FAKTOR = 2.205;
	
	/**
	 * Wenn man eine Extrawurst braten m�chte, kann man die Mapping Methode auch selber schreiben.
	 * Hier wird zum Beispiel das britische Pfund in kg umgerechnet.
	 * 
	 * Achtung:
	 * Hier wird dann natürlich auch keine Methode in ShipSchiffMapperImpl generiert. Wenn man   
	 * @BeforeMapping oder @AfterMapping verwendet, wird für die auch nichts generiert.   
	 * 
	 * @param ship
	 * ship soll zu Schiff konvertiert werden.
	 * @return
	 * Schiff entstanden aus konvertierem ship.
	 */
	public Schiff shipZuSchiff( Ship ship ) {
		if ( ship == null ) {
			return null;
		}
		return new Schiff(ship.getName(), ship.getColour(), ship.getWeightInLBS() / LBS_ZU_KG_FAKTOR);
	}

	public Ship schiffZuShip( Schiff schiff ) {
		if ( schiff == null ) {
			return null;
		}
		return new Ship(schiff.getName(), schiff.getFarbe(), schiff.getGewichtInKg() * LBS_ZU_KG_FAKTOR);
	}
	
}
