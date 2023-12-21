package implementiertVonAnnotation;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class Praxis {
	private final Sprechstundenhilfe sprechstundenhilfe;

	@Inject
	public Praxis( Sprechstundenhilfe sprechstundenhilfe ) {
		this.sprechstundenhilfe = sprechstundenhilfe;
	}

	@Override
	public String toString() {
		return "Praxis [sprechstundenhilfe=" + sprechstundenhilfe + "]";
	}

	public static Praxis erzeugePraxisMitGuice() {
		Injector praxisZusammenbastler = Guice.createInjector( new PraxisZusammenbastlerModule() );
		return praxisZusammenbastler.getInstance( Praxis.class );		
	}

}
