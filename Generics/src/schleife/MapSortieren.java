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
		Map<String, String> map = new HashMap<>();
		map.put("key2", "value2");
		map.put("key1", "value1");
		map.put("key3", "value3");
		
		map.forEach((k,v)->System.out.println("key: " + k + " value: " + v  ));

		Map<String, String> treeMap = new TreeMap<>(map);
		
		treeMap.forEach((k,v)->System.out.println("key: " + k + " value: " + v ));		
	}

}
