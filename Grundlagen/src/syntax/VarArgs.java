package syntax;

public class VarArgs {
	
	/**
	 * Gebe die als Parameter übergebenen Strings aus.
	 * @param strings
	 * beliebig viele Strings
	 */
	@SafeVarargs
	static void gebeStringsAus( String ... strings ) {
		System.out.println(strings.length);
		
		for (String string : strings) {
			System.out.println(string);			
		}
	}

	/**
	 * Gebe die übergebene Parameter aus.
	 * @param auszugeben
	 * 	beliebig viele Objekte des parameterisierten Typs
	 * @return
	 * gibt die übergebenen Parameter als Array zurück
	 */
	@SafeVarargs
	static <T> T[] gebeAusSafe( T ... auszugeben ) {

		for (T t : auszugeben) {
			System.out.println(t);
		}
		return auszugeben;

	}
	
//	static <T> T[] gebeAusUnSafe( T a, T b ) {
//
//		return gebeAusSafe(a,b);
//
//	}

	public static void main(String[] args) {
		
		// beliebig viele Strings augeben
		gebeStringsAus("a","b","c");
		
		// beliebige Objekte ausgeben
		String[] stringsSafe = gebeAusSafe("a","b","c");
		
//		String[] stringsUnSafe = gebeAusUnSafe( "a", "b");
		
		System.out.println(stringsSafe);
//		System.out.println(stringsUnSafe);		
	}

}
