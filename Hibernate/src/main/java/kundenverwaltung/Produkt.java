package kundenverwaltung;

import java.util.List;

public class Produkt {
	int idProdukt;
	String bezeichnung;
	int preis;
	
	//@ManyToMany
	List<Kunde> kunden;
	
	public List<Kunde> getKunden() {
		return kunden;
	}

	public void setKunden( List<Kunde> kunden ) {
		this.kunden = kunden;
	}

	public Produkt() {
		super();
	}

	public int getIdProdukt() {
		return idProdukt;
	}

	public void setIdProdukt(int idProdukt) {
		this.idProdukt = idProdukt;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public int getPreis() {
		return preis;
	}

	public void setPreis(int preis) {
		this.preis = preis;
	}

	@Override
	public String toString() {
		return "Produkt [idProdukt=" + idProdukt + ", bezeichnung=" + bezeichnung + ", preis=" + preis + ", kunden="
				+ kunden + "]";
	}

}
