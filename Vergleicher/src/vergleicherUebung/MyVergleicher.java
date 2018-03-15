package vergleicherUebung;

@FunctionalInterface
public interface MyVergleicher<T> {
	int vergleiche(T t1, T t2 );
	
	default MyVergleicher<T> verwandleInRueckwaertsvergleicher() {
		return (t1, t2) -> vergleiche(t2, t1);
	}
	
	static <T,R extends Comparable<R>> MyVergleicher<T> erzeugeVergleicher( MyFunktion<T, R> vergleichskriteriumExtrahierer ) {
		return (t1, t2)-> vergleichskriteriumExtrahierer.machWas(t1).compareTo(vergleichskriteriumExtrahierer.machWas(t2));			
	}

	static <T extends Comparable<T>> MyVergleicher<T> erzeugeRueckwaertsvergleicher() {
		return (t1, t2) -> t2.compareTo(t1);
	}
	
	static <T,R> MyVergleicher<T> erzeugeVergleicher( MyFunktion<T, R> vergleichskriteriumExtrahierer, MyVergleicher<R> alterVergleicher ) {
		return (t1,t2 ) -> alterVergleicher.vergleiche(vergleichskriteriumExtrahierer.machWas(t1), vergleichskriteriumExtrahierer.machWas(t2));			
	}

	default <R extends Comparable<R>> MyVergleicher<T> fuegeNaechstenVergleicherHinzu(MyFunktion<T, R> nachsterVergleichskriteriumExtrahierer) {
		
		MyVergleicher<T> naechsterVergleicher = erzeugeVergleicher(nachsterVergleichskriteriumExtrahierer);
		
		MyVergleicher<T> zusammengesetzterVergleicher = erzeugeZusammengesetztenVergleicher(naechsterVergleicher);
		
		return zusammengesetzterVergleicher;
		
	}

	default MyVergleicher<T> erzeugeZusammengesetztenVergleicher(MyVergleicher<T> naechsterVergleicher) {
		MyVergleicher<T> zusammengesetzterVergleicher = (t1, t2) -> {
			int ergebnis = vergleiche(t1, t2);
			return ergebnis != 0 ? ergebnis : naechsterVergleicher.vergleiche(t1, t2); 
		};
		return zusammengesetzterVergleicher;
	}

	static <T,R extends Comparable<R>> MyVergleicher<T> erzeugeNullVergleicher(MyFunktion<T, R> vergleichskriteriumExtrahierer) {
		return new MyVergleicherUnterstuetzer.MyNullBeruecksichtigenderVergleicher<>(true, erzeugeVergleicher(vergleichskriteriumExtrahierer));
	}

	@SuppressWarnings("unchecked")
	static <T extends Comparable<T>> MyVergleicher<T> erzeugeVergleicherWieComparable() {
		return (MyVergleicher<T>) MyVergleicherUnterstuetzer.MyVergleicherWieComparable.INSTANCE;
	}
}
