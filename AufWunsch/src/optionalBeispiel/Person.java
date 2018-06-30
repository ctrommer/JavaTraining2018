package optionalBeispiel;

import java.util.Optional;

public class Person {

	String name;
	Optional<Integer> vielleichtGewicht;
	
	public Person(String name, Optional<Integer> vielleichtGewicht) {
		this.name = name;
		this.vielleichtGewicht = vielleichtGewicht;
	}
	public String getName() {
		return name;
	}
	public Optional<Integer> getVielleichtGewicht() {
		return vielleichtGewicht;
	}
}
