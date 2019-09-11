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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gehalt == null) ? 0 : gehalt.hashCode());
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
		Angestellter other = (Angestellter) obj;
		if (gehalt == null) {
			if (other.gehalt != null)
				return false;
		} else if (!gehalt.equals(other.gehalt))
			return false;
		return true;
	}
	
}
