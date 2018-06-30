package optionalBeispiel;

import java.util.Optional;

public class OptionalErzeugen {

	public static void main(String[] args) {
		leeresOptional();
		optionalVonString();
		optionalVonNull();
	}

	private static void leeresOptional() {
		Optional<String> vielleichtText = Optional.empty();
		vielleichtText.ifPresent(System.out::println);
	}

	private static void optionalVonString() {
		Optional<String> vielleichtText = Optional.of("Hallo");		
		vielleichtText.ifPresent(System.out::println);
	}

	private static void optionalVonNull() {
		// Optional<String> vielleichtText = Optional.of(null);	// -> Exception
		Optional<String> vielleichtText = Optional.ofNullable(null);
		vielleichtText.ifPresent(System.out::println);
	}
}
