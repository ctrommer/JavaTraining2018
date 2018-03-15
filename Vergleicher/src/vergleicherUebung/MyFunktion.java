package vergleicherUebung;

@FunctionalInterface
public interface MyFunktion<T,R> {
	R machWas( T t );
}
