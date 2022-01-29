package providenKlasse;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

class Gebaeude {
	private Hausmeister hausmeister;
	
	@Inject
	public Gebaeude( Hausmeister hausmeister) {
	   this.hausmeister = hausmeister;
	}

	public void gebeInfoAus(){
		System.out.println(hausmeister);
	} 
	
	public static void main(String[] args) {
		Injector gebaeudeZusammenBastler = Guice.createInjector(new GebaeudeZusammenbastlerModule());
		Gebaeude gebaeude = gebaeudeZusammenBastler.getInstance(Gebaeude.class);
		gebaeude.gebeInfoAus();
	}
}