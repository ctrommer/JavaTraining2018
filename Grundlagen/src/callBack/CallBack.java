package callBack;

import java.util.function.Consumer;

/**
 * Besserer Name wäre: CallAfter
 *
 */
public class CallBack {


	public static void main(String[] args) {
		
		StringHelfer stringHelfer = new StringHelfer();
		
		Consumer<Double> callBack = zahl -> 	// besserer Name für callBack: call After
		{ 
			for ( int index = 1; index <= zahl; index++ ) { 
				System.out.print("!");
			}
		};
			
		stringHelfer.textLaengeZumQuadratUndDamitAufrufen("Hallo", callBack );
		
	}

}