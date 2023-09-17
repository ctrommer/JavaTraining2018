package datumUndZeit;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DatumUndZeitTrainer {

	private String datumUndZeitAlsString() {
		LocalDateTime localDateTime = LocalDateTime.now();		
		return localDateTime.toString();
	}

	@Test
	@DisplayName("Werden aktuelles Datum und aktuelle Uhrzeit richtig umgewandelt?")
	public void test01() {
		LocalDateTime vorTest = LocalDateTime.now();
		String datumUndZeitAlsString = datumUndZeitAlsString();
		LocalDateTime testErgebnis = LocalDateTime.parse( datumUndZeitAlsString );
		LocalDateTime nachTest = LocalDateTime.now();
		Assertions.assertTrue( vorTest.isBefore( testErgebnis ) );
		Assertions.assertTrue( nachTest.isAfter( testErgebnis ) );
	}

	private String aktuellesDatumInDreiMonaten() {
		LocalDate localDate = LocalDate.now().plusMonths(3);
		return localDate.toString();
	}

	@Test
	@DisplayName("Wird das aktuelle Datum in drei Monaten richtig ermittelt?")
	public void test02() {
		LocalDate testErgebnis = LocalDate.parse( aktuellesDatumInDreiMonaten() );
		Assertions.assertEquals(
				LocalDate.now().plusMonths(3).getMonth(), 
				testErgebnis.getMonth());
	}

	/**
	 * Erzeuegt Dauer von einer Minute und gibt sie in Sekunden zurueck.
	 * @return 
	 * Anzahl Sekunden in Minute
	 */
	public Long dauerVonEinerMinuteInSekunden() {
		Duration duration = Duration.ofMinutes(1);
		return duration.getSeconds();		
	}
	
	@Test
	@DisplayName("Dauer einer Minute in Sekunden.")
	public void test03() {
		Assertions.assertEquals(60, dauerVonEinerMinuteInSekunden());		
	}
	
}
