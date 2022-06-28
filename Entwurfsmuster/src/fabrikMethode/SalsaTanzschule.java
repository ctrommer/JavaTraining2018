package fabrikMethode;

public class SalsaTanzschule extends Tanzschule {

	@Override
	protected Tanzlehrer erzeugeTanzlehrer() {
		return new SalsaTanzlehrer();
	}
	
}
