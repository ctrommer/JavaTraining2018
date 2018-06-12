package vergleicherBeispiel;

import java.util.Arrays;
import java.util.List;

public class SpielerSortierenMitVergleicher {
	
	static List<Spieler> spielerListe = Arrays.asList(new Spieler("Anton",43),new Spieler("Karl",22),new Spieler("Gabi",42));
	
	public static void main(String[] args) {
		vergleicheSpielerNachAlterMitAnonymerInnererKlasse();
		vergleicheSpielerNachAlterMitLambda();
		vergleicheSpielerNachAlterMitLambdaRueckwaerts();
		vergleicheSpielerNachAlterMitLambdaUndFunktion();
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
		vergleicheSpielerNachAlterNullBeruecksichtigend();
		vergleicheSpielerNachAlterNullBeruecksichtigendRueckwaerts();
		vergleicheSpielerNachAlterNullBeruecksichtigendUndDannNachName();
		sortiereNachNatuerlicherOrdnung();
	}
	
	private static void vergleicheSpielerNachAlterMitAnonymerInnererKlasse() {
		
		Vergleicher<Spieler> spielerVergleicher = new Vergleicher<Spieler>() {
			@Override
			public int vergleiche(Spieler p1, Spieler p2) {
				return p1.getAlter().compareTo(p2.getAlter());
			}
		};
		
		System.out.println(spielerVergleicher.vergleiche(new Spieler("Karl", 42), new Spieler("Albert", 14)));
	}

	private static void vergleicheSpielerNachAlterMitLambda() {
		Vergleicher<Spieler> spielerVergleicher = ( p1,  p2) -> p1.getAlter().compareTo(p2.getAlter());		
		System.out.println(spielerVergleicher.vergleiche(new Spieler("Karl", 42), new Spieler("Albert", 14)));
	}

	private static void vergleicheSpielerNachAlterMitLambdaRueckwaerts() {
		Vergleicher<Spieler> spielerVergleicher = ( t1, t2 ) -> t1.getName().compareTo(t2.getName());
		Vergleicher<Spieler> spielerVergleicherRueckwaerts = spielerVergleicher.erzeugeDarausRueckwaertsVergleicher();
		System.out.println(spielerVergleicherRueckwaerts.vergleiche(new Spieler("Karl", 42), new Spieler("Albert", 14)));
	}	

	private static void vergleicheSpielerNachAlterMitLambdaUndFunktion() {		
		Funktion<Spieler, Integer> spielerZuAlter = new Funktion<Spieler, Integer>() {			
			@Override
			public Integer machEtwas(Spieler p) {
				return p.getAlter();
			}
		};

		Vergleicher<Spieler> spielerVergleicher = (p1,  p2) -> spielerZuAlter.machEtwas(p1).compareTo(spielerZuAlter.machEtwas(p2));		
		System.out.println(spielerVergleicher.vergleiche(new Spieler("Karl", 42), new Spieler("Albert", 14)));
	}

	private static void vergleicheSpielerNachAlterMitStatischerMethodeVonComperator() {

		Funktion<Spieler, Integer> spielerZuAlter = new Funktion<Spieler, Integer>() {			
			@Override
			public Integer machEtwas(Spieler p) {
				return p.getAlter();
			}
		};

		Vergleicher<Spieler> spielerVergleicher = Vergleicher.erzeugeVergleicher( spielerZuAlter );

		System.out.println(spielerVergleicher.vergleiche(new Spieler("Karl", 42), new Spieler("Albert", 14)));
	}
	
	private static void vergleicheSpielerNachAlterMitStatischerMethodeVonComperatorMitLambda() {

		Funktion<Spieler, Integer> spielerZuAlter =  p  -> p.getAlter();

		Vergleicher<Spieler> spielerVergleicher = Vergleicher.erzeugeVergleicher( spielerZuAlter );

		System.out.println(spielerVergleicher.vergleiche(new Spieler("Karl", 42), new Spieler("Albert", 14)));
	}

	private static void vergleicheSpielerNachAlterMitStatischerMethodeVonComperatorMitMethodReferenz() {		
		Funktion<Spieler, Integer> spielerZuAlter =  Spieler::getAlter;
		Vergleicher<Spieler> spielerVergleicher = Vergleicher.erzeugeVergleicher( spielerZuAlter );
		System.out.println(spielerVergleicher.vergleiche(new Spieler("Karl", 42), new Spieler("Albert", 14)));		
	}

	private static void vergleicheSpielerNachAlterMitStatischerMethodeVonComperatorMitMethodReferenzDirekt() {
		Vergleicher<Spieler> spielerVergleicher = Vergleicher.erzeugeVergleicher( Spieler::getAlter );
		System.out.println(spielerVergleicher.vergleiche(new Spieler("Karl", 42), new Spieler("Albert", 14)));				
	}

	/**
	 * Schreibe Methode von MyVergleicher, die einen Vergleicher erzeugt, der Elemente rückwärts vergleicht, die 
	 * Comparable implementieren.
	 * Verwende die Methode, um Integer rückwärts zu sortieren. 
	 */
	private static void vergleicheIntegerRueckwaerts() {
		Vergleicher<Integer> rueckwaertsVergleicher = Vergleicher.erzeugeRueckwaertsVergleicher();		
		System.out.println( rueckwaertsVergleicher.vergleiche( 42, 43 ));		
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
		Vergleicher<Spieler> spielerVergleicher = Vergleicher.erzeugeVergleicher( Spieler::getAlter , Vergleicher.erzeugeRueckwaertsVergleicher() );
		System.out.println(spielerVergleicher.vergleiche(new Spieler("Karl", 42), new Spieler("Albert", 14)));
	}

	private static void vergleicheSpielerNachAlterRueckwaertsDirekt() {
		System.out.println(Vergleicher.erzeugeVergleicher( Spieler::getAlter ).erzeugeDarausRueckwaertsVergleicher().vergleiche(new Spieler("Karl", 42), new Spieler("Albert", 14)));
	}

	private static void vergleicheZeichenketteGrossKleinSchreibungIgnorierend() {
		Vergleicher<Zeichenkette> zeichenketteVergleicher = Zeichenkette.GROSS_KLEIN_SCHEIBUNG_IGNORIERENDER_VERGLEICHER;
		System.out.println(zeichenketteVergleicher.vergleiche(new Zeichenkette("eins" ), new Zeichenkette( "zwei") ) );
	}	

	/**
	 * Sortieren nach Spitzname
	 */	
	private static void vergleicheSpielerNachSpitznameRueckwaertsGrossKleinSchreibungIgnorierend() {
		
		Vergleicher<Spieler> erzeugeVergleicher = Vergleicher.erzeugeVergleicher( Spieler::getSpitzname, Zeichenkette.GROSS_KLEIN_SCHEIBUNG_IGNORIERENDER_VERGLEICHER);
		System.out.println(erzeugeVergleicher.vergleiche(new Spieler("Käfer", 42, "Karl"), new Spieler("Einstein", 14, "Albert")));
		
		// So funktionierts:
		System.out.println(Vergleicher.erzeugeVergleicher( Spieler::getSpitzname, Zeichenkette.GROSS_KLEIN_SCHEIBUNG_IGNORIERENDER_VERGLEICHER).erzeugeDarausRueckwaertsVergleicher().vergleiche(new Spieler("Käfer", 42, "Karl"), new Spieler("Einstein", 14, "Albert")));
	}

	/**
	 * Hierzu 2 Methoden schreiben:
	 * - Methode, die einem Vergleicher einen weiteren Vergleicher hinzufügt. 
	 * - Methode die die zwei Vergleicher zusammenfügt 
	 */
	private static void vergleicheSpielerNachAlterUndDannNachName() {

		Vergleicher<Spieler> spielerVergleicher = Vergleicher.erzeugeVergleicher( Spieler::getAlter ).erzeugeMitNaechstemVergleichsKriterium(Spieler::getName);
		System.out.println(spielerVergleicher.vergleiche(new Spieler("Karl", 42), new Spieler("Albert", 14)));				
	}

	/**
	 * NullVergleicher zum Vergleichen erstellen.
	 * Parameter ist ein Vergleicher, also nicht eine Method-Referenz.  
	 */
	public static void vergleicheSpielerNachAlterNullBeruecksichtigend() {
		Vergleicher<Spieler> spielerVergleicher = Vergleicher.erzeugeVergleicher( Spieler::getAlter );
		Vergleicher<Spieler> spielerVergleicherNullZuerst = Vergleicher.erzeugeNullZuerstVergleicher(spielerVergleicher);
		System.out.println(spielerVergleicherNullZuerst.vergleiche(new Spieler("Karl", 42), new Spieler("Albert", 14)));
		System.out.println(spielerVergleicherNullZuerst.vergleiche(null, new Spieler("Albert", 14)));
		System.out.println(spielerVergleicherNullZuerst.vergleiche(new Spieler("Karl", 42), null));
		System.out.println(spielerVergleicherNullZuerst.vergleiche(null, null));
	}

	public static void vergleicheSpielerNachAlterNullBeruecksichtigendRueckwaerts() {
		Vergleicher<Spieler> spielerVergleicher = Vergleicher.erzeugeVergleicher( Spieler::getAlter );
		Vergleicher<Spieler> spielerVergleicherNullZuerst = Vergleicher.erzeugeNullZuerstVergleicher(spielerVergleicher).erzeugeDarausRueckwaertsVergleicher();

		System.out.println(spielerVergleicherNullZuerst.vergleiche(new Spieler("Karl", 42), new Spieler("Albert", 14)));				
		System.out.println(spielerVergleicherNullZuerst.vergleiche(null, new Spieler("Albert", 14)));
		System.out.println(spielerVergleicherNullZuerst.vergleiche(new Spieler("Karl", 42), null));
		System.out.println(spielerVergleicherNullZuerst.vergleiche(null, null));
	}

	private static void vergleicheSpielerNachAlterNullBeruecksichtigendUndDannNachName() {
		Vergleicher<Spieler> spielerVergleicher = Vergleicher.erzeugeVergleicher( Spieler::getAlter );
		Vergleicher<Spieler> spielerVergleicherNullZuerst = Vergleicher.erzeugeNullZuerstVergleicher(spielerVergleicher).erzeugeMitNaechstemVergleichsKriterium(Spieler::getName);
		System.out.println(spielerVergleicherNullZuerst.vergleiche(new Spieler("Karl", 42), new Spieler("Albert", 14)));
		System.out.println(spielerVergleicherNullZuerst.vergleiche(null, new Spieler("Albert", 14)));
		System.out.println(spielerVergleicherNullZuerst.vergleiche(new Spieler("Karl", 42), null));
		System.out.println(spielerVergleicherNullZuerst.vergleiche(null, null));

		// Soll auch funktionieren, wenn null als Comparator übergeben wird.
		Vergleicher<Spieler> spielerVergleicherNullZuerstVergleicherNull = Vergleicher.erzeugeNullZuerstVergleicher(null);
		spielerVergleicherNullZuerstVergleicherNull.erzeugeMitNaechstemVergleichsKriterium(Spieler::getName);

		System.out.println(spielerVergleicherNullZuerstVergleicherNull.vergleiche(new Spieler("Karl", 42), new Spieler("Albert", 14)));				
		System.out.println(spielerVergleicherNullZuerstVergleicherNull.vergleiche(null, new Spieler("Albert", 14)));
		System.out.println(spielerVergleicherNullZuerstVergleicherNull.vergleiche(new Spieler("Karl", 42), null));
		System.out.println(spielerVergleicherNullZuerstVergleicherNull.vergleiche(null, null));
	}
	
	/** 
	 * Etwas vergleichen, was auf natürliche Art verglichen werden kann.
	 */
	private static void sortiereNachNatuerlicherOrdnung() {
		Vergleicher<Fussballer> fussballerNummernVergleicher = Vergleicher.erzeugeVergleicherWieComparable();		
		System.out.println(fussballerNummernVergleicher.vergleiche(new Fussballer(42), new Fussballer(40)));
	}
	
}
