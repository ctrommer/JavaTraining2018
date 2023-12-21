package injizierenMitBinding;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

public class Abteilung {
    
	@Inject
	private Weihnachtsfeier weihnachtsfeier;
	
	@Inject
	private Abteilungsleiter abteilungsleiter;
	
    /**
     * Injiziere und geb dem Kind einen Namen
     */
    private Adresse adresse;
    
    /**
     * Injiziere und geb dem Kind einen Namen: 1. Stelle
     */
	private String name;
	
    /**
     * Injiziere und geb dem Kind einen Namen: 2. Stelle
     */
	private final String spitzname;
	
    public Abteilung( String spitzname) {
        this.spitzname = spitzname;
    }

	@Override
	public String toString() {
		return "Abteilung [weihnachtsfeier=" + weihnachtsfeier + ", abteilungsleiter=" + abteilungsleiter + ", adresse="
				+ adresse + ", name=" + name + ", spitzname=" + spitzname + "]";
	}

	public static Abteilung erzeugeAbteilungMitGuice() {		
		Injector abteilungZusammenbastler = Guice.createInjector( new AbteilungZusammenbastlerModule() );		   
		return abteilungZusammenbastler.getInstance( Abteilung.class );
	}
}
