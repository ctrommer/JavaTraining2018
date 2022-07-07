package strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Predicate;

public class Haus {
	private Integer marktpreis;
	private Integer buchwert;
	private Integer jahresMieteinnahmen;
	private Predicate<Haus> bewertungsstrategie;

	public Haus(Integer marktpreis, Integer buchwert, Integer jahresMieteinnahmen,
			Predicate<Haus> bewertungsstrategie) {
		this.marktpreis = marktpreis;
		this.buchwert = buchwert;
		this.jahresMieteinnahmen = jahresMieteinnahmen;
		this.bewertungsstrategie = bewertungsstrategie;
	}

	public Integer getMarktpreis() {
		return marktpreis;
	}

	public Integer getBuchwert() {
		return buchwert;
	}

	public Integer getJahresMieteinnahmen() {
		return jahresMieteinnahmen;
	}

	/**
	 * Verwendet die Bewertungsstragie und gibt dann aus, ob das Haus guenstig oder teuer ist.
	 */
	public String istHauspreisGuenstig( ) {		
		return bewertungsstrategie.test(this) ? "Haus ist guenstig" : "Haus ist teuer";
	}

	/**
	 * Erzeugt ein Haus und bewertet es nach zwei verschiedenen Strategieen: nach dem Buchwert und nach den Mieteinnahmen.
	 */
	public static void main(String[] args) {

		// Haus wird mit der Buchwertstrategie geprüft Buchwert > Marktwert
		Predicate<Haus> bewertenNachBuchwertStrategie = ( haus ) -> haus.getBuchwert() > haus.getMarktpreis();
		Haus einfamilienHaus = new Haus(250_000, 300_000, 20_000, bewertenNachBuchwertStrategie);
		
		// Haus wird mit der Mieteinnahmenstrategie geprüft Jahresmieteinnahmen * 10 > Marktpreis
		Predicate<Haus> bewertenNachMieteinnahmenStrategie 
			= haus -> haus.getJahresMieteinnahmen() * 10 > haus.getMarktpreis();
		Haus mehrfamilienHaus = new Haus(250_000, 300_000, 20_000, bewertenNachMieteinnahmenStrategie);

		// !!! ab hier nichts ändern, auch nicht Methtodensignatur von istHauspreisGuenstig.
		assertEquals("Haus ist guenstig", einfamilienHaus.istHauspreisGuenstig());
		assertEquals("Haus ist teuer", mehrfamilienHaus.istHauspreisGuenstig());
		System.out.println("Erfolgreich beendet.");
	}	

}
