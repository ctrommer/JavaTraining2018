package injizierenMitBinding;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class AbteilungZusammenbastlerModule extends AbstractModule {

	@Override
	protected void configure() {
		try {
			// funktioniert nur fuer boolean im Konstruktor, nicht fuer Boolean ( sic )
			bind(Boolean.class).toInstance(true);
			bind(Weihnachtsfeier.class).toConstructor(Weihnachtsfeier.class.getConstructor(Boolean.TYPE));
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

		bind(Abteilungsleiter.class).to(AbteilungsleiterImpl.class);
		
		bind(Adresse.class).annotatedWith(Names.named("AdresseImpl")).to(AdresseImpl.class);

		bindConstant().annotatedWith(Names.named("Abteilungsname")).to("Forschung und Entw");

        bind(String.class).annotatedWith(Names.named("SpitzName")).toInstance("Nerds");
	}
}
