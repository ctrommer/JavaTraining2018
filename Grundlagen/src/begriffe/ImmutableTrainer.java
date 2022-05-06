package begriffe;

/**
 * Erzeugt eine Klasse die nach dem Erzeugen nicht mehr ver�ndert werden kann. 
 * Sie hat ein Feld das mutable ist und eins, dass immutable ist.
 */
public class ImmutableTrainer {					// Declare the class as final so it can not be extended.

	public String string;				// Make all fields private so that direct access is not allowed.
	public StringBuilder stringBuilder;	// Make all fields final so that it's value can be assigned only once.

	public ImmutableTrainer(String string, StringBuilder stringBuilder) {	// Initialize all the fields via a constructor performing deep copy.
		this.string = string;
		this.stringBuilder = stringBuilder;
	}
	
	// Do not provide setter methods for variables ... oder andere Methoden, die den Wert der Variable veraendern

	public String getString() {					
		return string;
	}

	public StringBuilder getStringBuilder() {	// Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.
		return stringBuilder;
	}

	public void setString(String string) {
		this.string = string;
	}

	public void setStringBuilder(StringBuilder stringBuilder) {
		this.stringBuilder = stringBuilder;
	}


}

