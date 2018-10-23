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

	private static void collectionMitWhileAusgeben( ) {
		Iterator<String> iterator = namenCollection.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());			
		}
	}
	
	private static void collectionMitIteratorAusgeben() {
		for (Iterator<String> iterator = namenCollection.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());			
		}
	}

	private static void collectionMitForInAusgeben() {
		for (String string : namenCollection) {
			System.out.println(string);
		}				
	}

	private static void collectionMitForEachAusgeben() {
		namenCollection.forEach(n->System.out.println(n));		
	}	
}
