package vergleicherBeispiel;

public class Fussballer implements Comparable<Fussballer>{
	
	Integer nummer;

	public Fussballer( Integer nummer ) {
		this.nummer = nummer;
	}

	@Override
	public int compareTo(Fussballer o) {
		return this.nummer.compareTo(o.nummer);
	}

}
