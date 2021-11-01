package modul.serviceGebrauchtAnderes;

import modul.serviceWirdGebraucht.MyServiceClass;
import modul.serviceWirdGebraucht.MyServiceInterface;

public class ServiceVerwender {

	public static void main(String[] args) {
		MyServiceInterface myServiceInterface = new MyServiceClass();
		int ergebnis = myServiceInterface.plusDrei(3);
		System.out.println(ergebnis);
	}

}
