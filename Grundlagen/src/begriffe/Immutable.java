package begriffe;

public final class Immutable {					// Declare the class as final so it can’t be extended.

	private final String string;				// Make all fields private so that direct access is not allowed.
	private final StringBuilder stringBuilder;	// Make all mutable fields final so that it’s value can be assigned only once.

	public Immutable(String string, StringBuilder stringBuilder) {	// Initialize all the fields via a constructor performing deep copy.
		this.string = string;
		this.stringBuilder = new StringBuilder( stringBuilder );
	}
	
	// Don’t provide setter methods for variables ... oder andere Methoden, die den Wert der Variable verändern

	public String getString() {					
		return string;
	}

	public StringBuilder getStringBuilder() {	// Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.
		return new StringBuilder( stringBuilder.toString() );
	}

	@Override
	public String toString() {
		return "ImmutableDemo [string=" + string + ", stringBuilder=" + stringBuilder + "]";
	}

	public static void main(String[] args) {
		
		Immutable immutableDemo = new Immutable("erster", new StringBuilder("zweiter"));
		
		String string = immutableDemo.getString();
		StringBuilder stringBuilder = immutableDemo.getStringBuilder();
		
		string = "Hallo";
		stringBuilder = new StringBuilder("Welt");
		
		System.out.println(string + " " + stringBuilder);
		System.out.println(immutableDemo.toString());
	}

}
