package person;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);	// wird im Untitest gebraucht
     
    @Mapping(target = "id", source = "person.id", 
      defaultExpression = "java(java.util.UUID.randomUUID().toString())")
    PersonDTO personToPersonDTO(Person person);
}
