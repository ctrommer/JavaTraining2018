package datumUndZeit;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class LocalDateTimeBeispiel {
	
	public static void main(String[] args) {		
		gebeAktuelleZeitAus();		
		gebeAktuellesDatumInDreiMonatenAus();
		gebeDauerVonEinerMinuteInSekundenAus();
	}

	private static void gebeAktuelleZeitAus() {
	}
	
	private static void gebeAktuellesDatumInDreiMonatenAus() {
	}

	/**
	 * Erzeuege Dauer von einer Minute.
	 * Gebe die Dauer in Sekunen aus.
	 */
	private static void gebeDauerVonEinerMinuteInSekundenAus() {
		Duration duration = Duration.ofMinutes(1);
		System.out.println(duration.getSeconds());
		
	}
}
