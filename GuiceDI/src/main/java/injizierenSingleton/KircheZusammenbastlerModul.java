package injizierenSingleton;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class KircheZusammenbastlerModul extends AbstractModule {

	@Override
	protected void configure() {
		bind( SingletonAufKlassenebene.class )
					.to( SingletonAufKlassenebeneImpl.class );
		bind( SingletonAufKonfigurationsEbene.class )
					.to( SingletonAufKonfigurationsEbeneImpl.class )
					.in( Singleton.class );
	}

	@Provides @Singleton
	public SingletonAufMethodenEbene zurVerfuegungStellenSingletonAufMethodenEbene() {
		return new SingletonAufMethodenEbeneImpl();
	}

}
