package begriffe;

/**
 * Erzeugt eine Klasse die nach dem Erzeugen nicht mehr verändert werden kann. 
 * Sie hat ein Feld das mutable ist und eins, dass immutable ist.
 */
public class ImmutableTrainer {

	public String string;
	public StringBuilder stringBuilder;

	public ImmutableTrainer(String string, StringBuilder stringBuilder) {
		this.string = string;
		this.stringBuilder = stringBuilder;
	}

	public String getString() {					
		return string;
	}

	public StringBuilder getStringBuilder() {
		return stringBuilder;
	}

	public void setString(String string) {
		this.string = string;
	}

	public void setStringBuilder(StringBuilder stringBuilder) {
		this.stringBuilder = stringBuilder;
	}


}

