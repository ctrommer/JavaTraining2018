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

	private static void sortierePersonNachNameOhneLambda() {				
		zuSortierendePersonen.sort(null);		
	}

	@Test
	public void testeSortierePersonNachNameOhneLambda() {
		sortierePersonNachNameOhneLambda();
		assertEquals(nachNameSortiertePersonen, zuSortierendePersonen);
	}

	private static void sortierePersonNachNameMitLambda() {				
	}

	@Test
	public void testeSortierePersonNachNameMitLambda() {
		sortierePersonNachNameMitLambda();
		assertEquals(nachNameSortiertePersonen, zuSortierendePersonen);
	}	
	
	/**
	 * Hier wird {@link Function} verwendet. Macht es erst mal komplizierter. Ist ein Zwischenschritt, um {@link java.util.Comparator#comparing()} zu erklären.
	 */
	private static void sortierePersonNachNameMitLambdaUndFunction() {
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
	}

	@Test
	public void testeSortierePersonNachNameMitStatischerMethodeVonComperator() {
		sortierePersonNachNameMitStatischerMethodeVonComperator();
		assertEquals(nachNameSortiertePersonen, zuSortierendePersonen);
	}			
	
	private static void sortierePersonNachNameMitStatischerMethodeVonComperatorMitLambda() {		
	}
	
	@Test
	public void testeSortierePersonNachNameMitStatischerMethodeVonComperatorMitLambda() {
		sortierePersonNachNameMitStatischerMethodeVonComperatorMitLambda();
		assertEquals(nachNameSortiertePersonen, zuSortierendePersonen);
	}

	private static void sortierePersonNachNameMitStatischerMethodeVonComperatorMitMethodReferenz() {
	}
	
	@Test
	public void testeSortierePersonNachNameMitStatischerMethodeVonComperatorMitMethodReferenz() {
		sortierePersonNachNameMitStatischerMethodeVonComperatorMitMethodReferenz();
		assertEquals(nachNameSortiertePersonen, zuSortierendePersonen);
	}	

	private static void sortierePersonNachNameRueckwaerts() {
	}

	@Test
	public void testeSortierePersonNachNameRueckwaerts() {
		List<Person> nachNameRueckwaertsSortiertePersonen = Arrays.asList( new Person ( "Waltraut", 80 ) , new Person ( "Waltraut", 70 ), new Person ("Kevin", 50 ), new Person("KEVIN", 40 ),  new Person ( "Andreas", 30 ) );
		
		sortierePersonNachNameRueckwaerts();
		assertEquals(nachNameRueckwaertsSortiertePersonen, zuSortierendePersonen);
	}

	private static void sortierePersonNachNameRueckwaertsDirekt() {
	}

	@Test
	public void testeSortierePersonNachNameRueckwaertsDirekt() {
		List<Person> nachNameRueckwaertsSortiertePersonen = Arrays.asList( new Person ( "Waltraut", 80 ) , new Person ( "Waltraut", 70 ), new Person ("Kevin", 50 ), new Person("KEVIN", 40 ),  new Person ( "Andreas", 30 ) );
		sortierePersonNachNameRueckwaertsDirekt();
		assertEquals(nachNameRueckwaertsSortiertePersonen, zuSortierendePersonen);
	}
	
	private static void sortierePersonNachNameRueckwaertsGrossKleinSchreibungIgnorierend() {
	}

	@Test
	public void testeSortierePersonNachNameRueckwaertsGrossKleinSchreibungIgnorierend() {
		List<Person> nachNameRueckwaertsGrossKleinIgnorierendSortiertePersonen = Arrays.asList( new Person ( "Waltraut", 80 ) , new Person ( "Waltraut", 70 ), new Person ("Kevin", 50 ), new Person("KEVIN", 40 ),  new Person ( "Andreas", 30 ) );
		
		sortierePersonNachNameRueckwaertsGrossKleinSchreibungIgnorierend();
		assertEquals(nachNameRueckwaertsGrossKleinIgnorierendSortiertePersonen, zuSortierendePersonen);
	}	

	private static void sortierePersonNachNameRueckwaertsUndDannNachAlter() {
	} 
	
	@Test
	public void testeSortierePersonNachNameRueckwaertsUndDannNachAlter() {		
		List<Person> nachNameDannNachAlterSortiertePersonen = Arrays.asList( new Person ( "Waltraut", 70 ), new Person ( "Waltraut", 80 ), new Person ("Kevin", 50 ), new Person("KEVIN", 40 ), new Person ( "Andreas", 30 ) );
		
		sortierePersonNachNameRueckwaertsUndDannNachAlter();
		assertEquals(nachNameDannNachAlterSortiertePersonen, zuSortierendePersonen);
	}

	private static void sortierePersonNachNameMitNullZuletztUndDannNachAlter() {
		zuSortierendePersonenMitNull.sort(null);
	}

	@Test
	public void testeSortierePersonNachNameMitNullWertenUndDannNachAlter() {
	
		List<Person> nachNameUndAlterSortiertePersonenMitNull = Arrays.asList( new Person ( "Andreas", 30 ), new Person("KEVIN", 40 ), new Person ("Kevin", 50 ), new Person ( "Waltraut", 70 ), new Person ( "Waltraut", 80 ), null, null );
	
		sortierePersonNachNameMitNullZuletztUndDannNachAlter();
		
		assertEquals(nachNameUndAlterSortiertePersonenMitNull, zuSortierendePersonenMitNull);
		
	}

	private static void sortiereNachNatuerlicherOrdnung() {
		zuSortierendeAngestelltenListe.sort(null);
	}

	@Test
	public void testeSortiereNachNatuerlicherOrdnung() {
		List<Angestellter> nachNatuerlicherOrdnungSortierteAngestellte = Arrays.asList(new Angestellter(30), new Angestellter(40), new Angestellter(50), new Angestellter(60) );
		sortiereNachNatuerlicherOrdnung();
		assertEquals(nachNatuerlicherOrdnungSortierteAngestellte, zuSortierendeAngestelltenListe);
	}
}
