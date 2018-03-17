package vergleicherBeispiel;

public class Zeichenkette{
	
	String text;
	
	public Zeichenkette(String text) {
		this.text = text;
	}
	
	public static final Vergleicher<Zeichenkette> GROSS_KLEIN_SCHEIBUNG_IGNORIERENDER_VERGLEICHER= new GrossKleinschreibungIgnorierenderVergleicher(); 

	private static class GrossKleinschreibungIgnorierenderVergleicher implements Vergleicher<Zeichenkette> {
		@Override
		public int vergleiche(Zeichenkette t1, Zeichenkette t2) {
			return t1.text.compareToIgnoreCase(t2.text);
		}
	}
	
}
