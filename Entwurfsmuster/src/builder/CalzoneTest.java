package builder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import builder.Pizza.Belag;

public class CalzoneTest {
	
	/**
	 * <pre>
	 * Calzone erzeugen mit
	 * Belag Pilze Zwiebeln
	 * sosseDrin = true
	 * </pre>
	 * @return Calzone speziell für den Test
	 */
	public static Calzone erzeugeCalzoneFuerTest() {
		Calzone calzone = new Calzone.Builder()
										.fuegeBelagHinzu( Belag.PILZE )
										.fuegeBelagHinzu( Belag.ZWIEBELN )
										.sosseDrin( )
										.build();
		return calzone;
	}
	
	@Test
	@DisplayName("Kann man die Calzon erzeugen?")
	public void test01() {
		Calzone calzone = erzeugeCalzoneFuerTest();
		assertEquals("Calzone [sosseDrin=true, toString()=Pizza [belaege=[PILZE, ZWIEBELN]]]", 
						calzone.toString() );
	}
	
	@Test
	@DisplayName("Sind die Felder von Calzone private und final?" )
	public void test02() {
		Field[] fields = Calzone.class.getDeclaredFields();
		
		Stream
			.of(fields)
			.forEach( field -> {
				int modifiers = field.getModifiers();
				assertTrue( Modifier.isFinal(modifiers), field.getName() + " muss final sein." );
				assertTrue( Modifier.isPrivate(modifiers), field.getName() + " muss private sein.");				
			});	
		
	}
	
	@Test
	@DisplayName("Sind die Felder von Pizza private und final?")
	public void test03() {
		Field[] fields = Pizza.class.getDeclaredFields();
		
		Stream
			.of(fields)
			.forEach( field -> {
				int modifiers = field.getModifiers();
				assertTrue( Modifier.isFinal(modifiers), field.getName() + " muss final sein." );
				assertTrue( Modifier.isPrivate(modifiers), field.getName() + " muss private sein.");				
			});	
	}
	
	@Test
	@DisplayName("Erzeugt der Director eine Calzone mit Sosse?")
	public void test04() {
		CalzoneDirector calzoneDirector = new CalzoneDirector();
		Calzone calzoneMitSosse = calzoneDirector.erzeugeCalzoneMitSosse();
		assertEquals("Calzone [sosseDrin=true, toString()=Pizza [belaege=[]]]", 
						calzoneMitSosse.toString() );		
	}

}
