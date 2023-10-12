package mitarbeiter;

import org.mapstruct.Context;
import org.mapstruct.Mapper;

/**
 * Quelle:
 * https://github.com/mapstruct/mapstruct-examples/tree/master/mapstruct-mapping-with-cycles
 * 
 * Loesung fuer zyklische Abhängigkeiten.
 *
 */
@Mapper
public interface EmployeeMitarbeiterMapper {
	
	Mitarbeiter zuMitarbeiter( Employee quelle, @Context ZyklischeAbhaengigkeitenVerhinderer context );
	
	Employee zuEmployee( Mitarbeiter quelle, @Context ZyklischeAbhaengigkeitenVerhinderer context );
	
}
