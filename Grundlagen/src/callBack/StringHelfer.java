package callBack;

import java.util.function.Consumer;
import java.util.function.Function;

public class StringHelfer {
	public void textLaengeZumQuadratUndDamitAufrufen( String text, Consumer<Double> textAusgeber ) {

		double textLaengeZumQuadrat = Math.pow(text.length(), 2);
		
		textAusgeber.accept(textLaengeZumQuadrat);
		
	}

}
