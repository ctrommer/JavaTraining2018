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
    	@Mapping( target = "hoehe", source = "capital.elevation")
    })
    Stadt capitalZuHauptstadt( City capital );					// ( 1 )
    
    public abstract List<Stadt> citiesZuStadte( Collection<City> capitals ); 
    
    @Mappings({
    	@Mapping( target = "elevation", source = "hauptstadt.hoehe")
    })    
    City hauptstadtZuCapital( Stadt hauptstadt );
    public abstract List<City> stadteZuCities( Collection<Stadt> staedte );

}
