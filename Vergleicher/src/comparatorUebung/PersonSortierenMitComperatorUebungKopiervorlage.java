package comparatorUebung;

import java.util.Arrays;
import java.util.List;

import comparatorBeispiel.Person;

public class PersonSortierenMitComperatorUebungKopiervorlage{
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
	}
	
	private static void vergleichePersonNachNameMitLambda() {
	}
	
	private static void vergleichePersonNachNameMitLambdaUndFunction() {
	}
	
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
		// System.out.println(angestelltenListe);
		
	}
}
