package builder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import builder.Fitnessstudio.Trainingsmoeglichkeit;

public class FitnessstudioTest {
	
	/**
	 * <pre>
	 * Fitnesstudio erzeugen mit 
	 * Trainingsmoeglichkeit FREIHANTEL KURSE
	 * 
	 * </pre>
	 * @return ein Fitnessstudio speziell für den Test
	 */
	public static Fitnessstudio erzeugeFitnessstudioFuerTest() {
		Fitnessstudio fitnessstudio = new Fitnessstudio.Builder()
														.fuegeTrainingsartHinzu(Trainingsmoeglichkeit.FREIHANTEL)
														.fuegeTrainingsartHinzu(Trainingsmoeglichkeit.KURSE)
														.build();
		return fitnessstudio;
	}
	
	@Test
	@DisplayName("Kann man das Fitnesstudio erzeugen?")
	public void test01() {
		Fitnessstudio fitnessstudio = erzeugeFitnessstudioFuerTest();
		assertEquals("Fitnessstudio [trainingsmoeglichkeiten=[FREIHANTEL, KURSE]]", fitnessstudio.toString());
	}
	
	@Test
	@DisplayName("Sind die Felder von Fitnesstudio private und final?")
	public void test02() {
		Field[] fields = Fitnessstudio.class.getDeclaredFields();
		
		Stream
			.of(fields)
			.forEach( field -> {
				int modifiers = field.getModifiers();
				assertTrue( Modifier.isFinal(modifiers), field.getName() + " muss final sein." );
				assertTrue( Modifier.isPrivate(modifiers), field.getName() + " muss private sein.");				
			});		
	}

}
