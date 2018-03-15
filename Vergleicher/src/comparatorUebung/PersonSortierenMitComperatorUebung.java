package comparatorUebung;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import comparatorBeispiel.Angestellter;
import comparatorBeispiel.Person;

public class PersonSortierenMitComperatorUebung{
	static List<Person> personenListe = Arrays.asList(new Person("Anton",42),new Person("Karl",22),new Person("Gabi",42));

	public static void main(String[] args) {
		vergleichePersonNachNameOhneLambda();
		System.out.println(personenListe);
		vergleichePersonNachNameMitLambda();
		System.out.println(personenListe);
		vergleichePersonNachNameMitLambdaUndFunction();
		System.out.println(personenListe);
		vergleichePersonNachNameMitStatischerMethodeVonComperator();
		System.out.println(personenListe);
		vergleichePersonNachNameMitStatischerMethodeVonComperatorMitLambda();
		System.out.println(personenListe);
		vergleichePersonNachNameMitStatischerMethodeVonComperatorMitMethodReferenz();
		System.out.println(personenListe);
		vergleichePersonNachNameMitStatischerMethodeVonComperatorMitMethodReferenzDirekt();
		System.out.println(personenListe);
		vergleichePersonNachNameRueckwaerts();
		System.out.println(personenListe);
		vergleichePersonNachNameRueckwaertsDirekt();
		System.out.println(personenListe);
		vergleichePersonNachNameRueckwaertsGrossKleinSchreibungIgnorierend();
		System.out.println(personenListe);
		vergleichePersonNachNameUndDannNachAlter();
		System.out.println(personenListe);
		vergleichePersonNachNameMitNullWertenUndDannNachAlter();
		System.out.println(personenListe);
		sortiereNachNatuerlicherOrdnung();
	}
	
	private static void vergleichePersonNachNameOhneLambda() {
		Comparator<Person> personVergleicher = new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};
		personenListe.sort(personVergleicher);		
	}

	private static void vergleichePersonNachNameMitLambda() {
		Comparator<Person> personenVergleicher = ( t1, t2 ) -> t1.getName().compareTo(t2.getName());
		personenListe.sort(personenVergleicher);
	}

	private static void vergleichePersonNachNameMitLambdaUndFunction() {		
		
		Function<Person, String> personZuString = new Function<Person, String>() {
			@Override
			public String apply(Person t) {
				return t.getName();
			}
		}; 
		
		Comparator<Person> personenVergleicher = ( p1, p2 ) -> personZuString.apply(p1).compareTo(personZuString.apply(p2));
		personenListe.sort(personenVergleicher);
	}

	private static void vergleichePersonNachNameMitStatischerMethodeVonComperator() {
		Function<Person, String> personZuString = new Function<Person, String>() {
			@Override
			public String apply(Person t) {
				return t.getName();
			}
		}; 

		Comparator<Person> personenVergleicher = Comparator.comparing(personZuString);
		personenListe.sort(personenVergleicher);		
	}
	
	private static void vergleichePersonNachNameMitStatischerMethodeVonComperatorMitLambda() {
		Function<Person, String> personZuString = t->t.getName();

		Comparator<Person> personenVergleicher = Comparator.comparing(personZuString);
		personenListe.sort(personenVergleicher);		
	}
	
	private static void vergleichePersonNachNameMitStatischerMethodeVonComperatorMitMethodReferenz() {
		Function<Person, String> personZuString = Person::getName;

		Comparator<Person> personenVergleicher = Comparator.comparing(personZuString);
		personenListe.sort(personenVergleicher);		
	}
	
	private static void vergleichePersonNachNameMitStatischerMethodeVonComperatorMitMethodReferenzDirekt() {
		Comparator<Person> personenVergleicher = Comparator.comparing(Person::getName);
		personenListe.sort(personenVergleicher);		
	}
	
	private static void vergleichePersonNachNameRueckwaerts() {
		Comparator<Person> personenVergleicher = Comparator.comparing(Person::getName).reversed();
		personenListe.sort(personenVergleicher);		
	}
	
	private static void vergleichePersonNachNameRueckwaertsDirekt() {
		personenListe.sort(Comparator.comparing(Person::getName).reversed());		
	}

	private static void vergleichePersonNachNameRueckwaertsGrossKleinSchreibungIgnorierend() {
		personenListe.sort(Comparator.comparing(Person::getName, String.CASE_INSENSITIVE_ORDER));		
	}

	private static void vergleichePersonNachNameUndDannNachAlter() {
		personenListe.sort(Comparator.comparing(Person::getName).thenComparing(Person::getAlter));		
	}
	
	private static void vergleichePersonNachNameMitNullWertenUndDannNachAlter() {
		personenListe.sort(Comparator.nullsFirst(Comparator.comparing(Person::getName)).thenComparing(Person::getAlter));
	}
	
	private static void sortiereNachNatuerlicherOrdnung() {
		List<Angestellter> angestelltenListe = Arrays.asList(new Angestellter(43), new Angestellter(44));
		angestelltenListe.sort(Comparator.naturalOrder());
	}
}
