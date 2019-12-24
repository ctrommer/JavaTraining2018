package land;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface CountryLandMapper {
	
    @Mappings({
        @Mapping(target="einwohnerzahl", source="country.population"),	// population wird auf einwohnerzahl gemappt
        @Mapping( target = "hauptstadt", source = "country.capital"),	// beachte: Hauptstadt ist eigene Klasse, die auch wieder eine Methode braucht, siehe ( 1 )
        @Mapping(target="letzterFussballWMTietel", source = "country.lastSoccerWorldChampionshipTitle", dateFormat = "dd-MM-yyyy HH:mm:ss")
        
      })	
	Land countryZuLand( Country country );								// name gibt es in land und country, wird deshalb  automatisch gemappt
    
    @Mappings( {
    	@Mapping(target="population", source="land.einwohnerzahl"),
    	@Mapping( target = "capital", source = "land.hauptstadt"),    	
    	@Mapping(target="lastSoccerWorldChampionshipTitle", source = "land.letzterFussballWMTietel", dateFormat = "dd-MM-yyyy HH:mm:ss")
    	
    })
	Country landZuCountry( Land land );

    @Mappings({
    	@Mapping( target = "hoehe", source = "capital.elevation")
    })
    Hauptstadt capitalZuHauptstadt( Capital capital );					// ( 1 )
    
    public abstract List<Hauptstadt> capitalZuHauptstadt( Collection<Capital> capitals ); 
    
    @Mappings({
    	@Mapping( target = "elevation", source = "hauptstadt.hoehe")
    })    
    Capital hauptstadtZuCapital( Hauptstadt hauptstadt );
    public abstract List<Capital> hauptstadtZuCapital( Collection<Hauptstadt> hauptstaedte );

}
