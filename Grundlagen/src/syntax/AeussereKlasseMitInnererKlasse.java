package syntax;

public class AeussereKlasseMitInnererKlasse {
	
	private int aeussereZahl = 1;
	private static int aeussereStaticZahl = 2;

	public class InnereKlasse {
		int summeDerErreichbarenZahlen() {
			return (aeussereZahl + aeussereStaticZahl); 
		}		
	}
	
	public static class NestedKlasse {
		private int nestedZahl = 3;
		private static int nestedStaticZahl = 4;

		public int summeDerErreichbarenZahlen() {
			return (aeussereStaticZahl + nestedZahl + nestedStaticZahl); 
		}
	}

	void methodeMitLokalerInnereKlasse() {
		final class LokaleInnereKlasse {
			private int lokaleInnereZahl = 5;

			public int getLokaleInnereZahl() {
				return lokaleInnereZahl;
			}

		}
		
		LokaleInnereKlasse lokaleInnereKlasse = new LokaleInnereKlasse();
		System.out.println(lokaleInnereKlasse.getLokaleInnereZahl());
	}
	
	public static void main(String[] args) {
		
		AeussereKlasseMitInnererKlasse aeussereKlasse = new AeussereKlasseMitInnererKlasse();
		AeussereKlasseMitInnererKlasse.InnereKlasse innereKlasse = aeussereKlasse.new InnereKlasse();
		
		System.out.println(innereKlasse.summeDerErreichbarenZahlen());
		
		aeussereKlasse.methodeMitLokalerInnereKlasse();
		
		AeussereKlasseMitInnererKlasse.NestedKlasse nested = new AeussereKlasseMitInnererKlasse.NestedKlasse();		
		System.out.println(nested.summeDerErreichbarenZahlen());
		
	}	
}
