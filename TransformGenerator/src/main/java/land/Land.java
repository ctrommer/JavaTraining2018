package land;

import java.util.ArrayList;
import java.util.List;

public class Land {
	
	private String name;
	private Integer einwohnerzahl;
	private Stadt hauptstadt;
	private String letzterFussballWMTietel;
	private List<Stadt> staedte = new ArrayList<Stadt>();

	
	public Land(String name, Integer einwohnerzahl, Stadt hauptstadt, String letzterFussballWMTietel, List<Stadt> staedte) {
		super();
		this.name = name;
		this.einwohnerzahl = einwohnerzahl;
		this.hauptstadt = hauptstadt;
		this.letzterFussballWMTietel = letzterFussballWMTietel;
		this.staedte = staedte;
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
	public Integer getEinwohnerzahl() {
		return einwohnerzahl;
	}
	public void setEinwohnerzahl(Integer einwohnerzahl) {
		this.einwohnerzahl = einwohnerzahl;
	}

	public Stadt getHauptstadt() {
		return hauptstadt;
	}

	public void setHauptstadt(Stadt hauptstadt) {
		this.hauptstadt = hauptstadt;
	}

	public String getLetzterFussballWMTietel() {
		return letzterFussballWMTietel;
	}

	public void setLetzterFussballWMTietel(String letzterFussballWMTietel) {
		this.letzterFussballWMTietel = letzterFussballWMTietel;
	}

	public List<Stadt> getStaedte() {
		return staedte;
	}

	public void setStaedte(List<Stadt> staedte) {
		this.staedte = staedte;
	}
	
}
