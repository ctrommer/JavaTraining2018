package wohinInjizieren;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class Haus {
	
	@Inject
	private Tuer tuer;

	private final Fenster fenster;
	
	private Wand wand;
	
	private Dach dach = new Dach("Default Wert von optionalem Dach");

	@Inject
	public Haus(Fenster fenster) {
		this.fenster = fenster;
	}

	@Inject
	public void setWand(Wand wand) {
		this.wand = wand;
	}

	@Inject( optional = true )
	public void setDach(Dach dach) {
		this.dach = dach;
	}

	@Override
	public String toString() {
		return "Haus [tuer=" + tuer + ", fenster=" + fenster + ", wand=" + wand + ", dach=" + dach + "]";
	}

	public static void main( String[] args ) {
		Injector hausZusammenbastler = Guice.createInjector(new HausZusammenbastlerModul());
		Haus haus = hausZusammenbastler.getInstance(Haus.class);		
		System.out.println(haus.toString());
	}

}
