package builder;

/**
 * Zusaetzlicher optionaler boolscher Parameter:
 * sosseDrin
 *
 */
public class Calzone extends Pizza {
	
	private final boolean sosseDrin;
	
	public static class Builder extends Pizza.Builder<Builder> {
		private boolean sosseDrin = false;
		
		public Builder sosseDrin() {
			sosseDrin = true;
			return this;
		}

		@Override
		Calzone build() {
			return new Calzone(this);
		}

		@Override
		protected Builder self() {
			return this;
		}		
	}

	public Calzone(Builder builder) {
		super(builder);
		sosseDrin = builder.sosseDrin;
	}

	@Override
	public String toString() {
		return "Calzone [sosseDrin=" + sosseDrin + ", belaege=" + belaege + "]";
	}

}
