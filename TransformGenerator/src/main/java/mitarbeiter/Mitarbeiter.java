package mitarbeiter;

import java.util.List;

public class Mitarbeiter {
	private String name;
	private Mitarbeiter boss;
	private List<Mitarbeiter> team;
	
	public Mitarbeiter() {
		super();
	}

	public Mitarbeiter(String name, Mitarbeiter boss, List<Mitarbeiter> team) {
		super();
		this.name = name;
		this.boss = boss;
		this.team = team;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Mitarbeiter getBoss() {
		return boss;
	}

	public void setBoss(Mitarbeiter boss) {
		this.boss = boss;
	}

	public List<Mitarbeiter> getTeam() {
		return team;
	}

	public void setTeam(List<Mitarbeiter> team) {
		this.team = team;
	}

}
