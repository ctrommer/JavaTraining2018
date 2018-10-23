package schleife;

public class ArrayAusgeben {
	public static void main( String[] args ) {
		arrayMitForSchleifeAusgeben();
		arrayMitForInAusgeben();		
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
	
	
	
}
