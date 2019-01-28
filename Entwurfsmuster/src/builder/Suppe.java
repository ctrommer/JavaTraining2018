package builder;

/**
 * 
 * Abstrakte Basisklasse für Suppen.
 * Mit dem Pflichtfeld:
 * wasser
 * und den optionalen Feldern:
 * gemuese
 * fleisch
 * 
 */
public abstract class Suppe {
	private final int wasser;
	
	private final int gemuese;
	private final int fleisch;
	
	abstract static class Builder<T extends Builder<T>> {
		private final int wasser;

		private int gemuese = 0;
		private int fleisch = 0;
		
		public Builder(int wasser) {
			this.wasser = wasser;			
		}

		public T gemuese( int gemuese ) {
			this.gemuese = gemuese;
			return self();
		}

		public T fleisch( int fleisch ) {
			this.fleisch = fleisch;
			return self();
		}
		abstract Suppe build();		
		protected abstract T self();
	}

	public Suppe(Builder<?> builder) {
		this.wasser = builder.wasser;
		this.gemuese = builder.gemuese;
		this.fleisch = builder.fleisch;
	}
	
	@Override
	public String toString() {
		return "Suppe [wasser=" + wasser + ", gemuese=" + gemuese + ", fleisch=" + fleisch + "]";
	}

}
