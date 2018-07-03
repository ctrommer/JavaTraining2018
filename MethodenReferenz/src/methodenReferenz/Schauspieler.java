package methodenReferenz;

public class Schauspieler {
	String text;
	public Schauspieler(String text) {
		this.text = text;
	}
	
	public void verabschieden( Mitarbeiter mitarbeiter ) {
		System.out.println(text + " " + mitarbeiter );
	}
	
}
