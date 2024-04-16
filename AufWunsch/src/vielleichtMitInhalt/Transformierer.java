package vielleichtMitInhalt;

@FunctionalInterface
interface Transformierer<T,R> {
	R transformiere( T t );
}
