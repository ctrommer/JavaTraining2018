package test.mitJUnit5;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import main.Wochentag;

public class MitParameterTest {

    /**
     * Führe den Test aus mit den Zahlen 1, 2 und 3
     * @param zahl
     * die zu parameteriesierende Zahl
     */
    void testeZahlen( int zahl ) {
    	assertNotNull( zahl );
    }

    /**
     * Führe den Test aus mit Montag und Dienstag
     * @param wochentag
     */
    void testeEnum( Wochentag wochentag ) {
    	assertNotNull( wochentag );
    }

    /**
     * Führe den Test aus mit den Werten, die von der Methode erzeugeWortMitWortLaenge zurückgegeben werden.
     * @param text
     * text für den Test
     * @param laenge
     * länge für den Test
     */
    void testeMitMethodeAlsDatenQuelle( String text, int laenge ) {     	
    	assertTrue( text.length() == laenge );    	
    }

    /**
     * Methode, die Testwerte produziert
     * @return
     * Werte, die für die Testmethode verwendet werden
     */
	private static void erzeugeWortMitWortLaenge() {
    }

    /**
     * Durch Komma getrennte Werte zum Testen verwenden
     * @param text
     * text für Test
     * @param laenge
     * Länge für Test
     */
    void testeMitCSVAlsDatenQuelle( String text, int laenge ) { 
    	assertTrue( text.length() == laenge ); // Juhu: String::length funktioniert!!!
    }
    
}
