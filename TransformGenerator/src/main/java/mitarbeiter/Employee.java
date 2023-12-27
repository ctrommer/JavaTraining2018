package mitarbeiter;

import java.util.List;

public class Employee {
	private String name;
	private Employee boss;
	private List<Employee> team;
	
	public Employee() {
		super();
	}

	public Employee( String name, Employee boss, List<Employee> team ) {
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

	public Employee getBoss() {
		return boss;
	}

	public void setBoss(Employee boss) {
		this.boss = boss;
	}

	public List<Employee> getTeam() {
		return team;
	}

	public void setTeam(List<Employee> team) {
		this.team = team;
	}
	
}
