package fabrikMethode;

/**
 * Eine Tanzschule verwendet in einem Workshop Tanzlehrer. Eine SalsaTanzschule verwendet SalsaTanzlehrer. 
 * Tanzlehrer und SalsaTanzlehrer sollen mit dem Entwurfsmuster Fabrikmethode erzeugt werden.
 * 
 * - Eine Fabrikmethode ist ... siehe 
 * 		https://refactoring.guru/design-patterns/factory-method
 * 
 * Abgrenzung:
 * 
 * - Wenn eine Klasse eine statische Methode hat, um Instanzen von ihr selbst zu erzeugen, ist das noch keine Fabrikmethode.
 *  
 * 	- Fabrikmethode vs Abstract Factory siehe 
 * 		https://stackoverflow.com/questions/5739611/what-are-the-differences-between-abstract-factory-and-factory-design-patterns?answertab=trending#tab-top  
 *
 */
public class Tanzschule {
	protected Tanzlehrer erzeugeTanzlehrer() {
		return new Tanzlehrer();
	}

	public String workshopDurchfuehren() {
		Tanzlehrer tanzlehrer = erzeugeTanzlehrer();
		return tanzlehrer.unterrichte();		
	}

}
