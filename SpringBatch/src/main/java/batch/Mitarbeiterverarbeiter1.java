package batch;

import org.springframework.batch.item.ItemProcessor;

import model.Mitarbeiter;

public class Mitarbeiterverarbeiter1 implements ItemProcessor<Mitarbeiter, Mitarbeiter> {

	/**
	 * Hier ist die Stelle, wo man Business-Logik verwendet.
	 */
	@Override
	public Mitarbeiter process( Mitarbeiter mitarbeiter ) throws Exception {

		System.out.println( "Processing..." + mitarbeiter );

		return mitarbeiter;
	}

}