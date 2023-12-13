package strategy;

import java.util.function.Predicate;

public class Haus {
	private Integer marktpreis;
	private Integer buchwert;
	private Integer jahresMieteinnahmen;
	private Predicate<Haus> bewertungsstrategie;

	public Haus( Integer marktpreis, Integer buchwert, Integer jahresMieteinnahmen ) {
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
	 *  
	 * @return Wenn Bewertungsstrategie vorhanden ist "Haus ist guenstig" : "Haus ist teuer", 
	 * 	sonst "keine Bewertungsstrategie vorhanden"
	 */
	public String istHauspreisGuenstig( ) {		
		if ( bewertungsstrategie == null ) {
			return "keine Bewertungsstrategie vorhanden";
		}
		return bewertungsstrategie.test(this) ? "Haus ist guenstig" : "Haus ist teuer";
	}
	
	public Predicate<Haus> getBewertungsstrategie() {
		return bewertungsstrategie;
	}

	public void setBewertungsstrategie(Predicate<Haus> bewertungsstrategie) {
		this.bewertungsstrategie = bewertungsstrategie;
	}
}
