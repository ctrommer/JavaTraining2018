package providenAnnotation;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

class Wald {
	private Foerster foerster;

	@Inject
	public Wald( Foerster spellChecker) {
		this.foerster = spellChecker;
	}
	
	public void gebeInfoAus(){
		System.out.println(foerster);
	}
	
	public static void main(String[] args) {
		Injector waldZusammenbastler = Guice.createInjector(new WaldModule());
	    Wald wald = waldZusammenbastler.getInstance(Wald.class);
	    wald.gebeInfoAus();
	} 
}