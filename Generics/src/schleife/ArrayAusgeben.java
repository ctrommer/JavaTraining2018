package schleife;

public class ArrayAusgeben {
	public static void main( String[] args ) {
		arrayMitForSchleifeAusgeben();
		arrayMitForInAusgeben();
		booleanForInSchleife();
	}

	/**
	 * Erzeuge primitives Array von int und gebe es mit einer for Schleife aus.
	 */
	private static void arrayMitForSchleifeAusgeben() {
		int[] intArray = new int[] {1,2,3};
		
		for (int index = 0; index < intArray.length; index++ ) {
			System.out.println(intArray[index]);
		}			
	}	
	
	private static void arrayMitForInAusgeben() {
		int[] intArray = new int[] {1,2,3};
		
		for (int element : intArray) {
			System.out.println(element);
		}			
	}

	private static void booleanForInSchleife() {
		for ( boolean element : new boolean[] { true, false } ) {
			System.out.println(element == true ? "true" : "false");
		}		
	}
	
}
