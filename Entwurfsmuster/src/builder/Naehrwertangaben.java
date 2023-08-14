package builder;

/**
 * Naehrwertangaben mit dem Pflichtparameter:
 * 
 * Kalorien
 * 
 * und den optionalen Parametern 
 * 
 * Eiweis
 * Kohlehydrate
 * Fett
 * vegan
 * 
 */
public class Naehrwertangaben {
	private final int kalorien;
	private final int eiweis;
	private final int kohlehydrate;
	private final int fett;	
	private final boolean vegan;
	
	/**
	 * Builder mit den gleichen Pflichtparametern und optionalen Parametern wie 
	 * Naehrwertangaben.
	 *
	 */
	public static class Builder {
		private final int kalorien;
		private int eiweis;
		private int kohlehydrate;
		private int fett;
		
		private boolean vegan;
		
		public Builder( int kalorien ) {
			this.kalorien = kalorien;
		}
		
		public Builder eiweis( int eiweis ) {
			this.eiweis = eiweis;
			return this;
		}
		
		public Builder kohlehydrate( int kohlehydrate ) {
			this.kohlehydrate = kohlehydrate;
			return this;
		}
		
		public Builder fett( int fett ) {
			this.fett = fett;
			return this;
		}

		public Builder vegan( boolean vegan ) {
			this.vegan = vegan;
			return this;
		}
		
		/**
		 * Erzeugt Naehrwertangaben
		 * @return
		 * die neu erzeugten Naehrwertangaben
		 */
		public Naehrwertangaben build() {
			return new Naehrwertangaben(this);
		}
		
	}

	/**
	 * Konstruktor.
	 * @param builder
	 * Der Builder beinhaltet die Pflichtparameter. Er kann auch zus�tzliche optionale Parameter haben.
	 */
	private Naehrwertangaben( Builder builder ) {
		this.kalorien = builder.kalorien;
		this.eiweis = builder.eiweis;
		this.kohlehydrate = builder.kohlehydrate;
		this.fett = builder.fett;
		this.vegan = builder.vegan;
	}

	@Override
	public String toString() {
		return "Naehrwertangaben [kalorien=" + kalorien + ", eiweis=" + eiweis + ", kohlehydrate=" + kohlehydrate
				+ ", fett=" + fett + ", vegan=" + vegan + "]";
	}
	
}
