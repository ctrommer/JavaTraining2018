package model;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "mitarbeiter" )
public class Mitarbeiter {

	private String mitarbeiterId;
	private String mitarbeiterName;
	private int gewicht;
	
	@Override
	public String toString() {
		return "Mitarbeiter [mitarbeiterId=" + mitarbeiterId + ", mitarbeiterName=" + mitarbeiterName + ", gewicht="
				+ gewicht + "]";
	}
	public String getMitarbeiterId() {
		return mitarbeiterId;
	}
	public void setMitarbeiterId( String mitarbeiterId ) {
		this.mitarbeiterId = mitarbeiterId;
	}
	public String getMitarbeiterName() {
		return mitarbeiterName;
	}
	public void setMitarbeiterName( String mitarbeiterName ) {
		this.mitarbeiterName = mitarbeiterName;
	}
	public int getGewicht() {
		return gewicht;
	}
	public void setGewicht( int gewicht ) {
		this.gewicht = gewicht;
	}
}