package wohinInjizieren;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class HausZusammenbastlerModul extends AbstractModule {

	@Override
	protected void configure() {
		super.configure();
			bind( String.class )
					.annotatedWith( Names.named("Hausname") )
					.toInstance("Injizierter Wert fuer Name des Hauses");
	}
}