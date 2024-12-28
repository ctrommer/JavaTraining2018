package uebersetzen;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

public class TestUebersetzerStatic {

	@Test
	@DisplayName("statische Methode wird gemockt, schreien soll bei Fuck Beep zurueckgeben.")
	public void test01() {

			
			assertEquals( 
					"Beep.", 
					Uebersetzer.schreien("Fuck") );			
	}
}
