package kundenverwaltung;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "kunde" )
public class Kunde {

	@Id
    @Column(name = "idKunde" )	
	private int idKunde;
	
	private int geburtsjahr;
	private String name;
	
	public Kunde() {
	}
    	
	public int getIdKunde() {
		return idKunde;
	}

	public void setIdKunde(int idKunde) {
		this.idKunde = idKunde;
	}

	public int getGeburtsjahr() {
		return geburtsjahr;
	}

	public void setGeburtsjahr(int geburtsjahr) {
		this.geburtsjahr = geburtsjahr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
