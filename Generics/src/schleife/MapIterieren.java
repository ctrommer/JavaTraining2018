package schleife;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapIterieren {
	
	static Map<String, String> map = new HashMap<>();
	
	public static void main( String[] args ) {
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		
		System.out.println("iterator: ");
		mapMitIteratorAusgeben();
		
		System.out.println("for in: ");
		mapMitForInAusgeben();
		
		System.out.println("while: ");
		mapMitWhileAusgeben();
		
		System.out.println("for each: ");
		mapMitForEachAusgeben();
	}

	private static void mapMitWhileAusgeben( ) {
	}		

	private static void mapMitIteratorAusgeben() {		
	}

	private static void mapMitForInAusgeben() {
	}

	private static void mapMitForEachAusgeben() {
	}	
}
