package builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * Pizza mit Belag als SCHINKEN, PILZE, ZWIEBELN, PFEFFER, WUERSTCHEN.
 *
 */
public abstract class Pizza {
	public enum Belag { SCHINKEN, PILZE, ZWIEBELN, PFEFFER, WUERSTCHEN }
	final Set<Belag> belaege;

	abstract static class Builder<T extends Builder<T>> {
		EnumSet<Belag> belaege = EnumSet.noneOf(Belag.class);
		public T fuegeBelagHinzu( Belag belag ) {
			belaege.add( Objects.requireNonNull(belag) );
			return self();
		}
		abstract Pizza build();

		// Unterklassen müssen diese Klasse überschreiben und this zurückgeben.
		protected abstract T self();
	}
	Pizza( Builder<?> builder ) {
		belaege = builder.belaege.clone();
	}
}
