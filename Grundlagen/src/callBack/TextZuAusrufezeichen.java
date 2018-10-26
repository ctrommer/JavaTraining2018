package callBack;

import java.util.function.Consumer;

public class TextZuAusrufezeichen {

	/**
	 * Erzeugt einen callBack, der x Ausrufezeichen ausgibt und verwendet diesen f�r einen 
	 * {@link StringHelfer}.   
	 * @param args
	 */
	public static void main(String[] args) {
		
		Consumer<Double> callBack = zahl -> 	// besserer Name f�r callBack: call After
		{ 
			for ( int index = 1; index <= zahl; index++ ) { 
				System.out.print("!");
			}
		};
			
		StringHelfer stringHelfer = new StringHelfer();
		stringHelfer.textLaengeZumQuadratUndDamitAufrufen("Hallo", callBack );
		
	}

}