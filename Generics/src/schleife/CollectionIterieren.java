package schleife;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class CollectionIterieren {
	static Collection<String> namenCollection = new HashSet<>(); // genauso: new ArrayList<>()
	
	public static void main( String[] args ) {
		namenCollection.add("Uwe");
		namenCollection.add("Karl");
		namenCollection.add("Uta");
		
		System.out.println("iterator: ");
		collectionMitIteratorAusgeben();
		
		System.out.println("for in: ");
		collectionMitForInAusgeben();
		
		System.out.println("while: ");
		collectionMitWhileAusgeben();
		
		System.out.println("for each: ");
		collectionMitForEachAusgeben();
	}

	private static void collectionMitIteratorAusgeben() {		
	}
	
	private static void collectionMitForInAusgeben() {
	}
	
	private static void collectionMitWhileAusgeben( ) {		
	}

	private static void collectionMitForEachAusgeben() {		

	}


}
