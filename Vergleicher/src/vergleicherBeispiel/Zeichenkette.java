package vergleicherBeispiel;

public class Zeichenkette{
	
	String text;
	
	public Zeichenkette(String text) {
		this.text = text;
	}
	
	public static final Vergleicher<Zeichenkette> GROSS_KLEIN_SCHEIBUNG_IGNORIERENDER_VERGLEICHER
															= new GrossKleinschreibungIgnorierenderVergleicher(); 

	private static class GrossKleinschreibungIgnorierenderVergleicher implements Vergleicher<Zeichenkette> {
		@Override
		public int vergleiche( Zeichenkette z1, Zeichenkette z2 ) {
			return z1.text.compareToIgnoreCase(z2.text);
		}
	}
	
}
