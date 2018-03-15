package vergleicherBeispiel;

import java.util.Objects;

/**
 * Interface, das den {@code Comparator} nachprogrammiert. <br><br>
 * 
 * Hierbei werden deutsche Namen verwendet, die helfen sollen, zu verstehen, was der Comparator macht. <br><br>
 *
 * Dieses Interface ist nur zu Übungszwecken und um den Comparator zu verstehen, man sollte natürlich immer den {@code Comparator} verwenden. <br>
 *
 * @param <T>
 * Die Klasse, die verglichen werden soll
 */
@FunctionalInterface
public interface Vergleicher<T> {

	int vergleiche( T t1, T t2 );

	/**
	 * Es soll ein {@code Vergleicher} erzeugt werden. Nach welchem Kriterium vergleicht er?  Es wird eine {@code Funktion} übergeben, die aus einer Klasse
	 * den Parameter extrahiert, der das Vergleichskriterium darstellt. Damit das funktioniert, muss das Vergleichskriterium {@code Comparable} implementieren.  
	 * 
	 * @param vergleichsKriteriumExtrahierer
	 * {@code Funktion}, die aus einer Klasse das Kriterium extrahiert, nach dem der erzeugte {@code Vergleicher} vergleicht.
	 * @return
	 * {@code Vergleicher}, der nach dem durch die übergebene Funktion extrahiertem Schlüssel vergleicht.
	 */
	static <T, U extends Comparable<U>> Vergleicher<T> erzeugeVergleicher(Funktion<T, U> vergleichsKriteriumExtrahierer) {
		
		Objects.requireNonNull(vergleichsKriteriumExtrahierer);
		
		return ( p1, p2 ) -> vergleichsKriteriumExtrahierer.machEtwas( p1 ).compareTo( vergleichsKriteriumExtrahierer.machEtwas( p2 ) );
	}

	/**
	 * Es soll ein {@code Vergleicher} erzeugt werden. Nach welchem Kriterium vergleicht er?  Es wird eine {@code Funktion} übergeben, die aus einer Klasse
	 * den Parameter extrahiert, der das Vergleichskriterium darstellt. Mit diesem Vergleichskriterium vergleicht der als Parameter übergebene {@code Vergleicher}.  
	 * 
	 * @param vergleichskriteriumExtrahierer
	 * {@code Funktion}, die aus einer Klasse das Kriterium extrahiert, nach dem der erzeugte {@codeVergleicher} vergleicht.
	 * @param schluesselVergleicher
	 * @return
	 * {@codeVergleicher}, der mit dem übergebenen {@code Vergleicher} nach dem durch die übergebene {@codeFunktion} extrahiertem Schlüssel vergleicht.
	 */ 
	static<T,U> Vergleicher<T> erzeugeVergleicher(Funktion<T,U> vergleichskriteriumExtrahierer, Vergleicher<U> schluesselVergleicher ) {
		Objects.requireNonNull(vergleichskriteriumExtrahierer);
		Objects.requireNonNull(schluesselVergleicher);

		Vergleicher<T> vergleicher = (p1, p2) -> schluesselVergleicher.vergleiche(vergleichskriteriumExtrahierer.machEtwas(p1), vergleichskriteriumExtrahierer.machEtwas(p2)); 

		return vergleicher;
	}

	/**
	 * Fügt dem Vergleicher ein weiters Vergleichskriterium hinzu. Zuerst wird nach dem ursprünglichen Vergleichskriterium verglichen, dann nach dem, welches hier
	 * hinzugefügt wird.
	 * 
	 * @param vergleichsKriteriumExtrahierer
	 * {@code Funktion}, die aus einer Klasse das Kriterium extrahiert, nach dem der erzeugte {@code Vergleicher} vergleicht.
	 * @return
	 * {@code Vergleicher}, der um das hinzugefügte Vergleichskriterium erweitert ist.
	 */
	default <U extends Comparable<U>> Vergleicher<T> fuegeNaechstesVergleichsKriteriumHinzu(Funktion<T,U> vergleichsKriteriumExtrahierer ) {		
		Vergleicher<T> zusaetlicherVergleicher = erzeugeVergleicher(vergleichsKriteriumExtrahierer);		
		return fuegeNaechstenVergleicherHinzu(zusaetlicherVergleicher);
	}

	/**
	 * Fügt dem Vergleicher ein weiters Vergleichskriterium hinzu. Zuerst wird nach dem ursprünglichen Vergleichskriterium verglichen, dann nach dem, welches hier
	 * hinzugefügt wird. 
	 * 
	 * @param nachsterVergleicher
	 * {@code Vergleicher} nach dem verglichen wird, wenn der eigentliche Vergleich keinen Unterschied feststellt.
	 * @return
	 * {@code Vergleicher}, der um das hinzugefügte Vergleichskriterium erweitert ist.
	 */
	default Vergleicher<T> fuegeNaechstenVergleicherHinzu( Vergleicher<T > nachsterVergleicher ) {
		
		Objects.requireNonNull(nachsterVergleicher);
		
		Vergleicher<T> erweiterterVergleicher = (p1, p2) -> { 
			int ergebnis = vergleiche( p1, p2 );
			return ( ergebnis != 0 ) ? ergebnis : nachsterVergleicher.vergleiche(p1, p2);
		};
		return erweiterterVergleicher;	
	}

	/**
	 * <pre>
	 * Erzeugt einen Vergleicher, der die Vergleichung umkehrt.
	 * 
	 * Beachte: eine Anonyme innere Klasse würde hier nicht funktionieren. Die Methode "vergleiche" der anonymen 
	 * Klasse würde die Methode "vergleiche" der umschliessenden Klasse verdecken.
	 * 
	 * https://stackoverflow.com/questions/22637900/java8-lambdas-vs-anonymous-classes
	 * Another difference between AICs and lambda expressions is that AICs introduce a new scope. 
	 * That is, names are resolved from the AIC's superclasses 
	 * and interfaces and can shadow names that occur in the lexcially enclosing environment. 
	 * For lambdas, all names are resolved lexically.
	 * 
	 * </pre>
	 * 
	 * @return
	 * Vergleicher, der umgedreht vergleicht.
	 */
	default Vergleicher<T> verwandleInRueckwaertsVergleicher() {
		Vergleicher<T> rueckwaertsVergleicher = ( p1, p2 ) -> vergleiche(p2, p1);
		return rueckwaertsVergleicher;
	}
	
	static <T extends Comparable<T>> Vergleicher<T> erzeugeRueckwaertsVergleicher() {
		return ( t1, t2 ) -> t2.compareTo(t1);
	}
	
	/**
	 * Erzeugt einen Vergleicher der null berücksichtigt. null ist dabei kleiner als andere Werte.
	 * @param vergleicher
	 * Wenn beide Werte ungleich null sind wird hiermit verglichen.
	 * @return
	 * neuer Vergleicher, der zusätzlich null berücksichtig.
	 */
	static <T> Vergleicher<T> erzeugeNullZuerstVergleicher(Vergleicher<T> vergleicher) {
		return new VergleicherUnterstuetzer.NullBeruecksichtigenderVergleicher<>( true, vergleicher);
	}

	@SuppressWarnings("unchecked")
	static <T extends Comparable<T>> Vergleicher<T> erzeugeVergleicherWieComparable() {
		return (Vergleicher<T>) VergleicherUnterstuetzer.VergleicherWieComparable.INSTANCE; 
	}

}
