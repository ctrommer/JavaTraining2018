package aufWunschBeispiel;

@FunctionalInterface
interface Transformierer<T,R> {
	R transformiere( T t );
}
