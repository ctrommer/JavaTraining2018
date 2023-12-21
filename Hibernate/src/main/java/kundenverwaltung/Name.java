package kundenverwaltung;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table( name="kunde" )
public class Name {
	
	private String vorname;
	private String nachname;
	
	public Name() {
		super();
	}
	
	public Name( String vorname, String nachname ) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}
	public void setVorname( String vorname ) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname( String nachname ) {
		this.nachname = nachname;
	}
	@Override
	public String toString() {
		return "Name [vorname=" + vorname + ", nachname=" + nachname + "]";
	}

}
