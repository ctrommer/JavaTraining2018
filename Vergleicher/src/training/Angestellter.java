package training;

public class Angestellter {
	Integer gehalt;
	
	public Angestellter( Integer gehalt ) {
		super();
		this.gehalt = gehalt;
	}

	@Override
	public String toString() {
		return "Angestellter [gehalt=" + gehalt + "]";
	}	
	
}
