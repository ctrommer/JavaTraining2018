package aufWunschBeispiel;

@FunctionalInterface
interface Bedingung<T> {
	boolean istErfuelltFuer( T zuPruefen );
}
