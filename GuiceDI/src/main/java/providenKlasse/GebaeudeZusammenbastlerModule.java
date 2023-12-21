package providenKlasse;

import com.google.inject.AbstractModule;

class GebaeudeZusammenbastlerModule extends AbstractModule {
	@Override
	protected void configure() {
		bind( Hausmeister.class ).toProvider( HausmeisterZurVerfuegungSteller.class );
	} 
}
