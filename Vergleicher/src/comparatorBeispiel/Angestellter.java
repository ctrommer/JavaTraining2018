package comparatorBeispiel;

public class Angestellter implements Comparable<Angestellter>{
	Integer gehalt;
	
	public Angestellter(Integer gehalt) {
		super();
		this.gehalt = gehalt;
	}

	@Override
	public String toString() {
		return "Angestellter [gehalt=" + gehalt + "]";
	}	
	
	@Override
	public int compareTo(Angestellter o) {
		return gehalt.compareTo(o.gehalt);
	}
}
