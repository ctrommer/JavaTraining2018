package modul.gebrauchtAnderes;

import modul.wirdGebraucht.IntrinsichenWertBerechner;

public class Main {

	public static void main(String[] args) {
		IntrinsichenWertBerechner intrinsichenWertBerechner = new IntrinsichenWertBerechner();
		System.out.println( intrinsichenWertBerechner.berechneWert( 10, 20 ) );
	}

}
