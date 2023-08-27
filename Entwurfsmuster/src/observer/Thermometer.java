package observer;

import java.util.ArrayList;

/**
 * Fachbegriff: Observable ( Beobachter ), aber auch: Publisher
 * 
 * 
 * Ein Thermometer misst die Temperatur. Sobald sie sich veraendert, werden die
 * Klimaanlage und die Heizung benachrichtigt. 
 * 
 * Implementiere dieses System mit dem Entwurfsmuster Beobachter.
 *
 */
public class Thermometer {
	
	/**
	 * Fachbegriff: Observer ( Beobachter ), aber auch : Subscriber 
	 */
	

	/**
	 * Das Messen der Temperatur soll durch eine Schleife simuliert werden, die einen Wert 
	 * von 17 Grad bis 21 Grad hoch zaehlt. Wenn sich die Temperatur veraendert, sollen
	 * Heizung und Klimaanlage auf dem Bildschirm ausgeben, ob sie an oder aus sind.
	 */
	public void temperaturAenderungSimulieren() {
		for ( int temperatur = 17; temperatur <= 21; temperatur++ ) {
			System.out.println("Es ist " + temperatur + " Grad.");
		}
	}
	
	/** 
	 *  
	 * Die Heizung ist an, wenn es kaelter als 18 Grad wird 
	 * -> Ausgabe:
	 * "Heizung geht an." : "Heizung bleibt aus."
	 * 
	 * Die Klimaanlage laeuft, wenn es waermer als 20 Grad wird.
	 * -> Ausgabe:
	 * "Klimaanlage geht an." : "Klimaanlage bleibt aus." 
	 */
	public void simuliereClientFuerTest() {
		Thermometer thermometer = new Thermometer();

		
		thermometer.temperaturAenderungSimulieren();
	}

}
