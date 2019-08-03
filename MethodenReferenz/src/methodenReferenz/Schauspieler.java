package methodenReferenz;

import java.util.ArrayList;
import java.util.List;

public class Schauspieler {
	String text;
	List<Mitarbeiter> fans = new ArrayList<Mitarbeiter>();
	public Schauspieler(String text) {
		this.text = text;
	}

	public void verabschieden( Mitarbeiter mitarbeiter ) {
		System.out.println(text + " " + mitarbeiter );
	}

	public void fanHinzufuegen( Mitarbeiter mitarbeiter ) {
		fans.add(mitarbeiter);
	}

	public List<Mitarbeiter> getFans() {
		return fans;
	}
}
