package abstrakteFabrik;

/**
 * Eine KampfsportSchule verwendet in einem Workshop Trainer und Trainingsgeraet. Diese sollen über das
 * Entwurfsmuster Fabrik erzeugt werden.
 *
 */

public class KampfsportSchule {
	private Fabrik fabrik;

	public KampfsportSchule(Fabrik fabrik) {
		this.fabrik = fabrik;
	}

	public String workshopDurchfuehren() {
		Trainer trainer = fabrik.erzeugeTrainer();
		Trainingsgeraet trainingsgeraet = fabrik.erzeugeTrainingsgeraet();
		
		return trainer.unterrichte( trainingsgeraet ); 
	}
}
