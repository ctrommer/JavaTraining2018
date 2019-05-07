package strategyHirachy;

public class Immobilie extends Investition{

	public Immobilie(SteuernAbziehStrategie steuernAbzieher) {
		super(steuernAbzieher);
	}
	
	/**
	 * Erzeugt eine Aktie und zieht die Steuern mit der {@link EinkommensteuerAbziehStrategie } ab.
	 * @param args
	 */
	public static void main( String[] args ) {
		Immobilie immobilie = new Immobilie(new EinkommensteuerAbziehStrategie());
		System.out.println(immobilie.zieheSteuernAb(100L));
	}

}
