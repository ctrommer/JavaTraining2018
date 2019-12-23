package landTest;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.mapstruct.factory.Mappers;

import land.Capital;
import land.Country;
import land.CountryLandMapper;
import land.Hauptstadt;
import land.Land;

public class CountryLandMapperTest {
	private CountryLandMapper countryLandMapper = Mappers.getMapper(CountryLandMapper.class);
	private static final String DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";
	
	@Test
	public void testeCountyZuLand() {
		Country spain = new Country("Spain", 46_722_980, new Capital(667), new Date());
		
		Land spanien = countryLandMapper.countryZuLand(spain);
		
		assertEquals(spain.getName(), spanien.getName());
		assertEquals(spain.getPopulation(), spanien.getEinwohnerzahl());	
		assertEquals(spain.getCapital().getElevation(), spanien.getHauptstadt().getHoehe());
		
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
		try {
			assertEquals( spain.getLastSoccerWorldChampionshipTitle().toString(), format.parse(spanien.getLetzterFussballWMTietel()).toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeLandZuCountry() {
		Land spanien = new Land( "Spain", 46_722_980, new Hauptstadt( 667), "11-07-2010 20:30:00");
		
		Country spain = countryLandMapper.landZuCountry(spanien);
		
		assertEquals( spanien.getName(), spain.getName() );
		assertEquals( spanien.getEinwohnerzahl(), spain.getPopulation() );
		assertEquals( spanien.getHauptstadt().getHoehe(), spain.getCapital().getElevation());
		
	    SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
	    
	    try {
			assertEquals(format.parse(spanien.getLetzterFussballWMTietel()).toString(), spain.getLastSoccerWorldChampionshipTitle().toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}
