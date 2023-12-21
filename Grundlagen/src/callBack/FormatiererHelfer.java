package callBack;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public class FormatiererHelfer {
	
	/**
	 * Nimmt das Geburtsjahr und ruft damit einen Callback auf, 
	 * um das Alter formatiert auszugeben.
	 * 
	 * @param geburtsJahr
	 * @param alterFormatierer
	 * @return das Alter formatiert
	 */
	public static String geburtsjahrZuAlterFormatieren( 
												LocalDate geburtsJahr, 
												Function<Integer, String> alterFormatierer ) {
		LocalDate now = LocalDate.now();
		Period between = Period.between( geburtsJahr, now );
		int years = between.getYears();
		
		return alterFormatierer.apply(years);		
	}

}
