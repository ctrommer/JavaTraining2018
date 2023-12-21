package injizierenSingleton;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class Kirche {
	
	// Injiziere als Singleton: 1. Syntax
	@Inject
	private SingletonAufKlassenebene singletonAufKlassenebene;

	// Injiziere als Singleton: 2. Syntax
	@Inject
	private SingletonAufKonfigurationsEbene singletonAufKonfigurationsEbene;

	// Injiziere als Singleton: 3. Syntax
	@Inject
	private SingletonAufMethodenEbene singletonAufMethodenEbene;
	
	@Override
	public String toString() {
		return "Kirche [singletonAufKlassenebene=" + singletonAufKlassenebene + ", singletonAufKonfigurationsEbene="
				+ singletonAufKonfigurationsEbene + ", singletonAufMethodenEbene=" + singletonAufMethodenEbene + "]";
	}

	public static Kirche erzeugeKircheMitGuice() {
		Injector kircheZusammenbastler = Guice.createInjector( new KircheZusammenbastlerModul() );		
		return kircheZusammenbastler.getInstance( Kirche.class );
	}

}
