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
	
    @Inject @Named("AdresseImpl")
    private Adresse adresse;
    
	@Inject	@Named("Abteilungsname")
	private String name;
	
	private final String spitzname;
	
    @Inject
    public Abteilung( @Named("SpitzName") String spitzname) {
        this.spitzname = spitzname;
    }

	@Override
	public String toString() {
		return "Abteilung [weihnachtsfeier=" + weihnachtsfeier + ", abteilungsleiter=" + abteilungsleiter + ", adresse="
				+ adresse + ", name=" + name + ", spitzname=" + spitzname + "]";
	}
	
	public static void main(String[] args) {
		
		Injector abteilungZusammenbastler = Guice.createInjector(new AbteilungZusammenbastlerModule());
		   
		Abteilung abteilung = abteilungZusammenbastler.getInstance(Abteilung.class);
		   
		System.out.println(abteilung.toString());
	}	
   
}
