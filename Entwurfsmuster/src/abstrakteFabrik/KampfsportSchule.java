package abstrakteFabrik;

/**
 * Eine KampfsportSchule verwendet in einem Workshop Trainer und Trainingsgeraet. Diese sollen über das
 * Entwurfsmuster Fabrik erzeugt werden.
 *
 */

public class KampfsportSchule {

	public KampfsportSchule(Fabrik fabrik) {
	}

	public String workshopDurchfuehren() {
		Trainer trainer = null;
		Trainingsgeraet trainingsgeraet = null;
		
		return trainer.unterrichte( trainingsgeraet ); 
	}
}
