package strategy;

import java.util.function.Predicate;

public class Hauskauf {
	
	/**
	 * Verwendet eine Bewertungsstragie und gibt dann aus, ob da Haus günstig oder teuer ist.
	 * @param haus
	 * das Haus, das bewertet werden soll
	 * @param bewertungsstrategie
	 * wie das Haus bewertet werden soll.
	 */
	public static void sollIchHausKaufen( Haus haus, Predicate<Haus> bewertungsstrategie ) {
		System.out.println( bewertungsstrategie.test(haus) ? "Haus ist günstig" : "Haus ist teuer" );
	}

	/**
	 * Erzeugt ein Haus und bewertet es nach zwei verschiedenen Strategieen: nach dem Buchwert und nach den Mieteinnahmen.
	 * Buchwert > Marktwert
	 * Jahresmieteinnahmen * 10 > Marktpreis
	 * @param args
	 */
	public static void main(String[] args) {
		Haus einfamilienHaus = new Haus(250_000, 300_000, 20_000);
		
		Predicate<Haus> bewertenNachBuchwertStrategie = ( haus ) -> haus.getBuchwert() > haus.getMarktpreis();
		sollIchHausKaufen(einfamilienHaus, bewertenNachBuchwertStrategie);
		
		Predicate<Haus> bewertenNachMieteinnahmenStrategie = ( haus ) -> haus.getJahresMieteinnahmen() * 10 > haus.getMarktpreis();
		sollIchHausKaufen(einfamilienHaus, bewertenNachMieteinnahmenStrategie);
	}

}
