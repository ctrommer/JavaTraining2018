package test.mitJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import main.MeineMatheUtil;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.*;

@RunWith( Parameterized.class )
public class VieleParameterEinTest {

    // fields used together with @Parameter must be public
    @Parameter( 0 )
    public int faktor1;
    @Parameter( 1 )
    public int faktor2;
    @Parameter( 2 )
    public int ergebnis;

    // Methode zum Erzeugen der Testdaten muss genau so aussehen.
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { 
        									{ 1 , 2, 2 }, 
        									{ 5, 3, 15 }, 
        									{ 121, 4, 484 } 
        									};
        return Arrays.asList(data);
    }

    // es darf nur eine Test-Methode geben  
    @Test
    public void testMultiplizieren() {
        assertEquals(
        		"Result", 
        		ergebnis, 
        		MeineMatheUtil.multipiziere( faktor1, faktor2 ) );
    }
}