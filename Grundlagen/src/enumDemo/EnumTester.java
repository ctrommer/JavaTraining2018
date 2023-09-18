package enumDemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EnumTester {
	
	private Wochentag erzeugeMontag() {
		return null;		
	}

	private Wochentag erzeugeDienstag() {
		return null;
	}

	private Boolean istMontag( Wochentag wochentag ) {
		return null;
	}

	private String textVonWochentag( Wochentag wochentag ) {
		return null;
	}
	
	@DisplayName("Wird Montag erzeugt und hat er den richtigen Text?")
	@Test
	public void test01() {
		Wochentag montag = erzeugeMontag();
		Assertions.assertEquals( "Montag", textVonWochentag(montag) );		
	}

	@DisplayName("Wird Dienstag erzeugt und hat er den richtigen Text?")
	@Test
	public void test02() {
		Wochentag dienstag = erzeugeDienstag();
		Assertions.assertEquals( "Tuesday", textVonWochentag(dienstag) );		
	}
	
	@DisplayName("Funktioniert Prüfung, ob Wochentag ein Montag ist?")
	@Test
	public void test03() {
		Boolean istMontag = istMontag(erzeugeMontag());
		Assertions.assertTrue(istMontag);		
	}

	@DisplayName("Funktioniert Prüfung, ob Wochentag ein Dienstag ist?")
	@Test
	public void test04() {
		Boolean istMontag = istMontag(erzeugeDienstag());
		Assertions.assertFalse(istMontag);		
	}

}
