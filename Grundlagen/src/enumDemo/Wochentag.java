package enumDemo;

/**
 * Wochentage, die man mit Text konstruiert, deren Text man setzen kann und deren Text man abfragen kann.
 * Für Dienstag die Methode überschreiben, die den Text ermittelt.
 *
 */
public enum Wochentag {
	
	MONTAG("Montag"), 
	DIENSTAG("Dienstag") {
			@Override
			public String getText() {
				return "Tuesday";
			} 
		},
	MITTWOCH("Mittwoch");
	
	private String text;

	private Wochentag(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
