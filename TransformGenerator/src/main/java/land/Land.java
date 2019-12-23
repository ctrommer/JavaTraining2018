package land;

public class Land {
	
	private String name;
	private int einwohnerzahl;
	private Hauptstadt hauptstadt;
	private String letzterFussballWMTietel;

	public Land(String name, int einwohnerzahl, Hauptstadt hauptstadt, String letzterFussballWMTietel) {
		super();
		this.name = name;
		this.einwohnerzahl = einwohnerzahl;
		this.hauptstadt = hauptstadt;
		this.letzterFussballWMTietel = letzterFussballWMTietel;
	}

	public Land() {
		super();
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public int getEinwohnerzahl() {
		return einwohnerzahl;
	}
	public void setEinwohnerzahl(int einwohnerzahl) {
		this.einwohnerzahl = einwohnerzahl;
	}

	public Hauptstadt getHauptstadt() {
		return hauptstadt;
	}

	public void setHauptstadt(Hauptstadt hauptstadt) {
		this.hauptstadt = hauptstadt;
	}

	public String getLetzterFussballWMTietel() {
		return letzterFussballWMTietel;
	}

	public void setLetzterFussballWMTietel(String letzterFussballWMTietel) {
		this.letzterFussballWMTietel = letzterFussballWMTietel;
	}
	
}
