package land;

import java.util.Date;

public class Country {
	private String name;
	private int population;
	private Capital capital;
	private Date lastSoccerWorldChampionshipTitle;

	public Country(String name, int population, Capital capital, Date lastSoccerWorldChampionshipTitle) {
		super();
		this.name = name;
		this.population = population;
		this.capital = capital;
		this.lastSoccerWorldChampionshipTitle = lastSoccerWorldChampionshipTitle;
	}

	public Country() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}

	public Capital getCapital() {
		return capital;
	}

	public void setCapital(Capital capital) {
		this.capital = capital;
	}

	public Date getLastSoccerWorldChampionshipTitle() {
		return lastSoccerWorldChampionshipTitle;
	}

	public void setLastSoccerWorldChampionshipTitle(Date lastSoccerWorldChampionshipTitle) {
		this.lastSoccerWorldChampionshipTitle = lastSoccerWorldChampionshipTitle;
	}
	
}
