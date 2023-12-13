package builder;

/**
 * Naehrwertangaben mit dem Pflichtparameter:
 * 
 * Kalorien
 * 
 * und den optionalen Parametern 
 * 
 * Eiweis
 * Kohlehydrate
 * Fett
 * vegan
 * 
 */
public class Naehrwertangaben {
	int kalorien;
	int eiweis;
	int kohlehydrate;
	int fett;	
	boolean vegan;

	@Override
	public String toString() {
		return "Naehrwertangaben [kalorien=" + kalorien + ", eiweis=" 
				+ eiweis + ", kohlehydrate=" + kohlehydrate
				+ ", fett=" + fett + ", vegan=" + vegan + "]";
	}

}
