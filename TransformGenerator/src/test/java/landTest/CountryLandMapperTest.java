package landTest;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.junit.Test;
import org.mapstruct.factory.Mappers;

import land.City;
import land.Country;
import land.CountryLandMapper;
import land.Stadt;
import land.Land;

public class CountryLandMapperTest {
	private CountryLandMapper countryLandMapper = Mappers.getMapper(CountryLandMapper.class);
	private static final String DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";

	@Test
	public void testeCountyZuLand() {
		Country spain = new Country("Spain", 46_722_980, new City(667), new Date(), Arrays.asList(new City(100), new City (200)));

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
		for ( int stadtIndex = 0; stadtIndex < spain.getCities().size(); stadtIndex++ ) {
			assertEquals(spain.getCities().get(stadtIndex).getElevation(), spanien.getStaedte().get(stadtIndex).getHoehe());
		}
	}

	@Test
	public void testeCountyZuLand_DefaultExpression() {
		Country spain = new Country("Spain", null, new City(667), new Date(), Arrays.asList(new City(100), new City (200)));

		Land spanien = countryLandMapper.countryZuLand(spain);

		assertEquals((Integer) 0, spanien.getEinwohnerzahl());		

	}

	@Test
	public void testeLandZuCountry() {
		Land spanien = new Land( "Spain", 46_722_980, new Stadt( 667), "11-07-2010 20:30:00", Arrays.asList(new Stadt(300), new Stadt( 400) ) );
		
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
	    
		for ( int cityIndex = 0; cityIndex < spain.getCities().size(); cityIndex++ ) {
			assertEquals(spanien.getStaedte().get(cityIndex).getHoehe(), spain.getCities().get(cityIndex).getElevation());
		}
	}
}
