package aufWunschBeispiel;

@FunctionalInterface
interface Erzeuger<T> {
	T erzeuge();
}
