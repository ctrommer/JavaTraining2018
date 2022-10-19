package wohinInjizieren;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

public class Haus {
	
	/**
	 * Injiziere: 1. Stelle
	 */
	private Tuer tuer;

	/**
	 * Injiziere: 2. Stelle
	 */
	private final Fenster fenster;
	
	/**
	 * Injiziere: 3. Stelle
	 */
	private Wand wand;
	
	/**
	 * Injiziere mit Defaultwert
	 * "Defaultwert fuer Name des Hauses: Skyfall"
	 * Ueberschreibe dann mit 
	 * "Injizierter Wert fuer Name des Hauses"
	 */
	private String name;
	
	/**
	 * Injiziere mit Defaultwert 42,
	 * der nicht ueberschreiben wird.
	 */
	private Integer nummer;

	public Haus(Fenster fenster) {
		this.fenster = fenster;
	}

	public void setWand(Wand wand) {
		this.wand = wand;
	}
	
	public void setName( String name ) {
		this.name = name;		
	}

	public void setNummer( Integer nummer) {
		this.nummer = nummer;
	}
	
	@Override
	public String toString() {
		return "Haus [tuer=" + tuer + ", fenster=" + fenster + ", wand=" + wand + ", name=" + name + ", nummer="
				+ nummer + "]";
	}

	public static Haus erzeugeHausMitGuice() {
		return null;
	}

}
