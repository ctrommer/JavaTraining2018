package vergleicherUebung;

public class SpielerSortierenMitVergleicherUebung {
	
	public static void main(String[] args) {
		vergleicheSpielerNachAlterMitAnonymerInnererKlasse();
		vergleicheSpielerNachAlterMitLambda();
		vergleicheSpielerNachAlterMitLambdaRueckwaerts();
		vergleicheSpielerNachAlterMitLambdaUndFunction();
		vergleicheSpielerNachAlterMitStatischerMethodeVonComperator();
		vergleicheSpielerNachAlterMitStatischerMethodeVonComperatorMitLambda();
		vergleicheSpielerNachAlterMitStatischerMethodeVonComperatorMitMethodReferenz();
		vergleicheSpielerNachAlterMitStatischerMethodeVonComperatorMitMethodReferenzDirekt();
		vergleicheIntegerRueckwaerts();
		vergleicheSpielerNachAlterRueckwaerts();
		vergleicheSpielerNachAlterRueckwaertsDirekt();
		vergleicheZeichenketteGrossKleinSchreibungIgnorierend();
		vergleicheSpielerNachSpitznameRueckwaertsGrossKleinSchreibungIgnorierend();
		vergleicheSpielerNachAlterUndDannNachName();
		vergleicheSpielerNachAlterMitNullWertenUndDannNachName();
		sortiereNachNatuerlicherOrdnung();
	}

	private static void vergleicheSpielerNachAlterMitAnonymerInnererKlasse() {
		MyVergleicher<MySpieler> spielerVergleicher = new MyVergleicher<MySpieler>() {
			@Override
			public int vergleiche(MySpieler t1, MySpieler t2) {
				return t1.getName().compareTo(t2.getName());
			}
		};				

		System.out.println(spielerVergleicher.vergleiche(new MySpieler("Karl", 42), new MySpieler("Albert", 14)));
	}

	private static void vergleicheSpielerNachAlterMitLambda() {
		MyVergleicher<MySpieler> spielerVergleicher = ( s1, s2 ) -> s1.getName().compareTo(s2.getName());
		System.out.println(spielerVergleicher.vergleiche(new MySpieler("Karl", 42), new MySpieler("Albert", 14)));
	}

	private static void vergleicheSpielerNachAlterMitLambdaRueckwaerts() {
		MyVergleicher<MySpieler> spielerVergleicher = ( s1, s2 ) -> s1.getName().compareTo(s2.getName());
		MyVergleicher<MySpieler> spielerRueckwaertsVergleicher = spielerVergleicher.verwandleInRueckwaertsvergleicher();
		System.out.println(spielerRueckwaertsVergleicher.vergleiche(new MySpieler("Karl", 42), new MySpieler("Albert", 14)));		
	}

	private static void vergleicheSpielerNachAlterMitLambdaUndFunction() {
		MyFunktion<MySpieler, String> spielerZuString = new MyFunktion<MySpieler, String>() {
			@Override
			public String machWas(MySpieler t) {
				return t.getName();
			}
		};
		
		MyVergleicher<MySpieler> spielerVergleicher = ( s1, s2 ) -> spielerZuString.machWas(s1).compareTo(spielerZuString.machWas(s2));
		System.out.println(spielerVergleicher.vergleiche(new MySpieler("Karl", 42), new MySpieler("Albert", 14)));
	}

	private static void vergleicheSpielerNachAlterMitStatischerMethodeVonComperator() {
		MyFunktion<MySpieler, String> spielerZuString = new MyFunktion<MySpieler, String>() {
			@Override
			public String machWas(MySpieler t) {
				return t.getName();
			}
		};
		
		MyVergleicher<MySpieler> spielerVergleicher = MyVergleicher.erzeugeVergleicher(spielerZuString);
		System.out.println(spielerVergleicher.vergleiche(new MySpieler("Karl", 42), new MySpieler("Albert", 14)));		
	}

	private static void vergleicheSpielerNachAlterMitStatischerMethodeVonComperatorMitLambda() {
		MyFunktion<MySpieler, String> spielerZuString = t -> t.getName();		
		MyVergleicher<MySpieler> spielerVergleicher = MyVergleicher.erzeugeVergleicher(spielerZuString);
		System.out.println(spielerVergleicher.vergleiche(new MySpieler("Karl", 42), new MySpieler("Albert", 14)));		
	}

	private static void vergleicheSpielerNachAlterMitStatischerMethodeVonComperatorMitMethodReferenz() {
		MyFunktion<MySpieler, String> spielerZuString = MySpieler::getName;		
		MyVergleicher<MySpieler> spielerVergleicher = MyVergleicher.erzeugeVergleicher(spielerZuString);
		System.out.println(spielerVergleicher.vergleiche(new MySpieler("Karl", 42), new MySpieler("Albert", 14)));						
	}

	private static void vergleicheSpielerNachAlterMitStatischerMethodeVonComperatorMitMethodReferenzDirekt() {
		MyVergleicher<MySpieler> spielerVergleicher = MyVergleicher.erzeugeVergleicher(MySpieler::getName);
		System.out.println(spielerVergleicher.vergleiche(new MySpieler("Karl", 42), new MySpieler("Albert", 14)));
	}

	/**
	 * Schreibe Methode von MyVergleicher, die einen Vergleicher erzeugt, der Elemente rückwärts vergleicht, die 
	 * Comparable implementieren.
	 * Verwende die Methode, um Integer rückwärts zu sortieren. 
	 */
	private static void vergleicheIntegerRueckwaerts() {
		MyVergleicher<Integer> intVergleicher = MyVergleicher.erzeugeRueckwaertsvergleicher();		
		System.out.println(intVergleicher.vergleiche(4,2));
	}

	/**
	 * Mit Methode, die einen Vergleichskriteriumextrahierer und einen Rueckwaertsvergleicher nimmt.
	 *
	 * Beachte dabei den Unterschied zwischen anonymer innerer Klasse und lambda.
	 *
	 * Für die Übung mit eigenem Vergleicher starke Vereinfachung akzeptabel.
	 *
	 */
	private static void vergleicheSpielerNachAlterRueckwaerts() {
		MyVergleicher<MySpieler> spielerVergleicher = MyVergleicher.erzeugeVergleicher(MySpieler::getName, MyVergleicher.erzeugeRueckwaertsvergleicher());
		System.out.println(spielerVergleicher.vergleiche(new MySpieler("Karl", 42), new MySpieler("Albert", 14)));
	}

	private static void vergleicheSpielerNachAlterRueckwaertsDirekt() {
		System.out.println(MyVergleicher.erzeugeVergleicher(MySpieler::getName, MyVergleicher.erzeugeRueckwaertsvergleicher()).vergleiche(new MySpieler("Karl", 42), new MySpieler("Albert", 14)));
	}

	private static void vergleicheZeichenketteGrossKleinSchreibungIgnorierend() {
		MyVergleicher<MyZeichenkette> zeichenkettenVergleicher = MyZeichenkette.GROSS_KLEIN_VERGLEICHER;
		System.out.println( zeichenkettenVergleicher.vergleiche(new MyZeichenkette("43"), new MyZeichenkette("41")));		
	}
	
	// Hier noch eine dazwischen, mit neuer Methode die Funktion und Vergleicher als Parameter nimmt?

	/**
	 * Sortieren nach Spitzname
	 */
	private static void vergleicheSpielerNachSpitznameRueckwaertsGrossKleinSchreibungIgnorierend() {
		MyVergleicher<MySpieler> spielerVergleicher = MyVergleicher.erzeugeVergleicher(MySpieler::getSpitzname, MyZeichenkette.GROSS_KLEIN_VERGLEICHER);		
		System.out.println(spielerVergleicher.vergleiche(new MySpieler("Karl", 42, new MyZeichenkette ("Kalle")), new MySpieler("Albert", 14, new MyZeichenkette("Addi"))));
	}
	
	/**
	 * Hierzu 2 Methoden schreiben:
	 * - Methode, die einem Vergleicher einen weiteren Vergleicher hinzufügt. 
	 * - Methode die die zwei Vergleicher zusammenfügt 
	 */
	private static void vergleicheSpielerNachAlterUndDannNachName() {		
		MyVergleicher<MySpieler> spielerVergleicher = MyVergleicher.erzeugeVergleicher(MySpieler::getName).fuegeNaechstenVergleicherHinzu( MySpieler::getAlter );
		System.out.println(spielerVergleicher.vergleiche(new MySpieler("Karl", 42), new MySpieler("Albert", 14)));
	}

	/**
	 * NullVergleicher zum Vergleichen erstellen. 
	 * Auch Ruckwaerts vergleichen beruecksichtigen.
	 */
	private static void vergleicheSpielerNachAlterMitNullWertenUndDannNachName() {
		MyVergleicher<MySpieler> spielerVergleicher = MyVergleicher.erzeugeNullVergleicher(MySpieler::getName).fuegeNaechstenVergleicherHinzu( MySpieler::getAlter );
		System.out.println(spielerVergleicher.vergleiche(new MySpieler("Karl", 42), new MySpieler("Albert", 14)));
	}

	/**
	 * NullVergleicher zum Vergleichen erstellen. 
	 * Auch Ruckwaerts vergleichen beruecksichtigen.
	 * 
	 * Etwas vergleichen, was auf natürliche Art verglichen werden kann.
	 */
	private static void sortiereNachNatuerlicherOrdnung() {
		MyVergleicher<MyFussballer> fussballerVergleicher = MyVergleicher.erzeugeVergleicherWieComparable();
		System.out.println(fussballerVergleicher.vergleiche(new MyFussballer( 42), new MyFussballer( 14)));
	}

	// nicht vergessen: Ergebnis vergleichen.

}
