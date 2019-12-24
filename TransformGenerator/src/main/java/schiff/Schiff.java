package schiff;

import java.time.LocalDateTime;

public class Schiff {
	
	private String name;
	private String farbe;
	private double gewichtInKg;
	private LocalDateTime startKonvertierung;
	private LocalDateTime endeKonvertierung;	
	
	public Schiff(String name, String farbe, double gewichtInKg) {
		super();
		this.name = name;
		this.farbe = farbe;
		this.gewichtInKg = gewichtInKg;
	}
	
	public Schiff() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFarbe() {
		return farbe;
	}
	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}
	public double getGewichtInKg() {
		return gewichtInKg;
	}
	public void setGewichtInKg(double gewichtInKg) {
		this.gewichtInKg = gewichtInKg;
	}

	public LocalDateTime getStartKonvertierung() {
		return startKonvertierung;
	}

	public void setStartKonvertierung(LocalDateTime startKonvertierung) {
		this.startKonvertierung = startKonvertierung;
	}

	public LocalDateTime getEndeKonvertierung() {
		return endeKonvertierung;
	}

	public void setEndeKonvertierung(LocalDateTime endeKonvertierung) {
		this.endeKonvertierung = endeKonvertierung;
	}
		
}
