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
		vergleicheSpielerNachAlterMitNullWertenUndDannNachName();
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
		Vergleicher<Spieler> spielerVergleicherRueckwaerts = spielerVergleicher.verwandleInRueckwaertsVergleicher();
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

	private static void vergleicheIntegerRueckwaerts() {
		Vergleicher<Integer> rueckwaertsVergleicher = Vergleicher.erzeugeRueckwaertsVergleicher();		
		System.out.println( rueckwaertsVergleicher.vergleiche( 42, 43 ));		
	}

	private static void vergleicheSpielerNachAlterRueckwaerts() {
		Vergleicher<Spieler> spielerVergleicher = Vergleicher.erzeugeVergleicher( Spieler::getAlter , Vergleicher.erzeugeRueckwaertsVergleicher() );
		System.out.println(spielerVergleicher.vergleiche(new Spieler("Karl", 42), new Spieler("Albert", 14)));
	}

	private static void vergleicheSpielerNachAlterRueckwaertsDirekt() {
		System.out.println(Vergleicher.erzeugeVergleicher( Spieler::getAlter ).verwandleInRueckwaertsVergleicher().vergleiche(new Spieler("Karl", 42), new Spieler("Albert", 14)));
	}

	private static void vergleicheZeichenketteGrossKleinSchreibungIgnorierend() {
		Vergleicher<Zeichenkette> zeichenketteVergleicher = Zeichenkette.GROSS_KLEIN_SCHEIBUNG_IGNORIERENDER_VERGLEICHER;
		System.out.println(zeichenketteVergleicher.vergleiche(new Zeichenkette("eins" ), new Zeichenkette( "zwei") ) );
	}	

	private static void vergleicheSpielerNachSpitznameRueckwaertsGrossKleinSchreibungIgnorierend() {
		
		Vergleicher<Spieler> erzeugeVergleicher = Vergleicher.erzeugeVergleicher( Spieler::getSpitzname, Zeichenkette.GROSS_KLEIN_SCHEIBUNG_IGNORIERENDER_VERGLEICHER);
		System.out.println(erzeugeVergleicher.vergleiche(new Spieler("K�fer", 42, "Karl"), new Spieler("Einstein", 14, "Albert")));
		
		// So funktionierts:
		System.out.println(Vergleicher.erzeugeVergleicher( Spieler::getSpitzname, Zeichenkette.GROSS_KLEIN_SCHEIBUNG_IGNORIERENDER_VERGLEICHER).verwandleInRueckwaertsVergleicher().vergleiche(new Spieler("K�fer", 42, "Karl"), new Spieler("Einstein", 14, "Albert")));
	}

	private static void vergleicheSpielerNachAlterUndDannNachName() {

		Vergleicher<Spieler> spielerVergleicher = Vergleicher.erzeugeVergleicher( Spieler::getAlter ).fuegeNaechstesVergleichsKriteriumHinzu(Spieler::getName);
		System.out.println(spielerVergleicher.vergleiche(new Spieler("Karl", 42), new Spieler("Albert", 14)));				
	}

	private static void vergleicheSpielerNachAlterMitNullWertenUndDannNachName() {
		Vergleicher<Spieler> spielerVergleicher = Vergleicher.erzeugeVergleicher( Spieler::getAlter ).fuegeNaechstesVergleichsKriteriumHinzu(Spieler::getName);
		Vergleicher<Spieler> spielerVergleicherNullZuerst = Vergleicher.erzeugeNullZuerstVergleicher(spielerVergleicher);
		System.out.println(spielerVergleicherNullZuerst.vergleiche(new Spieler("Karl", 42), new Spieler("Albert", 14)));				
		System.out.println(spielerVergleicherNullZuerst.vergleiche(null, new Spieler("Albert", 14)));
		System.out.println(spielerVergleicherNullZuerst.vergleiche(new Spieler("Karl", 42), null));
		System.out.println(spielerVergleicherNullZuerst.vergleiche(null, null));
		
		// Soll auch funktionieren, wenn null als Comparator �bergeben wird.
		Vergleicher<Spieler> spielerVergleicherNullZuerstVergleicherNull = Vergleicher.erzeugeNullZuerstVergleicher(null);
		spielerVergleicherNullZuerstVergleicherNull.fuegeNaechstesVergleichsKriteriumHinzu(Spieler::getName); // hab ich nicht in einer Zeile hinbekommen
		
		System.out.println(spielerVergleicherNullZuerstVergleicherNull.vergleiche(new Spieler("Karl", 42), new Spieler("Albert", 14)));				
		System.out.println(spielerVergleicherNullZuerstVergleicherNull.vergleiche(null, new Spieler("Albert", 14)));
		System.out.println(spielerVergleicherNullZuerstVergleicherNull.vergleiche(new Spieler("Karl", 42), null));
		System.out.println(spielerVergleicherNullZuerstVergleicherNull.vergleiche(null, null));

	}

	private static void sortiereNachNatuerlicherOrdnung() {
		Vergleicher<Fussballer> fussballerNummernVergleicher = Vergleicher.erzeugeVergleicherWieComparable();		
		System.out.println(fussballerNummernVergleicher.vergleiche(new Fussballer(42), new Fussballer(40)));
	}
	
}
