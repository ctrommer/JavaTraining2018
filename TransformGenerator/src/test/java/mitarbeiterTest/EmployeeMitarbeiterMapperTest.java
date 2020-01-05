package mitarbeiterTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mapstruct.factory.Mappers;

import mitarbeiter.Employee;
import mitarbeiter.EmployeeMitarbeiterMapper;
import mitarbeiter.Mitarbeiter;
import mitarbeiter.ZyklischeAbhaengigkeitenVerhinderer;

public class EmployeeMitarbeiterMapperTest {
	
	@Test
	public void testeMitarbeiterZuEmployee() {
		
		Mitarbeiter boss = new Mitarbeiter("Boss", null, null);
		
		Mitarbeiter mitarbeiter1 = new Mitarbeiter("Mitarbeiter1", boss, null);
		Mitarbeiter mitarbeiter2 = new Mitarbeiter("Mitarbeiter2", boss, null);
		
		boss.setTeam(Arrays.asList(mitarbeiter1, mitarbeiter2));
		
		EmployeeMitarbeiterMapper employeeMitarbeiterMapper = Mappers.getMapper( EmployeeMitarbeiterMapper.class);
		Employee transformierterBoss = employeeMitarbeiterMapper.zuEmployee(boss, new ZyklischeAbhaengigkeitenVerhinderer() );
		
		assertNotNull(transformierterBoss);
		assertNull(transformierterBoss.getBoss());
		
		List<Employee> team = transformierterBoss.getTeam();
		assertEquals(team.size(), 2);
		team.forEach(member->assertSame( member.getBoss(), transformierterBoss ));
		
	}
	
	@Test
	public void testeEmployeeZuMitarbeiter() {
		Employee boss = new  Employee("Boss", null, null );
		
		Employee employee1 = new Employee("Employee1", boss, null );
		Employee employee2 = new Employee("Employee2", boss, null );
		
		boss.setTeam(Arrays.asList(employee1, employee2));
		
		EmployeeMitarbeiterMapper employeeMitarbeiterMapper = Mappers.getMapper(EmployeeMitarbeiterMapper.class);
		Mitarbeiter transformierterBoss = employeeMitarbeiterMapper.zuMitarbeiter(boss, new ZyklischeAbhaengigkeitenVerhinderer());
		
		assertNotNull(transformierterBoss);
		assertNull(transformierterBoss.getBoss());
		
		List<Mitarbeiter> team = transformierterBoss.getTeam();
		assertEquals(team.size(), 2);
		team.forEach(member->assertSame( member.getBoss(), transformierterBoss ));

	}

}
