package land;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface CountryLandMapper {
	
    @Mappings({
        @Mapping(target="einwohnerzahl", source="country.population", defaultExpression = "java(0)"),	// population wird auf einwohnerzahl gemappt, 0 ist der default
        @Mapping( target = "hauptstadt", source = "country.capital"),									// beachte: Stadt ist eigene Klasse, die auch wieder eine Methode braucht, siehe ( 1 )
        @Mapping(target="letzterFussballWMTietel", source = "country.lastSoccerWorldChampionshipTitle", dateFormat = "dd-MM-yyyy HH:mm:ss"),
        @Mapping(target= "staedte", source = "country.cities")											// beachte: Liste braucht eigene Methode, die wiederum funktioniert, weil es eine Methode für Stadt gibt       
      })	
	Land countryZuLand( Country country );																// name gibt es in land und country, wird deshalb  automatisch gemappt
    
    @Mappings( {
    	@Mapping( target="population", source="land.einwohnerzahl" ),
    	@Mapping( target = "capital", source = "land.hauptstadt" ),    	
    	@Mapping( target="lastSoccerWorldChampionshipTitle", source = "land.letzterFussballWMTietel", dateFormat = "dd-MM-yyyy HH:mm:ss" ),
    	@Mapping( target = "cities", source = "land.staedte" ) 
    })
	Country landZuCountry( Land land );

    @Mappings({
    	@Mapping( target = "hoehe", source = "city.elevation")
    })
    Stadt cityZuStadt( City city );																		// ( 1 )
    
    List<Stadt> citiesZuStadte( Collection<City> cities ); 
    
    @Mappings({
    	@Mapping( target = "elevation", source = "stadt.hoehe")
    })    
    City stadtZuCity( Stadt stadt );
    
    List<City> stadteZuCities( Collection<Stadt> staedte );

}
