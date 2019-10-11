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
	
	public static void bevorDieTestsStarten() {
		System.out.println("bevor die Tests starten");	
	}

	public void vorJedemTest() {
		System.out.println("vor jedem Test");		
	}

	public void nachJedemTest() {
		System.out.println("nach jedem Test");		
	}

	public static void nachdemDieTestsBeendetSind() {
		System.out.println("nachdem die Tests beendet sind");
	}

	/**
	 * Deaktiviere den Test
	 */
	@Test
	public void testeDivisionDurchNull() 
	{
		int x = 1 / 0;
		System.out.println(x);
	}

    /**
     * Pr�fe, ob erwartete Exception geworfen wird
     * Pr�fe, ob die Exception den erwarteten Text enth�lt
     */
    @Test
    public void testeZugriffAufUngueltigenIndexSollExceptionWerfen() {
    	int[] zahlen = {1,2,3};
    	System.out.println(zahlen[9]);
    }
    
     /**
     * Wenn beide asserts fehlschlagen, werden beide angezeigt.
     */
    @Test
    void testeMehrereAssertions() {
    	int x = 5;
    	int y = 6;
    }

    @Test
    public void testDemonstriertAssertions() {

    	// Checks that the boolean condition is true.


    	// Checks that the boolean condition is false.

    	// Tests that two values are the same. Note: for arrays the reference is checked not the content of the arrays.

    	// Test that float or double values match. The tolerance is the number of decimals which must be the same.

    	// Checks that the object is null.

    	// Checks that the object is not null.

    	// Checks that both variables refer to the same object.
    	Integer x = new Integer(42);
		Integer y = x;

    	// Checks that both variables refer to different objects.
    	Integer z = new Integer( 43 );
    }

    @Test
    public void testeSollFehlschlagen() {
    	// Let the method fail. Might be used to check that a certain part of the code is not reached or to have a 
    	// failing test before the test code is implemented. The message parameter is optional.
    	
    }

    @Test
    public void testeNurUnterBestimmtenBedingungenAusfuehren() {
    	// Nur wenn das Betriebssystem Linux ist ...
		String betriebssystem = System.getProperty("os.name");		

		// ... dann soll dieser Test ausgef�hrt werden. 
    	int x = 1 / 0;
    	System.out.println(x);
    }

}


