package vergleicherBeispiel;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VergleicherTrainer {

	private static final Spieler KARL_11 = new Spieler("Karl", 11, "Kalle");
	private static final Spieler ALBERT_22 = new Spieler("Albert", 22, "Albi");
	private static final Spieler GUSTAV_11 = new Spieler("Gustav", 11, "Gustel");
	private static final Spieler BERTRAM_33 = new Spieler("Bertram", 33, "Bert");

	private int vergleicheSpielerNachAlterMitAnonymerInnererKlasse( Spieler links, Spieler rechts ) {

		Vergleicher<Spieler> spielerVergleicher = new Vergleicher<Spieler>() {
			@Override
			public int vergleiche( Spieler p1, Spieler p2 ) {
				return p1
						.getAlter()
						.compareTo( p2.getAlter() );
			}
		};

		return spielerVergleicher.vergleiche( links, rechts );
	}

	private int vergleicheSpielerNachAlterMitLambda(Spieler links, Spieler rechts ) {
		Vergleicher<Spieler> spielerVergleicher = ( p1,  p2) -> p1.getAlter().compareTo(p2.getAlter());
		return spielerVergleicher.vergleiche( links, rechts );
	}	

	private int vergleicheSpielerNachAlterMitLambdaRueckwaerts(Spieler links, Spieler rechts ) {
		Vergleicher<Spieler> spielerVergleicher 
										= ( t1, t2 ) 
										-> t1
											.getAlter()
											.compareTo( t2.getAlter() );
		Vergleicher<Spieler> spielerRueckwaertsVergleicher = spielerVergleicher.erzeugeDarausRueckwaertsVergleicher();
		return spielerRueckwaertsVergleicher.vergleiche( links, rechts );
	}

	private int vergleicheSpielerNachAlterMitFunktion(Spieler links, Spieler rechts ) {		
		Funktion<Spieler, Integer> spielerZuAlter =  Spieler::getAlter;		
		Vergleicher<Spieler> spielerVergleicher 
									= ( p1,  p2 ) 
									-> spielerZuAlter
											.machEtwas(p1)
											.compareTo( spielerZuAlter.machEtwas( p2 ) );		
		return spielerVergleicher.vergleiche( links, rechts );
	}

	private int vergleicheSpielerNachAlterMitFunktionUndStatischerMethodeVonVergleicher( Spieler links, Spieler rechts ) {
		Funktion<Spieler, Integer> spielerZuAlter =  Spieler::getAlter;
		Vergleicher<Spieler> spielerVergleicher = Vergleicher.erzeugeVergleicher( spielerZuAlter );		
		return spielerVergleicher.vergleiche( links, rechts );
	}
	
	/**
	 * Schreibe Methode von MyVergleicher, die einen Vergleicher erzeugt, der Elemente rückwärts vergleicht, die
	 * Comparable implementieren.
	 * Verwende die Methode, um Integer rückwärts zu sortieren.
	 */
	private int vergleicheIntegerRueckwaerts( Integer links, Integer rechts ) {
		Vergleicher<Integer> rueckwaertsVergleicher = Vergleicher.erzeugeRueckwaertsVergleicher();
		return rueckwaertsVergleicher.vergleiche( links, rechts );
	}

	/**
	 * Mit Methode, die einen Vergleichskriteriumextrahierer und einen Rueckwaertsvergleicher nimmt.  
	 * 	  
	 * Beachte dabei den Unterschied zwischen anonymer innerer Klasse und lambda.
	 * 
	 * Für die Übung mit eigenem Vergleicher starke Vereinfachung akzeptabel.
	 * 
	 */
	private int vergleicheSpielerNachAlterRueckwaertsMitVergleichskriteriumextrahiererUndRueckwaertsvergleicher( Spieler links, Spieler rechts ) {
		Vergleicher<Spieler> spielerVergleicher 
								= Vergleicher.erzeugeVergleicher( 
															Spieler::getAlter, 
															Vergleicher.erzeugeRueckwaertsVergleicher() );
		return spielerVergleicher.vergleiche( links, rechts );
	}

	private int vergleicheZeichenketteGrossKleinSchreibungIgnorierend( Zeichenkette links, Zeichenkette rechts ) {
		Vergleicher<Zeichenkette> zeichenketteVergleicher 
										= Zeichenkette.GROSS_KLEIN_SCHEIBUNG_IGNORIERENDER_VERGLEICHER;
		return zeichenketteVergleicher.vergleiche( links, rechts );
	}

	/**
	 * Sortieren nach Spitzname
	 */
	private int vergleicheSpielerNachSpitznameRueckwaertsGrossKleinSchreibungIgnorierend( Spieler links, Spieler rechts ) {
		return Vergleicher
					.erzeugeVergleicher( 
							Spieler::getSpitzname, 
							Zeichenkette.GROSS_KLEIN_SCHEIBUNG_IGNORIERENDER_VERGLEICHER)
					.erzeugeDarausRueckwaertsVergleicher()
					.vergleiche(links, rechts);
	}

	/**
	 * Hierzu 2 Methoden schreiben:
	 * - Methode, die einem Vergleicher einen weiteren Vergleicher hinzufügt. 
	 * - Methode die die zwei Vergleicher zusammenfügt 
	 */
	private int vergleicheSpielerNachAlterUndDannNachName( Spieler links, Spieler rechts ) {
		Vergleicher<Spieler> spielerVergleicher
										= Vergleicher
												.erzeugeVergleicher( Spieler::getAlter )
												.erzeugeMitNaechstemVergleichsKriterium( Spieler::getName );
		return spielerVergleicher.vergleiche( links, rechts );
	}

	/**
	 * NullVergleicher zum Vergleichen erstellen.
	 * Parameter ist ein Vergleicher, also nicht eine Method-Referenz.
	 */
	public int vergleicheSpielerNachAlterNullBeruecksichtigend( Spieler links, Spieler rechts ) {
		Vergleicher<Spieler> spielerVergleicher 
									= Vergleicher.erzeugeVergleicher( Spieler::getAlter );
		Vergleicher<Spieler> spielerVergleicherNullZuerst 
									= Vergleicher.erzeugeNullZuerstVergleicher( spielerVergleicher );
		return spielerVergleicherNullZuerst.vergleiche( links, rechts );
	}

	public int vergleicheSpielerNachAlterNullBeruecksichtigendRueckwaerts( Spieler links, Spieler rechts ) {
		Vergleicher<Spieler> spielerVergleicher = Vergleicher.erzeugeVergleicher( Spieler::getAlter );
		Vergleicher<Spieler> spielerVergleicherNullZuerst 
									= Vergleicher
										.erzeugeNullZuerstVergleicher( spielerVergleicher )
										.erzeugeDarausRueckwaertsVergleicher();

		return  spielerVergleicherNullZuerst.vergleiche( links, rechts );
	}

	private int vergleicheSpielerNachAlterNullBeruecksichtigendUndDannNachName( Spieler links, Spieler rechts ) {
		Vergleicher<Spieler> spielerVergleicher 
										= Vergleicher.erzeugeVergleicher( Spieler::getAlter );
		Vergleicher<Spieler> spielerVergleicherNullZuerst 
										= Vergleicher
											.erzeugeNullZuerstVergleicher( spielerVergleicher )
											.erzeugeMitNaechstemVergleichsKriterium( Spieler::getName );
		return spielerVergleicherNullZuerst.vergleiche( links, rechts );
	}

	/**
	 * Null beruecksichtigenden Vergleicher, bei dem Null zuerst kommt erstellen.
	 * Als zweites Vergleichskriterium nach Name vergleichen.
	 * @param links
	 * @param rechts
	 * @return
	 */
	private int vergleicheSpielerErsterVergleicherNullZweiterVergleicherNachName( Spieler links, Spieler rechts ) {

		// Soll auch funktionieren, wenn null als Comparator übergeben wird.
		Vergleicher<Spieler> nullZuerstVergleicherNull = Vergleicher.erzeugeNullZuerstVergleicher( null );
		Vergleicher<Spieler> nullZuerstVergleicherMitZweitemVergleichskriterium = nullZuerstVergleicherNull.erzeugeMitNaechstemVergleichsKriterium( Spieler::getName );
		return nullZuerstVergleicherMitZweitemVergleichskriterium.vergleiche( links, rechts );
	}

	/**
	 * Etwas vergleichen, was auf natürliche Art verglichen werden kann.
	 */
	public int sortiereNachNatuerlicherOrdnung( Fussballer links, Fussballer rechts ) {
		Vergleicher<Fussballer> fussballerNummernVergleicher = Vergleicher.erzeugeVergleicherWieComparable();
		return fussballerNummernVergleicher.vergleiche( links, rechts );
	}

}
