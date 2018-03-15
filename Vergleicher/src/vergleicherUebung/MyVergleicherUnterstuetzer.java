package vergleicherUebung;

public class MyVergleicherUnterstuetzer {
	
	enum MyVergleicherWieComparable implements MyVergleicher<Comparable<Object>> {
		INSTANCE;

		@Override
		public int vergleiche(Comparable<Object> t1, Comparable<Object> t2) {
			return t1.compareTo(t2);
		}

		@Override
		public MyVergleicher<Comparable<Object>> verwandleInRueckwaertsvergleicher() {
			// TODO
			return null;
		}
		
	}
	
	
	
	public MyVergleicherUnterstuetzer() {
		throw new AssertionError();
	}



	public static class MyNullBeruecksichtigenderVergleicher<T> implements MyVergleicher<T> {
		
		boolean 			nullZuerst;
		MyVergleicher<T> 	vergleicher;

		public MyNullBeruecksichtigenderVergleicher(boolean nullZuerst, MyVergleicher<T> vergleicher) {
			this.nullZuerst = nullZuerst;
			this.vergleicher = vergleicher;
		}

		@Override
		public int vergleiche(T t1, T t2) {
			if ( t1 == null && t2 == null ) { return 0; }
			if ( t1 == null && t2 != null ) { return nullZuerst ? -1 : 1 ; }
			if ( t1 != null && t2 == null ) { return nullZuerst ? 1 : -1 ; }
			else { return vergleicher == null ? 0 : vergleicher.vergleiche(t1, t2); }
		}

		@Override
		public MyVergleicher<T> erzeugeZusammengesetztenVergleicher(MyVergleicher<T> naechsterVergleicher) {
			return new MyNullBeruecksichtigenderVergleicher<>(nullZuerst, vergleicher != null ? vergleicher.erzeugeZusammengesetztenVergleicher(naechsterVergleicher) : naechsterVergleicher);
		}

		@Override
		public MyVergleicher<T> verwandleInRueckwaertsvergleicher() {
			return new MyNullBeruecksichtigenderVergleicher<>(!nullZuerst, vergleicher == null ? null : vergleicher.verwandleInRueckwaertsvergleicher());
		}
	}
}
