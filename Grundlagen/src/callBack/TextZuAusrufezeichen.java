package callBack;

import java.util.function.Consumer;

public class TextZuAusrufezeichen {

	/**
	 * Erzeugt einen callBack, der x Ausrufezeichen ausgibt und verwendet diesen für einen 
	 * {@link StringHelfer}.   
	 * @param args
	 */
	public static void main(String[] args) {
			
		StringHelfer stringHelfer = new StringHelfer();
		stringHelfer.textLaengeZumQuadratUndDamitAufrufen("Hallo" );
		
	}

}