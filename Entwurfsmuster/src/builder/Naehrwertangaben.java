package builder;

/**
 * Naehrwertangaben mit den Pflichtparametern:
 * 
 * eiweis
 * kohlehydrate
 * fett
 * 
 * und den optionalen Parametern:
 * 
 * vegan
 * glutenfrei
 * 
 */
public class Naehrwertangaben {
	private final int eiweis;
	private final int kohlehydrate;
	private final int fett;
	
	private final boolean vegan;
	private final boolean glutenfrei;
	
	/**
	 * Builder mit den gleichen Pflichtparametern und optionalen Parametern wie 
	 * Naehrwertangaben.
	 *
	 */
	public static class Builder {
		private final int eiweis;
		private final int kohlehydrate;
		private final int fett;
		
		private boolean vegan = false;
		private boolean glutenfrei = false;
		
		public Builder( int eiweis, int kohlehydrate, int fett ) {
			this.eiweis = eiweis;
			this.kohlehydrate = kohlehydrate;
			this.fett = fett;
		}
		
		public Builder vegan( boolean vegan ) {
			this.vegan = vegan;
			return this;
		}
		
		public Builder glutenfrei( boolean glutenfrei ) {
			this.glutenfrei = glutenfrei;
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
	 * Der Builder beinhaltet die Pflichtparameter. Er kann auch zusätzliche optionale Parameter haben.
	 */
	private Naehrwertangaben( Builder builder ) {
		this.eiweis = builder.eiweis;
		this.kohlehydrate = builder.kohlehydrate;
		this.fett = builder.fett;
		this.vegan = builder.vegan;
		this.glutenfrei = builder.glutenfrei;
	}

	@Override
	public String toString() {
		return "Naehrwertangaben [eiweis=" + eiweis + ", kohlehydrate=" + kohlehydrate + ", fett=" + fett + ", vegan="
				+ vegan + ", glutenfrei=" + glutenfrei + "]";
	}

	public static void main(String[] args) {

		// Erzeuge Quark-Builder nur mit den Pflichtparametern. Erzeuge Quark mit dem Quark-Builder.
		Naehrwertangaben.Builder quarkBuilder = new Naehrwertangaben.Builder(11, 5, 3);
		Naehrwertangaben quark = quarkBuilder.build();
		System.out.println(quark);
		
		// Erzeuge Ei-Builder und setze dann die Optionalen Parameter. Erzeuge ein Ei mit dem Quark-Builder. 
		Naehrwertangaben.Builder eiBuilder = new Naehrwertangaben.Builder(11, 5, 3);
		eiBuilder.vegan(true);
		eiBuilder.glutenfrei(true);
		Naehrwertangaben ei = eiBuilder.build();
		System.out.println(ei);
		
		// Erzeuge Apfel-Builder mit den Pflicht-Parametern und optionalen Parametern.
		// Erzeuge einen Apfel mit dem Apfel-Builder
		Naehrwertangaben.Builder apfelBuilder = new Naehrwertangaben.Builder(11, 5, 3).vegan(true).glutenfrei(true);
		Naehrwertangaben apfel = apfelBuilder.build();
		System.out.println(apfel);		

		// Erzeuge Pudding in einem Rutsch.
		Naehrwertangaben pudding = new Naehrwertangaben.Builder(11, 5, 3).vegan(true).glutenfrei(true).build();
		System.out.println(pudding);
	}

}
