package builder;

/**
 * Hat zusaetzlich das optionale Feld:
 * kaese
 *
 */
public class Kaesesuppe extends Suppe{
	
	private int kaese;

	@Override
	public String toString() {
		return "Kaesesuppe [kaese=" + kaese + ", toString()=" + super.toString() + "]";
	}
}
