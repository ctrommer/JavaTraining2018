package vergleicherUebung;

public class MyZeichenkette{
	
	String text;

	public MyZeichenkette(String text) {
		this.text = text;
	}

	public final static MyVergleicher<MyZeichenkette> GROSS_KLEIN_VERGLEICHER = new GrossKleinVergleicher(); 

	private static class GrossKleinVergleicher implements MyVergleicher<MyZeichenkette> {
		@Override
		public int vergleiche(MyZeichenkette t1, MyZeichenkette t2) {
			return t1.text.compareTo(t2.text);
		}
	}
	
}
