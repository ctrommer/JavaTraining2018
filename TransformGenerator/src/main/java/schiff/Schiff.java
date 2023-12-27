package schiff;

public class Schiff {
	
	private String name;
	private String farbe;
	private double gewichtInKg;
	
	public Schiff( String name, String farbe, double gewichtInKg ) {
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

}
