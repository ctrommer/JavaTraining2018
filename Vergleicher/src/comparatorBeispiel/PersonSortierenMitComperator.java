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
		
		// personen.sort(personNachNameComparator);		
	}

	private static void vergleichePersonNachNameMitLambda() {		

	}

	/**
	 * Hier wird {@link Function} verwendet. Macht es erst mal komplizierter. Ist ein Zwischenschritt, um {@link java.util.Comparator#comparing()} zu erklären.
	 */
	private static void vergleichePersonNachNameMitLambdaUndFunction() {
		
	}
	
	/**
	 * Um dieses Problem zu verstehen, sollte man {@link java.util.Comparator#comparing()} anschauen. 
	 */
	private static void vergleichePersonNachNameMitStatischerMethodeVonComperator() {

	}

	private static void vergleichePersonNachNameMitStatischerMethodeVonComperatorMitLambda() {
		
	}
	
	private static void vergleichePersonNachNameMitStatischerMethodeVonComperatorMitMethodReferenz() {
		
	}		
	
	private static void vergleichePersonNachNameMitStatischerMethodeVonComperatorMitMethodReferenzDirekt() {
		
	}			

	private static void vergleichePersonNachNameRueckwaerts() {
		
	}
	
	private static void vergleichePersonNachNameRueckwaertsDirekt() {

	}	
	
	private static void vergleichePersonNachNameRueckwaertsGrossKleinSchreibungIgnorierend() {

	}	
	
	private static void vergleichePersonNachNameUndDannNachAlter() {

	}

	private static void vergleichePersonNachNameMitNullWertenUndDannNachAlter() {
		
	}

	private static void sortiereNachNatuerlicherOrdnung() {
		List<Angestellter> angestelltenListe = Arrays.asList(new Angestellter(43),new Angestellter(22),new Angestellter(42));
		
		System.out.println(angestelltenListe);
	}

}
