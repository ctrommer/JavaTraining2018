package comparatorBeispiel;

public class Person {
	
    private final String name;
    private final Integer alter;

    public Person(String name, Integer alter) {
		this.name = name;
		this.alter = alter;
	}    
    
    public Person(String name, Integer alter, String vorname ) {
		this.name = name;
		this.alter = alter;
	}
    

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + alter + "]";
	}

	public String getName() { return name; }	
    public Integer getAlter() { return alter; }    
}
