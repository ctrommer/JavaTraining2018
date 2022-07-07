package strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Predicate;

public class Haus {
	private Integer marktpreis;
	private Integer buchwert;
	private Integer jahresMieteinnahmen;

	public Haus(Integer marktpreis, Integer buchwert, Integer jahresMieteinnahmen) {
		this.marktpreis = marktpreis;
		this.buchwert = buchwert;
		this.jahresMieteinnahmen = jahresMieteinnahmen;
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
		// Methodensignatur NICHT aendern!
		return  "Haus ist guenstig"; // "Haus ist teuer"
	}

	/**
	 * Erzeugt ein Haus und bewertet es nach zwei verschiedenen Strategieen: nach dem Buchwert und nach den Mieteinnahmen.
	 */
	public static void main(String[] args) {

		// Haus wird mit der Buchwertstrategie geprüft Buchwert > Marktwert
		Haus einfamilienHaus = new Haus(250_000, 300_000, 20_000);
		
		// Haus wird mit der Mieteinnahmenstrategie geprüft Jahresmieteinnahmen * 10 > Marktpreis
		Haus mehrfamilienHaus = new Haus(250_000, 300_000, 20_000);

		// !!! ab hier nichts ändern, auch nicht Methtodensignatur von istHauspreisGuenstig.
		assertEquals("Haus ist guenstig", einfamilienHaus.istHauspreisGuenstig());
		assertEquals("Haus ist teuer", mehrfamilienHaus.istHauspreisGuenstig());
		System.out.println("Erfolgreich beendet.");
	}	

}
