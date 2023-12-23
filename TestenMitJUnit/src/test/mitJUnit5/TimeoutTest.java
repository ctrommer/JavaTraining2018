package test.mitJUnit5;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;

import org.junit.jupiter.api.Test;

public class TimeoutTest {
    /**
     * Wenn der Test nicht abbricht, ist der Rechner zu schnell geworden ;-)
     */
    @Test
    void testeTimeoutMitAbbruch() {
    	System.out.println("Timeout mit Abbruch:");
    	assertTimeoutPreemptively( 
    						Duration.ofMillis( 1 ), 
    						() -> brauchtLange("x") );
    }
    
    @Test
    void testeTimeoutOhneAbbruch() {
    	System.out.println("Timeout aber macht weiter:");
        assertTimeout( 
        		Duration.ofMillis(1), 
        		() -> brauchtLange("y") );
    }

    public void brauchtLange( String ausgabe ) {
		for ( int index1 = 1; index1 <= 30; index1++ ) {
			System.out.print( index1 + ": " );
			for ( int index2 = 1; index2 <= 300; index2++ ) {			
				System.out.print( ausgabe );
			}
			System.out.println("");
		}			
    }
}
