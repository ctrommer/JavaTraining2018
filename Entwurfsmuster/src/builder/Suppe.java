package builder;

/**
 * 
 * Abstrakte Basisklasse fuer Suppen.
 * Mit dem Pflichtfeld:
 * wasser
 * und dem optionalen Feld:
 * gemuese
 * 
 */
public abstract class Suppe {
	private final int wasser;
	
	private final int gemuese;
	
	abstract static class Builder<T extends Builder<T>> {
		private final int wasser;

		private int gemuese = 0;
		
		public Builder(int wasser) {
			this.wasser = wasser;			
		}

		public T gemuese( int gemuese ) {
			this.gemuese = gemuese;
			return self();
		}

		abstract Suppe build();		
		protected abstract T self();
	}

	public Suppe(Builder<?> builder) {
		this.wasser = builder.wasser;
		this.gemuese = builder.gemuese;
	}

	@Override
	public String toString() {
		return "Suppe [wasser=" + wasser + ", gemuese=" + gemuese + "]";
	}

}
