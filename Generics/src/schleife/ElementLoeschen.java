package schleife;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class ElementLoeschen {
	static Collection<String> namenListe = new ArrayList<>();

	public static void main(String[] args) {
		namenListe.add("Uwe");
		namenListe.add("Karl");
		namenListe.add("Uta");

		elementAusListeLoeschen();
		elementAusListeLoeschenMitPredicate();
	}

	static void elementAusListeLoeschen() {
		
		System.out.println(namenListe);
	}
	
	static void elementAusListeLoeschenMitPredicate() {
		
		System.out.println(namenListe);
	}	
}
