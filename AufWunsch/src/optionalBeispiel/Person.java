package optionalBeispiel;

import java.util.Optional;

public class Person {
	
	private String name;
	private Optional<Integer> vielleichtGewicht = Optional.empty();
	
	public Person(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}

	public Optional<Integer> getVielleichtGewicht() {
		return vielleichtGewicht;
	}

	public void setVielleichtGewicht(Optional<Integer> vielleichtGewicht) {
		this.vielleichtGewicht = vielleichtGewicht;
	}

}
