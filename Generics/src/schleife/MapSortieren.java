package schleife;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapSortieren {
	public static void main(String[] args) {
		sortiereMapNachKey();		
	}
	
	/**
	 * Erzeuge eine unsortierte Map, sortiere sie nach ihrem key und gebe sie aus.
	 */
	private static void sortiereMapNachKey() {
		Map<String, String> hashMap = new HashMap<>();
		hashMap.put("key5", "value5");
		hashMap.put("key4", "value4");
		hashMap.put("key2", "value2");
		hashMap.put("key1", "value1");
		hashMap.put("key3", "value3");
		
		hashMap.forEach((k,v)->System.out.println("key: " + k + " value: " + v  ));

		Map<String, String> treeMap = new TreeMap<>(hashMap);
		
		treeMap.forEach((k,v)->System.out.println("key: " + k + " value: " + v ));		
	}

}
