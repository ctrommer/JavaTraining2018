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
	public static void sollIchHausKaufen(  ) {
	}

	/**
	 * Erzeugt ein Haus und bewertet es nach zwei verschiedenen Strategieen: nach dem Buchwert und nach den Mieteinnahmen.
	 * Buchwert > Marktwert
	 * Jahresmieteinnahmen * 10 > Marktpreis
	 * @param args
	 */
	public static void main(String[] args) {
		Haus einfamilienHaus = new Haus(250_000, 300_000, 20_000);
	}

}
