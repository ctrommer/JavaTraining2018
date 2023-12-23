package batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import model.Mitarbeiter;

public class FeldZuMitarbeiterMapper implements FieldSetMapper<Mitarbeiter> {

	
	@Override
	public Mitarbeiter mapFieldSet( FieldSet fieldSet ) throws BindException {

		Mitarbeiter mitarbeiter = new Mitarbeiter();
		mitarbeiter.setMitarbeiterId( fieldSet.readString( 0 ) );
		mitarbeiter.setMitarbeiterName( fieldSet.readString( 1 ) );
		mitarbeiter.setGewicht( fieldSet.readInt( 2 ) );
		return mitarbeiter;
	}

}