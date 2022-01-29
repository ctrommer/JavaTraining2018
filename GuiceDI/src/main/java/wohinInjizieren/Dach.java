package wohinInjizieren;

public class Dach {
	private final String text;

	public Dach(String text) {
		this.text = text;
	}
	
	public Dach() {
		this.text = "injiziertes Dach";
	}

	@Override
	public String toString() {
		return "Dach [text=" + text + "]";
	}

}
