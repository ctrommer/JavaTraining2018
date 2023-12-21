package kundenverwaltung;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "ehepartner" )
public class Ehepartner {

	@Id
    @Column( name = "idKunde" )
	private int idKunde;
	
	/**
	 * One to One Beziehung mit Foreign key
	 */
	@OneToOne( mappedBy="ehepartner" )
	private Kunde kunde;
	
	private int hochzeitsjahr;

	public Ehepartner() {
	}

	public Ehepartner(
				int idKunde, 
				Kunde kunde, 
				int hochzeitsjahr) {
		super();
		this.idKunde = idKunde;
		this.kunde = kunde;
		this.hochzeitsjahr = hochzeitsjahr;
	}

	public int getIdKunde() {
		return idKunde;
	}

	public void setIdKunde( int idKunde ) {
		this.idKunde = idKunde;
	}


	public int getHochzeitsjahr() {
		return hochzeitsjahr;
	}

	public void setHochzeitsjahr( int hochzeitsjahr ) {
		this.hochzeitsjahr = hochzeitsjahr;
	}

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde( Kunde kunde ) {
		this.kunde = kunde;
	}

	@Override
	public String toString() {
		return "Ehepartner [idKunde=" + idKunde + ", hochzeitsjahr=" + hochzeitsjahr + "]";
	}
	
}
