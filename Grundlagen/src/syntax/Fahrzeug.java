package syntax;

public abstract class Fahrzeug {
	private int gewicht;

	public Fahrzeug( int gewicht ) {
		this.gewicht = gewicht;
	}

	@Override
	public String toString() {
		return "Fahrzeug [gewicht=" + gewicht + "]";
	}

}
