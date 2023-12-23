package batch;

import org.springframework.batch.item.ItemProcessor;

import model.Mitarbeiter;

public class Mitarbeiterverarbeiter implements
		ItemProcessor<Mitarbeiter, Mitarbeiter> {

	@Override
	public Mitarbeiter process( Mitarbeiter mitarbeiter ) throws Exception {

		System.out.println( "Processing..." + mitarbeiter );
		System.out.println( mitarbeiter.getMitarbeiterName() );
		System.out.println( mitarbeiter.getGewicht() );
		return mitarbeiter;
	}

}