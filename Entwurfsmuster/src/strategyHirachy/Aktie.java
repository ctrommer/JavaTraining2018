package strategyHirachy;

public class Aktie extends Investition {

	public Aktie(SteuernAbziehStrategie steuernAbzieher) {
		super(steuernAbzieher);
	}

	/**
	 * Erzeugt eine Aktie und zieht die Steuern mit einer {@link KapitalertragssteuerAbziehStrategie } ab.
	 * 
	 * Zeigt dass auch ein Lambda reicht für eine Strategie.
	 * 
	 * @param args
	 */
	public static void main( String[] args ) {
		Aktie aktie = new Aktie(new KapitalertragssteuerAbziehStrategie());
		
		System.out.println(aktie.zieheSteuernAb(100L));
		
		aktie.setSteuernAbziehStrategie(geldBetrag -> Math.round( geldBetrag * 0.25) );
		
		System.out.println(aktie.zieheSteuernAb(100L));
	}	
	
}
