package training;

import java.util.Optional;

public class Person {

	private String beruf;
	private Optional<Integer> vielleichtGewicht = Optional.empty();
	
	public Person(String beruf) {
		super();
		this.beruf = beruf;
	}

	public String getBeruf() {
		return beruf;
	}

	public void setBeruf(String beruf) {
		this.beruf = beruf;
	}

	public Optional<Integer> getVielleichtGewicht() {
		return vielleichtGewicht;
	}

	public void setVielleichtGewicht(Optional<Integer> vielleichtGewicht) {
		this.vielleichtGewicht = vielleichtGewicht;
	}

}
