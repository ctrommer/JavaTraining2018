package training;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Mitarbeiter {
	private String name;
	private static List<Mitarbeiter> bestenMitarbeiter = new ArrayList<>();

	public Mitarbeiter(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name ;
	}
	
	public static void fuegeBestenMitarbeiterHinzu( Mitarbeiter mitarbeiter ) {
		bestenMitarbeiter.add(mitarbeiter);
	}
	
	public static List<Mitarbeiter> getBestenMitarbeiter() {
		return new ArrayList<Mitarbeiter>( bestenMitarbeiter );
	}

	public void gebeNameAus() {
		System.out.println(name);
	}
	
	public void nameZuGrossbuchstaben() {
		name = name.toUpperCase(Locale.GERMAN);
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mitarbeiter other = (Mitarbeiter) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
