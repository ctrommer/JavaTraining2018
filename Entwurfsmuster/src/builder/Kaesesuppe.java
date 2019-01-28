package builder;

/**
 * Hat zusaetzlich das optionale Feld:
 * kaese
 *
 */
public class Kaesesuppe extends Suppe{
	
	private final int kaese;
	
	public static class Builder extends Suppe.Builder<Builder> {
		
		private int kaese = 0;
		
		public Builder(int wasser) {
			super(wasser);
		}

		public Builder kaese( int kaese ) {
			this.kaese = kaese;
			return this;
		}

		@Override
		Kaesesuppe build() {
			return new Kaesesuppe( this );
		}

		@Override
		protected Builder self() {
			return this;
		}		
	}

	public Kaesesuppe(Builder builder) {
		super(builder);
		this.kaese = builder.kaese;
	}

	@Override
	public String toString() {
		return "Kaesesuppe [kaese=" + kaese + ", toString()=" + super.toString() + "]";
	}

	public static void main(String[] args) {
		Kaesesuppe kaesesuppe = new Kaesesuppe.Builder(50).fleisch(5).kaese(45).build();
		System.out.println(kaesesuppe);
	}

}
