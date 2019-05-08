package observer;

import java.util.ArrayList;

/**
 * Ein Thermometer misst die Temperatur. Sobald sie sich verändert, werden die Klimaanlage und die Heizung benachrichtigt. 
 * Die Klimaanlage läuft, wenn es wärmer als 20 Grad wird. Die Heizung ist an, wenn es kälter als 18 Grad wird. 
 * Implementiere dieses System mit dem Entwurfsmuster Beobachter. 
 * Das Messen der Temperatur soll durch eine Schleife simuliert werden, die einen Wert von 17 Grad bis 21 Grad hoch zählt. 
 * Wenn sich die Temperatur verändert, sollen Heizung und Klimaanlage auf dem Bildschirm ausgeben, ob sie an oder aus sind.
 *
 */
public class ThermometerObservable {
	@FunctionalInterface
	public interface Observer {
		void beobachte( int temperatur );
	}

	private final ArrayList<Observer> beobachterListe = new ArrayList<>();
	
	private void benachrichtigeBeobachter( int neueTemperatur ) {
		beobachterListe.forEach( beobachter -> beobachter.beobachte( neueTemperatur ) );		
	}
	
	public void fuegeBeobachterHinzu( Observer beobachter ) {
		beobachterListe.add(beobachter);	
	}

	public void temperaturErmitteln() {
		for ( int temperatur = 17; temperatur <= 21; temperatur++ ) {
			System.out.println("Es ist " + temperatur + " Grad.");
			benachrichtigeBeobachter(temperatur);			
		}
	}
	
	public static void main( String[] args ) {
		ThermometerObservable thermometerObservable = new ThermometerObservable();
		thermometerObservable.fuegeBeobachterHinzu(temperatur -> System.out.println(temperatur < 18 ?  "Heizung geht an." : "Heizung bleibt aus."));
		thermometerObservable.fuegeBeobachterHinzu(temperatur -> System.out.println(temperatur > 20 ?  "Klimaanlage geht an." : "Klimaanlage bleibt aus."));
		thermometerObservable.temperaturErmitteln();
	}

}
