package test.mitJUnit4;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import main.MeineMathematik;

@RunWith(Parameterized.class)
public class VieleParameterEinTestMitKonstruktor {

    private int faktor1;
    private int faktor2;

    public VieleParameterEinTestMitKonstruktor(int faktor1, int faktor2) {
        this.faktor1 = faktor1;
        this.faktor2 = faktor2;
    }

    // erzeugt die Testdaten
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
        	{ 1 , 2 }, 
        	{ 5, 3 }, 
        	{ 121, 4 } 
        	};

        return Arrays.asList(data);
    }

    // es darf nur eine Test-Methode geben
    @Test
    public void testMultiplyException() {
        MeineMathematik mathematik = new MeineMathematik();
        assertEquals("Erwartet wird, dass die Multiplikation von zwei Zahlen das richtige Ergebnis lierfert.", faktor1 * faktor2, mathematik.multipiziere( faktor1, faktor2 ));
    }

}