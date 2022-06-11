package training;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import comparatorBeispiel.Angestellter;
import comparatorBeispiel.Person;

public class ComparatorTrainier {

	private static List<Person> zuSortierendePersonen = null;
	private static List<Person> nachNameSortiertePersonen = Arrays.asList(new Person ( "Andreas", 30 ), new Person("KEVIN", 40 ), new Person ("Kevin", 50 ), new Person ( "Waltraut", 80 ), new Person ( "Waltraut", 70 ) );

	private static List<Person> zuSortierendePersonenMitNull = null;

	private static List<Angestellter> zuSortierendeAngestelltenListe = Arrays.asList(new Angestellter(50), new Angestellter(40), new Angestellter(60), new Angestellter(30) );

	@BeforeEach
	public void personenListeUnsortiert() {
		zuSortierendePersonen = Arrays.asList( new Person ("Kevin", 50 ), new Person ( "Waltraut", 80 ) , new Person ( "Andreas", 30 ), new Person("KEVIN", 40 ), new Person ( "Waltraut", 70 ) );
		
		zuSortierendePersonenMitNull = Arrays.asList( null, new Person ("Kevin", 50 ), new Person ( "Waltraut", 80 ), null, new Person ( "Andreas", 30 ), new Person("KEVIN", 40 ), new Person ( "Waltraut", 70 ) );
	}

	/**
	 * Mit anonymer innerer Klasse.
	 */
	private static void sortierePersonNachNameOhneLambda() {		
		
		Comparator<Person> personNachNameComparator = new Comparator<Person>() {
			@Override
			public int compare(Person person1, Person person2) {
				return person1.getName().compareTo(person2.getName());
			}
		};
		
		zuSortierendePersonen.sort(personNachNameComparator);		
	}

	@Test
	public void testeSortierePersonNachNameOhneLambda() {
		sortierePersonNachNameOhneLambda();
		assertEquals(nachNameSortiertePersonen, zuSortierendePersonen);
	}

	private static void sortierePersonNachNameMitLambda() {		
		
		Comparator<Person> personNachNameComparator = (person1, person2) -> person1.getName().compareTo(person2.getName());
		
		zuSortierendePersonen.sort(personNachNameComparator);		
	}

	@Test
	public void testeSortierePersonNachNameMitLambda() {
		sortierePersonNachNameMitLambda();
		assertEquals(nachNameSortiertePersonen, zuSortierendePersonen);
	}	
	
	/**
	 * Hier wird {@link Function} verwendet. Macht es erst mal komplizierter. Ist ein Zwischenschritt, um {@link java.util.Comparator#comparing()} zu erkl�ren.
	 * 
	 * Function als anonyme innere Klasse.
	 */
	private static void sortierePersonNachNameMitLambdaUndFunction() {
		
		Function<Person, String> personZuNameFunction = new Function<Person, String> () {
			@Override
			public String apply(Person person) {
				return person.getName();
			}
		};
		
		Comparator<Person> personNachNameComparator = (person1, person2) -> personZuNameFunction.apply(person1).compareTo(personZuNameFunction.apply(person2));
		
		zuSortierendePersonen.sort(personNachNameComparator);		
	}
	
	@Test
	public void testeSortierePersonNachNameMitLambdaUndFunction() {
		sortierePersonNachNameMitLambdaUndFunction();
		assertEquals(nachNameSortiertePersonen, zuSortierendePersonen);
	}		
	
	/**
	 * Um dieses Problem zu verstehen, sollte man {@link java.util.Comparator#comparing()} anschauen. 
	 */
	private static void sortierePersonNachNameMitStatischerMethodeVonComperator() {
		Function<Person, String> personZuNameFunction = new Function<Person, String> () {
			@Override
			public String apply(Person t) {
				return t.getName();
			}
		};
		
		Comparator<Person> personNachNameComparator = Comparator.comparing(personZuNameFunction);
		
		zuSortierendePersonen.sort(personNachNameComparator);
	}

	@Test
	public void testeSortierePersonNachNameMitStatischerMethodeVonComperator() {
		sortierePersonNachNameMitStatischerMethodeVonComperator();
		assertEquals(nachNameSortiertePersonen, zuSortierendePersonen);
	}			
	
	/**
	 * Function als Lamda.
	 */
	private static void sortierePersonNachNameMitStatischerMethodeVonComperatorMitLambda() {
		
		Function<Person, String> personZuNameFunction = person -> person.getName();
		
		Comparator<Person> personNachNameComparator = Comparator.comparing(personZuNameFunction);
		
		zuSortierendePersonen.sort(personNachNameComparator);		
	}
	
	@Test
	public void testeSortierePersonNachNameMitStatischerMethodeVonComperatorMitLambda() {
		sortierePersonNachNameMitStatischerMethodeVonComperatorMitLambda();
		assertEquals(nachNameSortiertePersonen, zuSortierendePersonen);
	}

	/**
	 * Function als Method Referenz.
	 */
	private static void sortierePersonNachNameMitStatischerMethodeVonComperatorMitMethodReferenz() {

		Comparator<Person> personNachNameComparator = Comparator.comparing(Person::getName);

		zuSortierendePersonen.sort(personNachNameComparator);
	}
	
	@Test
	public void testeSortierePersonNachNameMitStatischerMethodeVonComperatorMitMethodReferenz() {
		sortierePersonNachNameMitStatischerMethodeVonComperatorMitMethodReferenz();
		assertEquals(nachNameSortiertePersonen, zuSortierendePersonen);
	}	

	/**
	 * Mit Methode von Comparator, die zwei Parameter nimmt!
	 */
	private static void sortierePersonNachNameRueckwaerts() {
		
		Comparator<Person> personNachNameComparator = Comparator.comparing(Person::getName, Comparator.reverseOrder());
		
		zuSortierendePersonen.sort(personNachNameComparator);
	}

	@Test
	public void testeSortierePersonNachNameRueckwaerts() {
		List<Person> nachNameRueckwaertsSortiertePersonen = Arrays.asList( new Person ( "Waltraut", 80 ) , new Person ( "Waltraut", 70 ), new Person ("Kevin", 50 ), new Person("KEVIN", 40 ),  new Person ( "Andreas", 30 ) );
		
		sortierePersonNachNameRueckwaerts();
		assertEquals(nachNameRueckwaertsSortiertePersonen, zuSortierendePersonen);
	}

	/**
	 * Einzeiler.
	 */
	private static void sortierePersonNachNameRueckwaertsDirekt() {
		zuSortierendePersonen.sort(Comparator.comparing(Person::getName, Comparator.reverseOrder()));
	}

	@Test
	public void testeSortierePersonNachNameRueckwaertsDirekt() {
		List<Person> nachNameRueckwaertsSortiertePersonen = Arrays.asList( new Person ( "Waltraut", 80 ) , new Person ( "Waltraut", 70 ), new Person ("Kevin", 50 ), new Person("KEVIN", 40 ),  new Person ( "Andreas", 30 ) );
		sortierePersonNachNameRueckwaertsDirekt();
		assertEquals(nachNameRueckwaertsSortiertePersonen, zuSortierendePersonen);
	}
	
	private static void sortierePersonNachNameRueckwaertsGrossKleinSchreibungIgnorierend() {
		zuSortierendePersonen.sort(Comparator.comparing(Person::getName, String.CASE_INSENSITIVE_ORDER.reversed()));
	}

	@Test
	public void testeSortierePersonNachNameRueckwaertsGrossKleinSchreibungIgnorierend() {
		List<Person> nachNameRueckwaertsGrossKleinIgnorierendSortiertePersonen = Arrays.asList( new Person ( "Waltraut", 80 ) , new Person ( "Waltraut", 70 ), new Person ("Kevin", 50 ), new Person("KEVIN", 40 ),  new Person ( "Andreas", 30 ) );
		
		sortierePersonNachNameRueckwaertsGrossKleinSchreibungIgnorierend();
		assertEquals(nachNameRueckwaertsGrossKleinIgnorierendSortiertePersonen, zuSortierendePersonen);
	}	

	private static void sortierePersonNachNameRueckwaertsUndDannNachAlter() {
		zuSortierendePersonen.sort(Comparator.comparing(Person::getName, Comparator.reverseOrder()).thenComparing(Person::getAlter));
	} 
	
	@Test
	public void testeSortierePersonNachNameRueckwaertsUndDannNachAlter() {		
		List<Person> nachNameDannNachAlterSortiertePersonen = Arrays.asList( new Person ( "Waltraut", 70 ), new Person ( "Waltraut", 80 ), new Person ("Kevin", 50 ), new Person("KEVIN", 40 ), new Person ( "Andreas", 30 ) );
		
		sortierePersonNachNameRueckwaertsUndDannNachAlter();
		assertEquals(nachNameDannNachAlterSortiertePersonen, zuSortierendePersonen);
	}

	private static void sortierePersonNachNameMitNullZuletztUndDannNachAlter() {
		zuSortierendePersonenMitNull.sort(Comparator.nullsLast(Comparator.comparing(Person::getName)).thenComparing(Person::getAlter));
	}

	@Test
	public void testeSortierePersonNachNameMitNullWertenUndDannNachAlter() {
	
		List<Person> nachNameUndAlterSortiertePersonenMitNull = Arrays.asList( new Person ( "Andreas", 30 ), new Person("KEVIN", 40 ), new Person ("Kevin", 50 ), new Person ( "Waltraut", 70 ), new Person ( "Waltraut", 80 ), null, null );
	
		sortierePersonNachNameMitNullZuletztUndDannNachAlter();
		
		assertEquals(nachNameUndAlterSortiertePersonenMitNull, zuSortierendePersonenMitNull);
		
	}

	private static void sortiereNachNatuerlicherOrdnung() {
		Comparator<Angestellter> angestellterGehaltVergleicher = Comparator.naturalOrder();
		zuSortierendeAngestelltenListe.sort(angestellterGehaltVergleicher);
	}

	@Test
	public void testeSortiereNachNatuerlicherOrdnung() {
		List<Angestellter> nachNatuerlicherOrdnungSortierteAngestellte = Arrays.asList(new Angestellter(30), new Angestellter(40), new Angestellter(50), new Angestellter(60) );
		sortiereNachNatuerlicherOrdnung();
		assertEquals(nachNatuerlicherOrdnungSortierteAngestellte, zuSortierendeAngestelltenListe);
	}
}
