package providenAnnotation;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

class Wald {
	private Foerster foerster;

	@Inject
	public Wald( Foerster foerster) {
		this.foerster = foerster;
	}
	
	@Override
	public String toString() {
		return "Wald [foerster=" + foerster + "]";
	}

	public static Wald erzeugeWaldMitGuice() {
		Injector waldZusammenbastler = Guice.createInjector(new WaldModule());
	    return waldZusammenbastler.getInstance(Wald.class);
	}
}