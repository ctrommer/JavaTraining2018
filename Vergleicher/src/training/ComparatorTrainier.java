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
		zuSortierendePersonen.sort(null);
	}

	private static void sortierePersonNachNameMitLambda() {				
	}

	/**
	 * 
	 * Hier wird {@link Function} verwendet. Macht es erst mal komplizierter. 
	 * Ist ein Zwischenschritt, um {@link java.util.Comparator#comparing()} zu erklären.
	 * 
	 */
	private static void sortierePersonNachNameMitLambdaUndFunction() {
	}

	/**
	 * Direkt als Einzeiler.
	 * Um dieses Problem zu verstehen, sollte man {@link java.util.Comparator#comparing()} anschauen. 
	 */
	private static void sortierePersonNachNameMitStatischerMethodeVonComparator() {
	}

	/**
	 * Mit Methode von Comparator, die zwei Parameter nimmt!
	 */
	private static void sortierePersonNachNameRueckwaerts() {
	}

	private static void sortierePersonNachNameRueckwaertsGrossKleinSchreibungIgnorierend() {
	}

	private static void sortierePersonNachNameRueckwaertsUndDannNachAlter() {
	} 
	
	private static void sortierePersonNachNameMitNullZuletztUndDannNachAlter() {
		zuSortierendePersonenMitNull.sort(null);
	}

	private static void sortiereAngestellteNachNatuerlicherOrdnung() {
		zuSortierendeAngestellte.sort(null);
	}

}
