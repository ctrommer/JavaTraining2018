package test.mitJUnit5;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import main.Wochentag;

public class MitParameterTest {

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void testeZahlen(int zahl) {
    	assertNotNull(zahl);
    }

    @ParameterizedTest
    @EnumSource(value = Wochentag.class, names = {"MONTAG", "DIENSTAG"})
    void testeEnum( Wochentag wochentag ) {
    	assertNotNull(wochentag);
    }

    @ParameterizedTest
    @MethodSource("erzeugeWortMitWortLaenge")
    void testeMitMethodeAlsDatenQuelle(String text, int laenge) {     	
    	assertTrue(text.length() == laenge);    	
    }
     
    @SuppressWarnings("unused")
	private static Stream<Arguments> erzeugeWortMitWortLaenge() {
    	return Stream.of(
    		Arguments.of("Hello", 5),
    		Arguments.of("Welt", 4));
    }
    
    @ParameterizedTest
    @CsvSource({ "Hallo, 5", "Welt, 4", "'wenn Kommma, dann so', 20" })
    void testeMitCSVAlsDatenQuelle(String text, int laenge) { 
    	assertTrue(text.length() == laenge ); // Juhu: String::length funktioniert!!!
    }
    
}
