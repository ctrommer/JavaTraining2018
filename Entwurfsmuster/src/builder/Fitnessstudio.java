package builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * Als Trainingsmoeglichkeit:
 * FREIHANTEL, GERAETE, KURSE, AUSDAUER
 *
 */
public class Fitnessstudio {
	public enum Trainingsmoeglichkeit { FREIHANTEL, GERAETE, KURSE, AUSDAUER };
	private final Set<Trainingsmoeglichkeit> trainingsmoeglichkeiten;
	
	public static class Builder {
		private final EnumSet<Trainingsmoeglichkeit> trainingsmoeglichkeiten = EnumSet.noneOf(Trainingsmoeglichkeit.class);
		
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
		return "Fitnessstudio [trainingsmoeglichkeiten=" + trainingsmoeglichkeiten + "]";
	}

}
