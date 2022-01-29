package injizierenSingleton;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class Kirche {
	
	@Inject
	private SingletonAufKlassenebene singletonAufKlassenebene;
	
	@Inject
	private SingletonAufKonfigurationsEbene singletonAufKonfigurationsEbene;
	
	@Inject
	private SingletonAufMethodenEbene singletonAufMethodenEbene;
	
	@Override
	public String toString() {
		return "Kirche [singletonAufKlassenebene=" + singletonAufKlassenebene + ", singletonAufKonfigurationsEbene="
				+ singletonAufKonfigurationsEbene + ", singletonAufMethodenEbene=" + singletonAufMethodenEbene + "]";
	}

	public static void main(String[] args) {
		Injector kircheZusammenbastler = Guice.createInjector(new KircheZusammenbastlerModul());
		
		Kirche kirche = kircheZusammenbastler.getInstance(Kirche.class);
		
		System.out.println(kirche);
	}

}
