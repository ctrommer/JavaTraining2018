package builder;

/**
 * 
 * Abstrakte Basisklasse fuer Suppen.
 * Mit dem Pflichtfeld:
 * wasser
 * und dem optionalen Feld:
 * gemuese
 * 
 */
public abstract class Suppe {

	private int wasser;	
	private int gemuese;

	@Override
	public String toString() {
		return "Suppe [wasser=" + wasser + ", gemuese=" + gemuese + "]";
	}

}
