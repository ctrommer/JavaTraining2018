package employee;

public class Division {
    private int id;
    private String name;
    
	public Division(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Division() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
