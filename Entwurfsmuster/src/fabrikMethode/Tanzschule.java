package fabrikMethode;

/**
 * Eine Tanzschule verwendet in einem Workshop Tanzlehrer. Eine SalsaTanzschule verwendet SalsaTanzlehrer. 
 * Tanzlehrer und SalsaTanzlehrer sollen mit dem Entwurfsmuster Fabrikmethode erzeugt werden.
 *
 */
public class Tanzschule {
	protected Tanzlehrer erzeugeTanzlehrer() {		// 1. Bedingung: Methode, die Objekt erzeugt
		return new Tanzlehrer();
	}

	public String workshopDurchfuehren() {
		Tanzlehrer tanzlehrer = erzeugeTanzlehrer(); // 2. Bedingung: Erzeuger-Methode wird in der Klasse selbst verwendet 
		return tanzlehrer.unterrichte();		
	}

}
