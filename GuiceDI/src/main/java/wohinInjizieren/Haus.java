package wohinInjizieren;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

public class Haus {
	
	@Inject
	private Tuer tuer;

	private final Fenster fenster;
	
	private Wand wand;
	
	private String name = "Defaultwert fuer Name des Hauses: Skyfall";
	
	private Integer nummer = 42;

	@Inject
	public Haus(Fenster fenster) {
		this.fenster = fenster;
	}

	@Inject
	public void setWand(Wand wand) {
		this.wand = wand;
	}
	
	@Inject( optional = true )
	public void setName( @Named("Hausname") String name ) {
		this.name = name;		
	}

	@Inject( optional = true )
	public void setNummer( @Named("Hausnummer") Integer nummer) {
		this.nummer = nummer;
	}
	
	@Override
	public String toString() {
		return "Haus [tuer=" + tuer + ", fenster=" + fenster + ", wand=" + wand + ", name=" + name + ", nummer="
				+ nummer + "]";
	}

	public static Haus erzeugeHausMitGuice() {
		Injector hausZusammenbastler = Guice.createInjector(new HausZusammenbastlerModul());
		return hausZusammenbastler.getInstance(Haus.class);
	}

}
