package fabrikMethode;

public class SalsaTanzschule extends Tanzschule {	

	@Override
	protected Tanzlehrer erzeugeTanzlehrer() {		// 3. Bedingung: Erzeuger-Methode wird �berschrieben.
		return new SalsaTanzlehrer();
	}
	
}
