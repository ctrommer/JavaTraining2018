package batch;

import org.springframework.batch.item.ItemProcessor;

import model.Mitarbeiter;

public class Mitarbeiterverarbeiter2 implements ItemProcessor<Mitarbeiter, Mitarbeiter> {
	/**
	 * 1 kg = 2.205 LBS
	 */
	private static final double KG_ZU_LBS_FAKTOR = 2.205;

	/**
	 * Hier ist die Stelle, wo man Business-Logik verwendet. In diesem Fall ist die einzige
	 * Business Logik die Umrechnung von KG in LBS.
	 */
	@Override
	public Mitarbeiter process( Mitarbeiter mitarbeiter ) throws Exception {

		double gewichtInLBS = mitarbeiter.getGewicht() * KG_ZU_LBS_FAKTOR;
		mitarbeiter.setGewicht( ( int ) Math.round(gewichtInLBS) );
		
		System.out.println( "Processing..." + mitarbeiter );

		return mitarbeiter;
	}
}
