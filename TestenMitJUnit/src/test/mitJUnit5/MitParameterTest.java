package test.mitJUnit5;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import main.Wochentag;

public class MitParameterTest {

    /**
     * F�hre den Test aus mit den Zahlen 1, 2 und 3
     * @param zahl
     * die zu parameteriesierende Zahl
     */
    void testeZahlen( int zahl ) {
    	assertNotNull( zahl );
    }

    /**
     * F�hre den Test aus mit Montag und Dienstag
     * @param wochentag
     */
    void testeEnum( Wochentag wochentag ) {
    	assertNotNull( wochentag );
    }

    /**
     * F�hre den Test aus mit den Werten, die von der Methode erzeugeWortMitWortLaenge zur�ckgegeben werden.
     * @param text
     * text f�r den Test
     * @param laenge
     * l�nge f�r den Test
     */
    void testeMitMethodeAlsDatenQuelle( String text, int laenge ) {     	
    	assertTrue( text.length() == laenge );    	
    }

    /**
     * Methode, die Testwerte produziert
     * @return
     * Werte, die f�r die Testmethode verwendet werden
     */
	private static void erzeugeWortMitWortLaenge() {
    }

    /**
     * Durch Komma getrennte Werte zum Testen verwenden
     * @param text
     * text f�r Test
     * @param laenge
     * L�nge f�r Test
     */
    void testeMitCSVAlsDatenQuelle( String text, int laenge ) { 
    	assertTrue( text.length() == laenge ); // Juhu: String::length funktioniert!!!
    }
    
}
