package syntax;

public class AeussereKlasseMitInnererKlasse {
	
	private int aeussereZahl = 1;
	private static int aeussereStaticZahl = 2;

	/**
	 * Innere Klasse, die zeigt, auf welche Elemente der äusseren Klasse sie zugreifen darf.
	 */
	public class InnereKlasse {
		int summeDerErreichbarenZahlen() {
			return (aeussereZahl + aeussereStaticZahl); 
		}		
	}
	
	/**
	 * Statische innere Klasse, die zeigt, auf welche Elemente der äusseren Klasse sie zugreifen darf.
	 */
	public static class StatischeInnereKlasse {
		public int summeDerErreichbarenZahlen() {
			return (aeussereStaticZahl); 
		}
	}

	/**
	 * Lokale innere Klasse, die zeigt, auf welche Elemente der äusseren Klasse sie zugreifen darf.
	 */
	void methodeMitLokalerInnereKlasse() {
		final class LokaleInnereKlasse {
			public int summeDerErreichbarenZahlen() {
				return (aeussereZahl + aeussereStaticZahl); 
			}
		}
		
		LokaleInnereKlasse lokaleInnereKlasse = new LokaleInnereKlasse();
		System.out.println(lokaleInnereKlasse.summeDerErreichbarenZahlen());
	}
	
	public static void main(String[] args) {
	
		// innere Klasse
		AeussereKlasseMitInnererKlasse aeussereKlasse = new AeussereKlasseMitInnererKlasse();
		AeussereKlasseMitInnererKlasse.InnereKlasse innereKlasse = aeussereKlasse.new InnereKlasse();
		
		System.out.println(innereKlasse.summeDerErreichbarenZahlen());
				
		// statische innere Klasse
		AeussereKlasseMitInnererKlasse.StatischeInnereKlasse statischeInnereKlasse = new AeussereKlasseMitInnererKlasse.StatischeInnereKlasse();		
		System.out.println(statischeInnereKlasse.summeDerErreichbarenZahlen());
		
		aeussereKlasse.methodeMitLokalerInnereKlasse();
	}	
}
