package uebersetzen;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith( MockitoExtension.class )
public class TestUebersetzerStatic {

	@Test
	@DisplayName("statische Methode wird gemockt, schreien soll bei Fuck Beep zurueckgeben.")
	public void test01() {
		try ( MockedStatic<Uebersetzer> mockUebersetzer = Mockito.mockStatic( Uebersetzer.class ) ) {
			mockUebersetzer
					.when( () -> Uebersetzer.schreien("Fuck") )
					.thenReturn( "Beep." );
			
			assertEquals( 
					"Beep.", 
					Uebersetzer.schreien("Fuck") );			
		}
	}
}
