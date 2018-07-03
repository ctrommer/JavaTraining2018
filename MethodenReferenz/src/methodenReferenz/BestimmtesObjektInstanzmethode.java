package methodenReferenz;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class BestimmtesObjektInstanzmethode {
	
	public static void main(String[] args) {
		schauspielerVerabschiedetAlleMitarbeiterMitConsumerUndLambda();
		schauspielerVerabschiedetAlleMitarbeiterMitConsumerUndMethodReferenz();
	}

	public static void schauspielerVerabschiedetAlleMitarbeiterMitConsumerUndLambda() {

		Schauspieler arnold = new Schauspieler("I'll be back");

		List<Mitarbeiter> mitarbeiterListe = Arrays.asList(new Mitarbeiter( "Karl"), new Mitarbeiter( "Hans"), new Mitarbeiter( "Egon"));

		Consumer<Mitarbeiter> arnoldVerabschiedetMitarbeiter = mitarbeiter -> arnold.verabschieden(mitarbeiter);

		mitarbeiterListe.forEach(arnoldVerabschiedetMitarbeiter);		
	}

	public static void schauspielerVerabschiedetAlleMitarbeiterMitConsumerUndMethodReferenz() {

		Schauspieler arnold = new Schauspieler("I'll be back");

		List<Mitarbeiter> mitarbeiterListe = Arrays.asList(new Mitarbeiter( "Karl"), new Mitarbeiter( "Hans"), new Mitarbeiter( "Egon"));

		Consumer<Mitarbeiter> arnoldVerabschiedetMitarbeiter = arnold::verabschieden;
		
		mitarbeiterListe.forEach(arnoldVerabschiedetMitarbeiter);		
	}	
	
}
