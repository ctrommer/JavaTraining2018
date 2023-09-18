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
	public class InnereKlasse {
		int summeDerErreichbarenZahlen() {
			return (aeussereZahl + aeussereStaticZahl); 
		}		
	}
	
	/**
	 * Statische innere Klasse, die zeigt, auf welche Elemente der aeusseren Klasse sie zugreifen darf.
	 * Mit Methode, die die Summe der Zahlen, auf die sie zugreifen darf zurueck gibt.
	 */
	public static class StatischeInnereKlasse {
		public int summeDerErreichbarenZahlen() {
			return (aeussereStaticZahl); 
		}
	}

	/**
	 * Lokale innere Klasse, die zeigt, auf welche Elemente der aeusseren Klasse sie zugreifen darf.
	 * Mit Methode, die die Summe der Zahlen, auf die die innere Klasse zugreifen darf zurueck gibt.
	 */
	Integer methodeMitLokalerInnereKlasse() {
		final class LokaleInnereKlasse {
			public int summeDerErreichbarenZahlen() {
				return (aeussereZahl + aeussereStaticZahl); 
			}
		}
		
		LokaleInnereKlasse lokaleInnereKlasse = new LokaleInnereKlasse();
		return lokaleInnereKlasse.summeDerErreichbarenZahlen();
	}
	
	/**
	 * Erzeuge innere Klasse und rufe deren Methode auf, die die Summe
	 * der erreichbaren Zahlen zurueck gibt.
	 * @return
	 * Summe der erreichbaren Zahlen 
	 */
	public Integer summeDerVonInnererKlasseErreichbarenZahlen() {
		InnererKlasseTrainer aeussereKlasse = new InnererKlasseTrainer();
		InnererKlasseTrainer.InnereKlasse innereKlasse = aeussereKlasse.new InnereKlasse();
 
		return innereKlasse.summeDerErreichbarenZahlen();		
	}

	/**
	 * Erzeuge statische innere Klasse und rufe deren Methode auf, die die Summe
	 * der erreichbaren Zahlen zurueck gibt.
	 * @return
	 * Summe der erreichbaren Zahlen 
	 */
	public Integer summeDerVonStatischerInnererKlasseErreichbarenZahlen() {
		InnererKlasseTrainer.StatischeInnereKlasse statischeInnereKlasse = new InnererKlasseTrainer.StatischeInnereKlasse();		
		return statischeInnereKlasse.summeDerErreichbarenZahlen();		
	}

	/**
	 * Rufe Methode auf, die Objekt von lokaler innerer Klasse erzeugt
	 * und die Summe der von der lokalen inneren Klasse erreichbaren
	 * Zahlen ausgibt.
	 * @return
	 * Summe der erreichbaren Zahlen 
	 */
	public Integer summeDerVonLokalerInnererKlasseErreichbarenZahlen() {
		return methodeMitLokalerInnereKlasse();		
	}
	
	@DisplayName("Werden die von der inneren Klasse erreichbaren Zahlen der Summe hinzugefuegt?")
	@Test
	public void test01() {
		assertEquals(
				3, 
				summeDerVonInnererKlasseErreichbarenZahlen());		
	}
	
	@DisplayName("Werden die von der statischen inneren Klasse erreichbaren Zahlen der Summe hinzugefuegt?")
	@Test
	public void test02() {
		assertEquals(
				2, 
				summeDerVonStatischerInnererKlasseErreichbarenZahlen());		
	}	

	@DisplayName("Werden die von der lokalen inneren Klasse erreichbaren Zahlen der Summe hinzugefuegt?")
	@Test
	public void test03() {
		assertEquals(
				3, 
				summeDerVonLokalerInnererKlasseErreichbarenZahlen());		
	}
	
}
