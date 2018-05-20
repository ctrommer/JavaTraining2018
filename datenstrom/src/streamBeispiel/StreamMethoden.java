package streamBeispiel;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;



public class StreamMethoden {
	
	static List<String> personen = Arrays.asList( "Karl", "Anton", "John", "Klaus");

	public static void main(String[] args) {			
		personenAusgebenMitAnonymerInnererKlasseMitStream();
		personenDieMitKAnfangenAusgebenMitAnonymerInnererKlasse();
	}

	private static void personenAusgebenMitAnonymerInnererKlasseMitStream() {
		personen
		.stream()
		.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});
	}

	/**
	 * Gebe nur die Personen aus, deren Name mit "K" anfängt.
	 * 
	 * Verwende anonyme innere Klassen.
	 * 
	 */
	private static void personenDieMitKAnfangenAusgebenMitAnonymerInnererKlasse() {
		personen
			.stream()
			.filter(new Predicate<String>() {
				@Override
				public boolean test(String s) {
					return s.startsWith("K");
				}
			})
			.forEach(new Consumer<String>() {
				@Override
				public void accept(String t) {
					System.out.println(t);
				}
			});		
	}



}
