package enumDemo;

public class EnumVerwender {

	public static void main(String[] args) {
		
		// Erzeuge die Wochentage Montag und Dienstag
		Wochentag mo = Wochentag.MONTAG;
		Wochentag di = Wochentag.DIENSTAG;
		
		// Pruefe, ob Wochentag ein Montag
		if ( mo == Wochentag.MONTAG) {
			System.out.println("Es ist ein Montag.");
		}
		
		// Gebe den Text von Montag und Dienstag aus.
		System.out.println(mo.getText());		
		System.out.println(di.getText());
	}

}
