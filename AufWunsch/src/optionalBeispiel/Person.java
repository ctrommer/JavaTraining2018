package optionalBeispiel;

import java.util.Optional;

public class Person {

	String name;
	
	public Person(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public Optional<Integer> getVielleichtGewicht() {
		Optional<Integer> vielleichtGewicht = Optional.of(100);
		return vielleichtGewicht;
	}
}
