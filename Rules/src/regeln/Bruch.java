package regeln;

public class Bruch {
	int zaehler;
	int nenner;
	public Bruch(int zaehler, int nenner) {
		if ( nenner == 0 ) {
			throw new IllegalArgumentException("Nenner darf nicht null sein.");
		}
		this.zaehler = zaehler;
		this.nenner = nenner;
	}
	
	@Override
	public String toString() {
		return "Bruch [zaehler=" + zaehler + ", nenner=" + nenner + "]";
	}
	
}
