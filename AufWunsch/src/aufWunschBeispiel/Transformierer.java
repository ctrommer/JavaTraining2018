package aufWunschBeispiel;

@FunctionalInterface
interface Transformierer<T,R> {
	R erzeugeUndVerwende( T t );
}
