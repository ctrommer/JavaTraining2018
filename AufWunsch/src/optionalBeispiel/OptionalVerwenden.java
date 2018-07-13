package optionalBeispiel;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class OptionalVerwenden {

	public static void main(String[] args) {
		optionalOderDefaultWert();
		optionalOderExceptionMitAnonymerKlasse();
		optionalOderExceptionMitLambda();
		optionalOderExceptionMitMethodReferenz();
		optionalVonStringFallsVorhandenAusgebenMitAnonymerKlasse();
		optionalVonStringFallsVorhandenAusgebenMitMethodReferenz();
		optionalVonStringFallsVorhandenUndMitAStartetAusgebenMitMethodReferenz();
		optionalVonStringZuWert();
		optionalZuWertZuOptional();
		optionalZuOptional();
	}
		
	private static void optionalOderDefaultWert() {
		Optional<String> vielleichtText = Optional.of("Hallo");
		String inhaltVonOptional = vielleichtText.orElse("Default String");
		System.out.println(inhaltVonOptional);
	}
	
	private static void optionalOderExceptionMitAnonymerKlasse() {
		Optional<String> vielleichtText = Optional.of("Hallo");
		String inhaltVonOptional = vielleichtText.orElseThrow(new Supplier<IllegalStateException>() {
			@Override
			public IllegalStateException get() {
				return new IllegalStateException();
			}
		});
		System.out.println(inhaltVonOptional);
	}

	private static void optionalOderExceptionMitLambda() {
		Optional<String> vielleichtText = Optional.of("Hallo");
		String inhaltVonOptional = vielleichtText.orElseThrow(() -> new IllegalStateException());
		System.out.println(inhaltVonOptional); 
	}	

	private static void optionalOderExceptionMitMethodReferenz() {
		Optional<String> vielleichtText = Optional.of("Hallo");
		String inhaltVonOptional = vielleichtText.orElseThrow(IllegalStateException::new);
		System.out.println(inhaltVonOptional);
	}		

	private static void optionalVonStringFallsVorhandenAusgebenMitAnonymerKlasse() {
		
		Optional<String> vielleichtText = Optional.of("Hallo");		
		vielleichtText.ifPresent(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});
	}

	private static void optionalVonStringFallsVorhandenAusgebenMitMethodReferenz() {		
		Optional<String> vielleichtText = Optional.of("Hallo");		
		vielleichtText.ifPresent(System.out::println);
	}

	private static void optionalVonStringFallsVorhandenUndMitAStartetAusgebenMitMethodReferenz() {
		Person arnold = new Person("Arnold");
		Optional<Person> vielleichtArnold = Optional.of(arnold);
		vielleichtArnold.filter(p->p.getName().startsWith("A")).ifPresent(p->System.out.println(p.getName()));		
	}

	/**
	 * Achtung: Sollte man nur im äussersten Notfall verwenden.
	 */
	private static void optionalVonStringZuWert() {
		Optional<String> vielleichtText = Optional.of("Hallo");
		if ( vielleichtText.isPresent() ) {
			System.out.println(vielleichtText.get());
		}
	}

	private static void optionalZuWertZuOptional() {		
		Person arnold = new Person("Arnold");
		Optional<Person> vielleichtArnold = Optional.of(arnold);
		
		Optional<String> vielleichtNameAusPerson = vielleichtArnold.map(Person::getName);
		System.out.println(vielleichtNameAusPerson.orElse("unbekannt"));
	}	
	
	private static void optionalZuOptional() {
		Person arnold = new Person("Arnold");		
		Optional<Person> vielleichtArnold = Optional.of(arnold);
		
		Optional<Integer> vielleichtGewichtVonArnold = vielleichtArnold.flatMap(Person::getVielleichtGewicht);
		System.out.println(vielleichtGewichtVonArnold.orElse(0));
	}	
}
