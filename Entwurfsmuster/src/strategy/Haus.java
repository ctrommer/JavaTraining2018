package strategy;

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
	
	

}
