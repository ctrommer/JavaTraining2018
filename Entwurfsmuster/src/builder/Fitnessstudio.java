package builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * Es kann diese Traininsmöglichkeiten geben:
 * FREIHANTEL, GERAETE, KURSE, AUSDAUER
 *
 */
public class Fitnessstudio {
	public enum Trainingsmoeglichkeit { FREIHANTEL, GERAETE, KURSE, AUSDAUER };
	final Set<Trainingsmoeglichkeit> trainingsmoeglichkeiten;
	
	public static class Builder {
		EnumSet<Trainingsmoeglichkeit> trainingsmoeglichkeiten = EnumSet.noneOf(Trainingsmoeglichkeit.class);
		
		public Builder fuegeTrainingsartHinzu( Trainingsmoeglichkeit trainingsart ) {
			trainingsmoeglichkeiten.add(Objects.requireNonNull(trainingsart));
			return this;
		}
		
		public Fitnessstudio build() {
			return new Fitnessstudio(this);
		}
	}

	public Fitnessstudio(Builder builder) {
		this.trainingsmoeglichkeiten = builder.trainingsmoeglichkeiten.clone();
	}

	@Override
	public String toString() {
		return "Fitnessstudio [trainingsarten=" + trainingsmoeglichkeiten + "]";
	}

	public static void main(String[] args) {
		Fitnessstudio fitnessstudio = new Fitnessstudio.Builder().fuegeTrainingsartHinzu(Trainingsmoeglichkeit.GERAETE).fuegeTrainingsartHinzu(Trainingsmoeglichkeit.KURSE).build();
		System.out.println(fitnessstudio);
	}

}
