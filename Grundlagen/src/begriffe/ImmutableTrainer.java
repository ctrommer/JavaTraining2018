package begriffe;

/**
 * Erzeugt eine Klasse, die nach dem Erzeugen nicht mehr ver�ndert werden kann. 
 * Sie hat ein Feld das mutable ist und eins, dass immutable ist.
 */
public final class ImmutableTrainer {			// Declare the class as final so it can not be extended.

	private final String string;				// Make all fields private so that direct access is not allowed.
	private final StringBuilder stringBuilder;	// Make all fields final so that it's value can be assigned only once.

	// Initialize all the fields via a constructor performing deep copy.
	public ImmutableTrainer( String string, StringBuilder stringBuilder ) {
		this.string = string;
		this.stringBuilder = new StringBuilder( stringBuilder );
	}
	
	// Do not provide setter methods for variables ... oder andere Methoden, die den Wert der Variable veraendern
	public String getString() {					
		return string;
	}

	// Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.
	public StringBuilder getStringBuilder() {	
		return new StringBuilder( stringBuilder.toString() );
	}

}
