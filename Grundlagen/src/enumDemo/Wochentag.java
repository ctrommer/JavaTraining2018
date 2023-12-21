package enumDemo;

/**
 * <pre>
 * Wochentage, die man 
 *  mit Text konstruiert, 
 *  ( "Montag" "Dienstag" "Mittwoch" )
 *  deren Text man setzen kann und 
 *  deren Text man abfragen kann.
 * 
 * Fuer Dienstag die Methode ueberschreiben, 
 * die den Text ermittelt. Diese Methode soll 
 * Tuesday zurueckgeben.
 * <pre>
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

	private Wochentag( String text ) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText( String text ) {
		this.text = text;
	}
}
