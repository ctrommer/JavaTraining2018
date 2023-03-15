package schiffTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.mapstruct.factory.Mappers;

import schiff.Schiff;
import schiff.Ship;
import schiff.ShipSchiffMapper;

public class SchipSchiffMapperTest {
	private  ShipSchiffMapper shipSchiffMapper = Mappers.getMapper(ShipSchiffMapper.class);
	
	@Test
	public void testeShipZuSchiff( ) {
		Ship ship = new Ship( "Titanic", "black", 10_000 );
		
		Schiff schiff = shipSchiffMapper.shipZuSchiff(ship);
		
		assertEquals(ship.getName(), schiff.getName());
		assertEquals(ship.getColour(), schiff.getFarbe());
		assertEquals(ship.getWeightInLBS(), schiff.getGewichtInKg()/2.205, 1);
	}

	@Test
	public void testeSchiffZuShip() {
		Schiff schiff = new Schiff("Titanic", "schwarz", 10_000);
		
		Ship ship = shipSchiffMapper.schiffZuShip(schiff);
		
		assertEquals( schiff.getName(), ship.getName() );
		assertEquals( schiff.getFarbe(), ship.getColour() );
		assertEquals( schiff.getGewichtInKg(), ship.getWeightInLBS()*2.205, 1 );		
	}
	
	@Test
	public void testeShipZuSchiffNull() {
		Ship ship = null;
		
		Schiff schiff = shipSchiffMapper.shipZuSchiff(ship);
		
		assertNull(schiff);
	}
	
	@Test
	public void testeSchiffZuShipNull() {
		Schiff schiff = null;
		
		Ship ship = shipSchiffMapper.schiffZuShip(schiff);
		
		assertNull( ship );
	}
}
