package vergleicherBeispiel;

@FunctionalInterface
public interface Funktion<T,R> {	
	R machEtwas( T t );	
}
 