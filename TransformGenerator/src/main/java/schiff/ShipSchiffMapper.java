package schiff;

// Methoden einf�gen, die den Start der Konvertierung und das Ende der Konvertierung als LocalDateTime f�r Quelle und Ziel setzen.

public abstract class ShipSchiffMapper {

	/**
	 * 1 kg = 2.205 LBS
	 */
	private static final double LBS_ZU_KG_FAKTOR = 2.205;
	
	public Schiff shipZuSchiff(Ship ship) {
		return null;
	}

	public Ship schiffZuShip(Schiff schiff) {
		return null;
	}
}
