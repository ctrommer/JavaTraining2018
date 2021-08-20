package kundenverwaltung;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table( name = "kunde" )
public class Kunde {

	@Id
    @Column(name = "idKunde" )	
	private int idKunde;
	
	private int geburtsjahr;
	
	
	/**
	 * Embedded, also keine eigene Tabelle
	 */
	private Name name;
	
	/**
	 * One to One mit Foreign key
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idEhepartner", referencedColumnName  = "idKunde")	
	private Ehepartner ehepartner;

	@Transient
	private String nichtZuSpeichern;
	
	public Kunde() {
	}

	public Kunde(int idKunde, int geburtsjahr, Name name, Ehepartner ehepartner) {
		super();
		this.idKunde = idKunde;
		this.geburtsjahr = geburtsjahr;
		this.name = name;
		this.ehepartner = ehepartner;
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

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getNichtZuSpeichern() {
		return nichtZuSpeichern;
	}

	public void setNichtZuSpeichern(String nichtZuSpeichern) {
		this.nichtZuSpeichern = nichtZuSpeichern;
	}

	public Ehepartner getEhepartner() {
		return ehepartner;
	}

	public void setEhepartner(Ehepartner ehepartner) {
		this.ehepartner = ehepartner;
	}

	@Override
	public String toString() {
		return "Kunde [idKunde=" + idKunde + ", geburtsjahr=" + geburtsjahr + ", name=" + name + ", ehepartner="
				+ ehepartner + ", nichtZuSpeichern=" + nichtZuSpeichern + "]";
	}

}
