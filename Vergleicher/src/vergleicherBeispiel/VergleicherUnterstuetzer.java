package vergleicherBeispiel;

import java.util.Objects;

class VergleicherUnterstuetzer {

	enum VergleicherWieComparable implements Vergleicher<Comparable<Object>> {
		INSTANCE;

		@Override
		public int vergleiche( Comparable<Object> t1, Comparable<Object> t2 ) {
			return t1.compareTo( t2 );
		}

		@Override
		public Vergleicher<Comparable<Object>> erzeugeDarausRueckwaertsVergleicher() {
			// TODO
			return null;
		}		
	
	}
	

	private VergleicherUnterstuetzer() {
		throw new AssertionError("no instances");
	}

	final static class NullBeruecksichtigenderVergleicher<T> implements Vergleicher<T> {
		
		private final boolean nullZuerst;
		private final Vergleicher<T> vergleicher;
		
		public NullBeruecksichtigenderVergleicher( boolean nullZuerst, Vergleicher<T> vergleicher ) {
			super();
			this.nullZuerst = nullZuerst;
			this.vergleicher = vergleicher;
		}

		@Override
		public int vergleiche( T t1, T t2 ) {
			if ( t1 == null && t2 == null ) { return 0; }
			else if ( t1 == null && t2 != null ) { return nullZuerst ? -1 : 1; }
			else if ( t1 != null && t2 == null ) { return nullZuerst ? 1 : -1; }
			else { return vergleicher == null ? 0 :  vergleicher.vergleiche( t1, t2 ); }
		}

		@Override
		public Vergleicher<T> fuegeNaechstenVergleicherHinzu(Vergleicher<T> nachsterVergleicher) {
			Objects.requireNonNull( nachsterVergleicher );
			return new NullBeruecksichtigenderVergleicher<>(
														nullZuerst, 
														vergleicher == null ? 
																nachsterVergleicher 
																: vergleicher.fuegeNaechstenVergleicherHinzu( nachsterVergleicher ) );
		}

		@Override
		public Vergleicher<T> erzeugeDarausRueckwaertsVergleicher() {
			return new NullBeruecksichtigenderVergleicher<>(
														!nullZuerst, 
														vergleicher ==  null ? 
																null 
																: vergleicher.erzeugeDarausRueckwaertsVergleicher() );
		}
		
	}

}
