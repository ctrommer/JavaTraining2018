package comparatorBeispiel;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * Zeigt, wie man in Java 8 einen Comperator schreibt und verwendet
 * 
 * Beachte: Die Person wird nach Name sortiert, wobei Name ein String ist. Der String Name wird hier
 * nach der natürlichen Reihenfolge sortiert. 
 * 
 * Angelehnt an:
 * https://praveer09.github.io/technology/2016/06/21/writing-comparators-the-java8-way/
 * 
 *
 */

public class PersonSortierenMitComperator {
	static List<Person> personen = Arrays.asList(new Person ("Kevin", 2 ), new Person ( "Andreas", 30 ), new Person ( "Waltraut", 80 ) );

	public static void main(String[] args) {			
		vergleichePersonNachNameOhneLambda();
		System.out.println(personen);
		vergleichePersonNachNameMitLambda();
		System.out.println(personen);
		vergleichePersonNachNameMitLambdaUndFunction();
		System.out.println(personen);
		vergleichePersonNachNameMitStatischerMethodeVonComperator();
		System.out.println(personen);
		vergleichePersonNachNameMitStatischerMethodeVonComperatorMitLambda();
		System.out.println(personen);
		vergleichePersonNachNameMitStatischerMethodeVonComperatorMitMethodReferenz();
		System.out.println(personen);
		vergleichePersonNachNameMitStatischerMethodeVonComperatorMitMethodReferenzDirekt();
		System.out.println(personen);
		vergleichePersonNachNameRueckwaerts();
		System.out.println(personen);
		vergleichePersonNachNameRueckwaertsDirekt();
		System.out.println(personen);
		vergleichePersonNachNameRueckwaertsGrossKleinSchreibungIgnorierend();
		System.out.println(personen);
		vergleichePersonNachNameUndDannNachAlter();
		System.out.println(personen);
		vergleichePersonNachNameMitNullWertenUndDannNachAlter();
		System.out.println(personen);
		sortiereNachNatuerlicherOrdnung();
	}
	
	private static void vergleichePersonNachNameOhneLambda() {		
		
		Comparator<Person> personNachNameComparator = new Comparator<Person>() {
			@Override
			public int compare(Person person1, Person person2) {
				return person1.getName().compareTo(person2.getName());
			}
		}; 
		
		personen.sort(personNachNameComparator);		
	}

	private static void vergleichePersonNachNameMitLambda() {		
		
		Comparator<Person> personNachNameComparator = (person1, person2) -> person1.getName().compareTo(person2.getName());
		
		personen.sort(personNachNameComparator);		
	}

	/**
	 * Hier wird {@link Function} verwendet. Macht es erst mal komplizierter. Ist ein Zwischenschritt, um {@link java.util.Comparator#comparing()} zu erklären.
	 */
	private static void vergleichePersonNachNameMitLambdaUndFunction() {
		
		Function<Person, String> personZuNameFunction = new Function<Person, String> () {
			@Override
			public String apply(Person person) {
				return person.getName();
			}
		};
		
		Comparator<Person> personNachNameComparator = (person1, person2) -> personZuNameFunction.apply(person1).compareTo(personZuNameFunction.apply(person2));
		
		personen.sort(personNachNameComparator);		
	}
	
	/**
	 * Um dieses Problem zu verstehen, sollte man {@link java.util.Comparator#comparing()} anschauen. 
	 */
	private static void vergleichePersonNachNameMitStatischerMethodeVonComperator() {
		Function<Person, String> personZuNameFunction = new Function<Person, String> () {
			@Override
			public String apply(Person t) {
				return t.getName();
			}
		};
		
		Comparator<Person> personNachNameComparator = Comparator.comparing(personZuNameFunction);
		
		personen.sort(personNachNameComparator);
	}

	private static void vergleichePersonNachNameMitStatischerMethodeVonComperatorMitLambda() {
		
		Function<Person, String> personZuNameFunction = person -> person.getName();
		
		Comparator<Person> personNachNameComparator = Comparator.comparing(personZuNameFunction);
		
		personen.sort(personNachNameComparator);		
	}
	
	private static void vergleichePersonNachNameMitStatischerMethodeVonComperatorMitMethodReferenz() {
		
		Function<Person, String> personZuNameFunction = Person::getName;
		
		Comparator<Person> personNachNameComparator = Comparator.comparing(personZuNameFunction);
		
		personen.sort(personNachNameComparator);
	}		
	
	private static void vergleichePersonNachNameMitStatischerMethodeVonComperatorMitMethodReferenzDirekt() {
		
		Comparator<Person> personNachNameComparator = Comparator.comparing(Person::getName);
		
		personen.sort(personNachNameComparator);
	}			

	private static void vergleichePersonNachNameRueckwaerts() {
		
		Comparator<Person> personNachNameComparator = Comparator.comparing(Person::getName, Comparator.reverseOrder());
		
		personen.sort(personNachNameComparator);
	}
	
	private static void vergleichePersonNachNameRueckwaertsDirekt() {

		personen.sort(Comparator.comparing(Person::getName, Comparator.reverseOrder()));
	}	
	
	private static void vergleichePersonNachNameRueckwaertsGrossKleinSchreibungIgnorierend() {

		personen.sort(Comparator.comparing(Person::getName, String.CASE_INSENSITIVE_ORDER.reversed()));
	}	
	
	private static void vergleichePersonNachNameUndDannNachAlter() {

		personen.sort(Comparator.comparing(Person::getName, Comparator.reverseOrder()).thenComparing(Person::getAlter));
	}

	private static void vergleichePersonNachNameMitNullWertenUndDannNachAlter() {
		
		personen.sort(Comparator.nullsLast(Comparator.comparing(Person::getName)).thenComparing(Person::getAlter));
	}

	private static void sortiereNachNatuerlicherOrdnung() {
		List<Angestellter> angestelltenListe = Arrays.asList(new Angestellter(43),new Angestellter(22),new Angestellter(42));		 
		Comparator<Angestellter> angestellterGehaltVergleicher = Comparator.naturalOrder();
		angestelltenListe.sort(angestellterGehaltVergleicher);
		System.out.println(angestelltenListe);
	}

}
