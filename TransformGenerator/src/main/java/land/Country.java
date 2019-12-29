package land;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Country {
	private String name;
	private Integer population;
	private City capital;
	private Date lastSoccerWorldChampionshipTitle;
	private List<City> cities = new ArrayList<City>();

	public Country(String name, Integer population, City capital, Date lastSoccerWorldChampionshipTitle,
			List<City> cities) {
		super();
		this.name = name;
		this.population = population;
		this.capital = capital;
		this.lastSoccerWorldChampionshipTitle = lastSoccerWorldChampionshipTitle;
		this.cities = cities;
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
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}

	public City getCapital() {
		return capital;
	}

	public void setCapital(City capital) {
		this.capital = capital;
	}

	public Date getLastSoccerWorldChampionshipTitle() {
		return lastSoccerWorldChampionshipTitle;
	}

	public void setLastSoccerWorldChampionshipTitle(Date lastSoccerWorldChampionshipTitle) {
		this.lastSoccerWorldChampionshipTitle = lastSoccerWorldChampionshipTitle;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
}
