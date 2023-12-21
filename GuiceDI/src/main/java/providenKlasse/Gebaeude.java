package providenKlasse;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

class Gebaeude {
	private Hausmeister hausmeister;
	
	@Inject
	public Gebaeude( Hausmeister hausmeister ) {
	   this.hausmeister = hausmeister;
	}
	
	@Override
	public String toString() {
		return "Gebaeude [hausmeister=" + hausmeister + "]";
	}
	
	public static Gebaeude erzeugeGebaeudeMitGuice() {
		Injector gebaeudeZusammenBastler = Guice.createInjector( new GebaeudeZusammenbastlerModule() );
		return gebaeudeZusammenBastler.getInstance( Gebaeude.class );
	}
}