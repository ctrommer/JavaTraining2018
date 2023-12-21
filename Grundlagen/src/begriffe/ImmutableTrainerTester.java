package begriffe;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ImmutableTrainerTester {

	@Test
	@DisplayName("Declare the class as final so it can not be extended")
	public void testeKlasseIstFinal() {
		assertTrue( 
				"Klasse muss final sein", 
				Modifier.isFinal( ImmutableTrainer.class.getModifiers() ) );
	}
	
	@Test
	@DisplayName("Make all fields private so that direct access is not allowed")
	public void testeFeldPrivate() {
		for ( Field field : ImmutableTrainer.class.getDeclaredFields() ) {
			Assertions.assertTrue( Modifier.isPrivate( field.getModifiers() ) );
		}
	}

	@Test
	@DisplayName("Make all fields final so that it's value can be assigned only once")
	public void testeFeldFinal() {
		for ( Field field : ImmutableTrainer.class.getDeclaredFields() ) {
			Assertions.assertTrue( Modifier.isFinal( field.getModifiers() ) );
		}
	}

	@Test
	@DisplayName("Initialize all the fields via a constructor performing deep copy")
	public void testeKonstruktorDeepCopy() {
		String string = "vorher String";
		StringBuilder stringBuilder = new StringBuilder( "vorher StringBuilder" );

		ImmutableTrainer immutableTrainer = new ImmutableTrainer( string, stringBuilder );

		string = "geaenderter String";
		stringBuilder.setCharAt( 0, 'X' );
		
		Assertions.assertNotEquals( 
								immutableTrainer.getString(), 
								string );
		Assertions.assertNotEquals(
								immutableTrainer.getStringBuilder(), 
								stringBuilder );

		Assertions.assertEquals(
							immutableTrainer.getString(), 
							"vorher String");
		
		Assertions.assertEquals(
							immutableTrainer.getStringBuilder().toString(), 
							"vorher StringBuilder");
	}
	
	@Test
	@DisplayName("Perform cloning of objects in the getter methods to return a copy "
			+ "rather than returning the actual object reference")
	public void testeKeineObjektReferenzZurueckgeben() {
		String stringVorher = "vorher String";
		StringBuilder stringBuilderVorher = new StringBuilder( "vorher StringBuilder" );
		
		ImmutableTrainer immutableTrainer = new ImmutableTrainer( stringVorher, stringBuilderVorher );
		
		@SuppressWarnings("unused")
		String stringAusImmutable = immutableTrainer.getString();
		@SuppressWarnings("unused")
		StringBuilder stringBuilderAusImmutable = immutableTrainer.getStringBuilder();

		stringAusImmutable = "veraenderter String";
		stringBuilderAusImmutable.setCharAt( 0, 'X' );
		
		Assertions.assertEquals(
							immutableTrainer.getString(), 
							stringVorher );
		Assertions.assertEquals(
							immutableTrainer.getStringBuilder().toString(), 
							"vorher StringBuilder" );
	}	

	@Test
	@DisplayName("Methode setString darf nicht existieren")
	public void testeSetString() {
		Assertions.assertThrows(
				NoSuchMethodException.class, 
				()-> { ImmutableTrainer
									.class
									.getMethod( "setString", String.class); },
				"Do not provide setter methods for variables ... oder andere Methoden, die den Wert der Variable veraendern");
	}
	
	@Test
	@DisplayName("Methode setStringBuilder darf nicht existieren")
	public void testeSetStringBuilder() {
		
		Assertions.assertThrows(
				NoSuchMethodException.class, 
				()-> { ImmutableTrainer
									.class
									.getMethod( "setStringBuilder", StringBuilder.class); },
				"Do not provide setter methods for variables ... oder andere Methoden, die den Wert der Variable veraendern");
	}
}

