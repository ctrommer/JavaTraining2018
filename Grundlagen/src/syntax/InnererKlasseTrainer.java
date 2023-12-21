package syntax;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InnererKlasseTrainer {
	
	private int aeussereZahl = 1;
	private static int aeussereStaticZahl = 2;

	/**
	 * Innere Klasse, die zeigt, auf welche Elemente der ausseren Klasse sie zugreifen darf.
	 * Mit Methode, die die Summe der Zahlen, auf die sie zugreifen darf zurueck gibt.
	 */
	
	/**
	 * Statische innere Klasse, die zeigt, auf welche Elemente der aeusseren Klasse sie zugreifen darf.
	 * Mit Methode, die die Summe der Zahlen, auf die sie zugreifen darf zurueck gibt.
	 */

	/**
	 * Lokale innere Klasse, die zeigt, auf welche Elemente der aeusseren Klasse sie zugreifen darf.
	 * Mit Methode, die die Summe der Zahlen, auf die die innere Klasse zugreifen darf zurueck gibt.
	 */
	
	/**
	 * Erzeuge innere Klasse und rufe deren Methode auf, die die Summe
	 * der erreichbaren Zahlen zurueck gibt.
	 * @return
	 * Summe der erreichbaren Zahlen 
	 */
	public Integer summeDerVonInnererKlasseErreichbarenZahlen() {
		return null;		
	}

	/**
	 * Erzeuge statische innere Klasse und rufe deren Methode auf, die die Summe
	 * der erreichbaren Zahlen zurueck gibt.
	 * @return
	 * Summe der erreichbaren Zahlen 
	 */
	public Integer summeDerVonStatischerInnererKlasseErreichbarenZahlen() {		
		return null;		
	}

	/**
	 * Rufe Methode auf, die Objekt von lokaler innerer Klasse erzeugt
	 * und die Summe der von der lokalen inneren Klasse erreichbaren
	 * Zahlen ausgibt.
	 * @return
	 * Summe der erreichbaren Zahlen 
	 */
	public Integer summeDerVonLokalerInnererKlasseErreichbarenZahlen() {
		return null;		
	}

	@DisplayName("Werden die von der inneren Klasse erreichbaren Zahlen der Summe hinzugefuegt?")
	@Test
	public void test01() {
		assertEquals(
				3, 
				summeDerVonInnererKlasseErreichbarenZahlen() );		
	}

	@DisplayName("Werden die von der statischen inneren Klasse erreichbaren Zahlen der Summe hinzugefuegt?")
	@Test
	public void test02() {
		assertEquals(
				2,
				summeDerVonStatischerInnererKlasseErreichbarenZahlen() );		
	}

	@DisplayName("Werden die von der lokalen inneren Klasse erreichbaren Zahlen der Summe hinzugefuegt?")
	@Test
	public void test03() {
		assertEquals(
				3, 
				summeDerVonLokalerInnererKlasseErreichbarenZahlen() );		
	}

}