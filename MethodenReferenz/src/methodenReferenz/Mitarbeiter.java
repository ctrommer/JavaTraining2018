package methodenReferenz;

public class Mitarbeiter {
	String name;

	public Mitarbeiter(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name ;
	}
	
	public void gebeNameAus() {
		System.out.println(name);
	}

}
