package chainOfResponsibility;

import java.util.function.Function;

public class Schreien {

	/**
	 * Zeigt chain of Responsibility, indem ein Text zuerst in Grossbuchstaben verwandelt wird und dann Ausrufezeichen angefügt werden.
	 * @param args
	 */
	public static void main(String[] args) {
		
		Function<String, String> zuGrossBuchstaben = String::toUpperCase;
		Function<String, String> ausrufezeichenAnfuegen = text -> text + " !!!";
		
		Function<String, String> textZuSchreien = zuGrossBuchstaben.andThen(ausrufezeichenAnfuegen);
		
		System.out.println(textZuSchreien.apply("Lass das sein"));
	}

}
