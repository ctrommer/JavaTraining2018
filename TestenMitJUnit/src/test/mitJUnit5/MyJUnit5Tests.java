package test.mitJUnit5;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class MyJUnit5Tests {
	
	@BeforeAll
	public static void bevorDieTestsStarten() {
		System.out.println("bevor die Tests starten");	
	}

	@BeforeEach
	public void vorJedemTest() {
		System.out.println("vor jedem Test");		
	}

	@AfterEach
	public void nachJedemTest() {
		System.out.println("nach jedem Test");		
	}

	@AfterAll
	public static void nachdemDieTestsBeendetSind() {
		System.out.println("nachdem die Tests beendet sind");
	}

	@Disabled("wird erst ausgefuehrt, wenn die Spezifikation klar ist")
	@Test
	public void testeDivisionDurchNull() 
	{
		int x = 1 / 0;
		System.out.println(x);
	}

    @Test
    public void testeZugriffAufUngueltigenIndexSollExceptionWerfen() {
    	int[] zahlen = {1,2,3};
    	Throwable throwable = Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> System.out.println(zahlen[9]));
    	boolean inhalt = throwable.getMessage().contains("9");
		assertTrue(inhalt);
    }
    
    /**
     * Wenn beide asserts fehlschlagen, werden beide angezeigt.
     */
    @Test
    void testeMehrereAssertions() {
    	int x = 5;
    	int y = 6;
    	assertAll("Erwartet wird, dass x = 5 und y = 6 ist. ", () -> assertEquals(x, 5), () -> assertEquals(y, 6));
    }

    @Test
    public void testDemonstriertAssertions() {

    	// Checks that the boolean condition is true.
    	assertTrue(true, "Erwartet, dass die Bedingung true ist.");

    	// Checks that the boolean condition is false.
    	assertFalse(false, "Erwartet, dass die Bedingung false ist.");

    	// Tests that two values are the same. Note: for arrays the reference is checked not the content of the arrays.
    	assertEquals("erwartet", "erwartet", "Erwartet wird, dass beide Werte gleich sind.");

    	// Test that float or double values match. The tolerance is the number of decimals which must be the same.
    	assertEquals( 0.1239 , 0.1231, 0.001, "Erwartet, dass die Werte innerhalb der Toleranz gleich sind");

    	// Checks that the object is null.
    	assertNull(null,"Erwartet, dass das Objekt null ist.");

    	// Checks that the object is not null.
    	assertNotNull(Integer.valueOf(42), "Erwartet, dass das Objekt nicht null ist.");

    	// Checks that both variables refer to the same object.
    	Integer x = Integer.valueOf(42);
		Integer y = x;
		assertSame(x, y, "Erwartet, dass beide sich auf das gleiche Objekt beziehen." );

    	// Checks that both variables refer to different objects.
    	Integer z = Integer.valueOf(42);
		assertNotSame(z, Integer.valueOf(42), "Erwartet, dass beide sich auf das gleiche Objekt beziehen. ");
    }

    @Test
    public void testeSollFehlschlagen() {
    	// Let the method fail. Might be used to check that a certain part of the code is not reached or to have a 
    	// failing test before the test code is implemented. The message parameter is optional.
    	fail("noch nicht implementiert");
    }

    @Test
    public void testeNurUnterBestimmtenBedingungenAusfuehren() {
    	// Nur wenn das Betriebssystem Linux ist ...
		String betriebssystem = System.getProperty("os.name");		
		Assumptions.assumeTrue(betriebssystem.contains("Linux"));
		// Assumptions.assumeTrue(betriebssystem.contains("Windows"));
		// ... dann soll dieser Test ausgeführt werden. 
    	int x = 1 / 0;
    	System.out.println(x);
    }

}


