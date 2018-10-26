package datumUndZeit;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LocalDateTimeBeispiel {
	
	public static void main(String[] args) {		
		gebeAktuelleZeitAus();		
		gebeAktuellesDatumInDreiMonatenAus();
	}

	private static void gebeAktuelleZeitAus() {
		LocalDateTime localDateTime = LocalDateTime.now();		
		System.out.println(localDateTime);
	}
	
	private static void gebeAktuellesDatumInDreiMonatenAus() {
		LocalDate localDate = LocalDate.now().plusMonths(3);
		System.out.println(localDate);
	}
}
