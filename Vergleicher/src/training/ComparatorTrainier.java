package training;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComparatorTrainier {

	private static List<Person> zuSortierendePersonen = null;	
	private static List<Person> nachNameSortiertePersonen = Arrays.asList(
																		new Person ( "Andreas", 30 ), 
																		new Person( "KEVIN", 40 ), 
																		new Person ("Kevin", 50 ), 
																		new Person ( "Waltraut", 80 ), 
																		new Person ( "Waltraut", 70 ) );
	
	private static List<Person> zuSortierendePersonenMitNull = Arrays.asList( 
																		null, 
																		new Person ( "Kevin", 50 ), 
																		new Person ( "Waltraut", 80 ), 
																		null, 
																		new Person ( "Andreas", 30 ), 
																		new Person( "KEVIN", 40 ), 
																		new Person ( "Waltraut", 70 ) );

	private static List<Angestellter> zuSortierendeAngestellte = Arrays.asList(
																		new Angestellter( 50 ), 
																		new Angestellter( 40 ), 
																		new Angestellter( 60 ), 
																		new Angestellter( 30 ) );

	@BeforeEach
	public void personenListeUnsortiert() {
		zuSortierendePersonen = Arrays.asList( 
										new Person ( "Kevin", 50 ), 
										new Person ( "Waltraut", 80 ),
										new Person ( "Andreas", 30 ),
										new Person( "KEVIN", 40 ),
										new Person ( "Waltraut", 70 ) );
	}

	private static void sortierePersonNachNameMitAnonymerInnererKlasse() {		
		Comparator<Person> personNachNameComparator = new Comparator<Person>() {
			@Override
			public int compare( Person person1, Person person2 ) {
				return person1
							.getName()
							.compareTo( person2.getName() );
			}
		};
		
		zuSortierendePersonen.sort( personNachNameComparator );		
	}

	private static void sortierePersonNachNameMitLambda() {		
		
		Comparator<Person> personNachNameComparator 
											= ( person1, person2 ) 
											-> person1
													.getName()
													.compareTo( person2.getName() );
		
		zuSortierendePersonen.sort( personNachNameComparator );
	}

	/**
	 * 
	 * Hier wird {@link Function} verwendet. Macht es erst mal komplizierter. 
	 * Ist ein Zwischenschritt, um {@link java.util.Comparator#comparing()} zu erkl�ren.
	 * 
	 */
	private static void sortierePersonNachNameMitLambdaUndFunction() {

		Function<Person, String> personZuName = Person::getName;

		Comparator<Person> personNachNameComparator
											= ( person1, person2 ) 
											-> personZuName
													.apply( person1 )
													.compareTo( personZuName.apply( person2 ) );

		zuSortierendePersonen.sort( personNachNameComparator );
	}

	/**
	 * Direkt als Einzeiler.
	 * Um dieses Problem zu verstehen, sollte man {@link java.util.Comparator#comparing()} anschauen. 
	 */
	private static void sortierePersonNachNameMitStatischerMethodeVonComparator() {
		zuSortierendePersonen.sort( Comparator.comparing( Person::getName ) );
	}

	/**
	 * Mit Methode von Comparator, die zwei Parameter nimmt!
	 */
	private static void sortierePersonNachNameRueckwaerts() {
		
		zuSortierendePersonen.sort( Comparator.comparing(
													Person::getName, 
													Comparator.reverseOrder() ) );
	}

	private static void sortierePersonNachNameRueckwaertsGrossKleinSchreibungIgnorierend() {
		zuSortierendePersonen.sort( Comparator.comparing(
													Person::getName, 
													String.CASE_INSENSITIVE_ORDER.reversed() ) );
	}

	private static void sortierePersonNachNameRueckwaertsUndDannNachAlter() {
		zuSortierendePersonen.sort(Comparator
										.comparing(
												Person::getName, 
												Comparator.reverseOrder() )
										.thenComparing( 
												Person::getAlter ) );
	} 
	
	private static void sortierePersonNachNameMitNullZuletztUndDannNachAlter() {
		zuSortierendePersonenMitNull.sort( Comparator
												.nullsLast(	Comparator.comparing( Person::getName ) )
												.thenComparing( Person::getAlter ) );
	}

	private static void sortiereAngestellteNachNatuerlicherOrdnung() {
		Comparator<Angestellter> angestellterGehaltVergleicher = Comparator.naturalOrder();
		zuSortierendeAngestellte.sort( angestellterGehaltVergleicher );
	}
	
	@Test
	@DisplayName("Wurde Person nach Name sortiert mit anonymer innerer Klasse?")
	public void test01() {
		sortierePersonNachNameMitAnonymerInnererKlasse();
		
		assertEquals( 
				nachNameSortiertePersonen, 
				zuSortierendePersonen );
	}
	
	@Test
	@DisplayName("Wurde Person nach Name sortiert mit Lambda?")
	public void test02() {
		sortierePersonNachNameMitLambda();
		
		assertEquals(
				nachNameSortiertePersonen, 
				zuSortierendePersonen );
	}	

	@Test
	@DisplayName("Wurde Person nach Name sortiert mit Comparator und Function als Lambda?")
	public void test03() {
		sortierePersonNachNameMitLambdaUndFunction();
		assertEquals(
				nachNameSortiertePersonen, 
				zuSortierendePersonen );
	}

	@Test
	@DisplayName("Wurde Person nach Name sortiert mit statischer Methode von Comparator?")
	public void test04() {
		sortierePersonNachNameMitStatischerMethodeVonComparator();
		
		assertEquals(
				nachNameSortiertePersonen, 
				zuSortierendePersonen );
	}

	@Test
	@DisplayName("Wurde Person nach Name rueckwaerts sortiert?")
	public void test05() {
		List<Person> nachNameRueckwaertsSortiertePersonen = Arrays.asList( 
																	new Person ( "Waltraut", 80 ) , 
																	new Person ( "Waltraut", 70 ), 
																	new Person ( "Kevin", 50 ), 
																	new Person( "KEVIN", 40 ),  
																	new Person ( "Andreas", 30 ) );

		sortierePersonNachNameRueckwaerts();
		assertEquals(
				nachNameRueckwaertsSortiertePersonen, 
				zuSortierendePersonen );
	}

	@Test
	@DisplayName("Wurde Person nach Name rueckwaerts sortiert Gross- Kleinschreibung ignorierend?")
	public void test06() {
		List<Person> nachNameRueckwaertsGrossKleinIgnorierendSortiertePersonen = Arrays.asList( 
																							new Person ( "Waltraut", 80 ) , 
																							new Person ( "Waltraut", 70 ), 
																							new Person ("Kevin", 50 ), 
																							new Person( "KEVIN", 40 ),  
																							new Person ( "Andreas", 30 ) );
		
		sortierePersonNachNameRueckwaertsGrossKleinSchreibungIgnorierend();
		assertEquals(
				nachNameRueckwaertsGrossKleinIgnorierendSortiertePersonen, 
				zuSortierendePersonen );
	}

	@Test
	@DisplayName("Wurde Person nach Name Rueckwaerts und dann nach Alter sortiert?")
	public void test07() {		
		List<Person> nachNameDannNachAlterSortiertePersonen = Arrays.asList( 
																		new Person ( "Waltraut", 70 ), 
																		new Person ( "Waltraut", 80 ), 
																		new Person ( "Kevin", 50 ), 
																		new Person( "KEVIN", 40 ), 
																		new Person ( "Andreas", 30 ) );
		
		sortierePersonNachNameRueckwaertsUndDannNachAlter();
		assertEquals(
				nachNameDannNachAlterSortiertePersonen, 
				zuSortierendePersonen );
	}

	@Test
	@DisplayName("Wurde Person nach Name mit Nullwerten und dann nach Alter soritert?")
	public void test08() {
	
		List<Person> nachNameUndAlterSortiertePersonenMitNull = Arrays.asList( 
																		new Person ( "Andreas", 30 ), 
																		new Person("KEVIN", 40 ), 
																		new Person ("Kevin", 50 ), 
																		new Person ( "Waltraut", 70 ), 
																		new Person ( "Waltraut", 80 ), 
																		null, 
																		null );

		sortierePersonNachNameMitNullZuletztUndDannNachAlter();

		assertEquals(
				nachNameUndAlterSortiertePersonenMitNull, 
				zuSortierendePersonenMitNull );
	}

	@Test
	@DisplayName("Wurden Angestellte nach natuerlicher Ordnung sortiert?")
	public void test09() {
		List<Angestellter> nachNatuerlicherOrdnungSortierteAngestellte = Arrays.asList(
																					new Angestellter(30), 
																					new Angestellter(40), 
																					new Angestellter(50), 
																					new Angestellter(60) );
		sortiereAngestellteNachNatuerlicherOrdnung();
		assertEquals(
				nachNatuerlicherOrdnungSortierteAngestellte, 
				zuSortierendeAngestellte );
	}
	
}
