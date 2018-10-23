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
		Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
		while( iterator.hasNext() ) {
			Map.Entry<String, String> entry = iterator.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}		

	private static void mapMitIteratorAusgeben() {
		Set<Map.Entry<String, String>> entrySet = map.entrySet();		
		for( Iterator<Map.Entry<String, String>> iterator = entrySet.iterator(); iterator.hasNext(); ) {
			Map.Entry<String, String> entry = iterator.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

	private static void mapMitForInAusgeben() {
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		for (Map.Entry<String, String> entry : entrySet) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

	private static void mapMitForEachAusgeben() {
		map.forEach((k,v)-> System.out.println("key: " + k + " value: " + v ));
	}	
}
