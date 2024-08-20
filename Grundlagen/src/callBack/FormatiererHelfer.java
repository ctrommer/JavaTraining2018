package callBack;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public class FormatiererHelfer {
	
	/**
	 * Nimmt das Geburtsdatum und ruft damit einen Callback auf, 
	 * um das Alter formatiert auszugeben.
	 * 
	 * @param geburtsDatum
	 * @param alterFormatierer
	 * @return das Alter formatiert
	 */
	public static String geburtsdatumZuAlterFormatieren( 
												LocalDate geburtsDatum, 
												Function<Integer, String> alterFormatierer ) {
		LocalDate now = LocalDate.now();
		Period between = Period.between( geburtsDatum, now );
		int years = between.getYears();
		
		return alterFormatierer.apply(years);		
	}

}
