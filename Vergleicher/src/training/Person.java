package training;

public class Person {

    private final String name;
    private final Integer alter;

    public Person( String name, Integer alter ) {
		this.name = name;
		this.alter = alter;
	}    

    public Person( String name, Integer alter, String vorname ) {
		this.name = name;
		this.alter = alter;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + alter + "]";
	}

	public String getName() { return name; }	
    public Integer getAlter() { return alter; }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alter == null) ? 0 : alter.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (alter == null) {
			if (other.alter != null)
				return false;
		} else if (!alter.equals(other.alter))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}    
}
