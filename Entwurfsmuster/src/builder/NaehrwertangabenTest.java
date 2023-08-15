package builder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class NaehrwertangabenTest {
	
	/**
	 * <pre> 
	 * Pudding erzeugen mit
	 * kalorien = 100
	 * eiweis = 10
	 * kohlehydrate = 20
	 * fett = 30
	 * vegan = true
	 * </pre>
	 * 
	 * @return Pudding für Test 
	 */
	public static Naehrwertangaben erzeugePuddingFuerTest() {

		return null;
	}
	
	@Test
	@DisplayName("Kann man den Pudding erzeugen?")
	public void test01() {
		Naehrwertangaben naehrwertangaben = erzeugePuddingFuerTest();
		assertEquals(
				"Naehrwertangaben [kalorien=100, eiweis=10, kohlehydrate=20, fett=30, vegan=true]", 
				naehrwertangaben.toString());		
	}

	@Test
	@DisplayName("Sind die Felder von Naehrwertangaben private und final?")
	public void test02() {
		Field[] fields = Naehrwertangaben.class.getDeclaredFields();
		
		Stream
			.of(fields)
			.forEach( field -> {
				int modifiers = field.getModifiers();
				assertTrue( Modifier.isFinal(modifiers), field.getName() + " muss final sein." );
				assertTrue( Modifier.isPrivate(modifiers), field.getName() + " muss private sein.");				
			});
	}

}
