package fabrikMethode;

/**
 * Eine Tanzschule verwendet in einem Workshop Tanzlehrer. Eine SalsaTanzschule verwendet SalsaTanzlehrer. 
 * Tanzlehrer und SalsaTanzlehrer sollen mit dem Entwurfsmuster Fabrikmethode erzeugt werden.
 *
 */
public class Tanzschule {

	public String workshopDurchfuehren() {
		Tanzlehrer tanzlehrer = null;
		return tanzlehrer.unterrichte();		
	}

}
