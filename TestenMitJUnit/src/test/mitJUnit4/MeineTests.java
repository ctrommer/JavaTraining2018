package test.mitJUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class MeineTests {
	
	@BeforeClass 
	public static void bevorDieTestsStarten() {
		System.out.println("bevor die Tests starten");	
	}

	@Before
	public void vorJedemTest() {
		System.out.println("vor jedem Test");		
	}

	@After
	public void nachJedemTest() {
		System.out.println("nach jedem Test");		
	}

	@AfterClass
	public static void nachdemDieTestsBeendetSind() {
		System.out.println("nachdem die Tests beendet sind");
	}

	@Ignore("wird erst ausgefuehrt, wenn die Spezifikation klar ist")
	public void multiplizierenVonGrossenIntegernSollSinnvollenWertErgeben() 
	{
		int x = 1 / 0;
		System.out.println(x);
	}
    
    @Test( expected = Exception.class)
    public void testeRichtigeExceptionBeiFalschemIndex() {
    	int[] zahlen = {1,2,3};
    	System.out.println(zahlen[9]);
    }
    
    @Test(timeout = 1)
    public void testeAbbruchNachTimeOut() {
		for ( int index1 = 1; index1 <= 30000; index1++ ) {
			for ( int index2 = 1; index2 <= 30000; index2++ ) {			
				System.out.print(index1 + " " + index2);
			}
		}			
    }

    @Test ( expected = ArrayIndexOutOfBoundsException.class ) 
    public void testeErwarteteException() {
    	int zahlen[] = { 1,2,3 };
    	System.out.println(zahlen[8]);
    }

    @Test
    public void testDemonstriertAssertions() {

    	// Checks that the boolean condition is true.
    	assertTrue("Erwartet dass die Bedingung true ist.", true);

    	// Checks that the boolean condition is false.
    	assertFalse("Erwartet dass die Bedingung false ist.", false);

    	// Tests that two values are the same. Note: for arrays the reference is checked not the content of the arrays.
    	assertEquals("Erwartet wird, dass beide Werte gleich sind.", "erwartet", "erwartet");

    	// Test that float or double values match. The tolerance is the number of decimals which must be the same.
    	assertEquals("Erwartet, dass die Werte innerhalb der Toleranz gleich sind", 0.1239 , 0.1231, 0.001);

    	// Checks that the object is null.
    	assertNull("Erwartet, dass das Objekt null ist.", null);

    	// Checks that the object is not null.
    	assertNotNull("Erwartet, dass das Objekt nicht null ist.", new Integer(42));

    	// Checks that both variables refer to the same object.
    	Integer x = new Integer(42);
		Integer y = x;
		assertSame("Erwartet, dass beide sich auf das gleiche Objekt beziehen. ", x, y );

    	// Checks that both variables refer to different objects.
    	Integer z = new Integer( 43 );
		assertNotSame("Erwartet, dass beide sich auf unterschiedliche Objekte beziehen. ", new Integer(42), z );
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
		Assume.assumeTrue(betriebssystem.contains("Linux"));
		// Assume.assumeTrue(betriebssystem.contains("Windows"));
		// ... dann soll dieser Test ausgeführt werden. 
    	int x = 1 / 0;
    	System.out.println(x);
    }

}
