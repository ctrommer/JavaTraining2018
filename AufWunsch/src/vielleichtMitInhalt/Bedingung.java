package vielleichtMitInhalt;

@FunctionalInterface
interface Bedingung<T> {
	boolean istErfuelltFuer( T zuPruefen );
}
