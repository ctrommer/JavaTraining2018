package personTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import person.Person;
import person.PersonDTO;
import person.PersonMapper;

public class PersonMapperUnitTest {

    @Test
    public void givenPersonEntitytoPersonWithExpression_whenMaps_thenCorrect() {
        
        Person entity  = new Person();
        entity.setName("Micheal");
        
        PersonDTO personDto = PersonMapper.INSTANCE.personToPersonDTO(entity);

        //assertNull(entity.getId());
        assertNotNull(personDto.getId());
        assertEquals(personDto.getName(), entity.getName());
    }
}
