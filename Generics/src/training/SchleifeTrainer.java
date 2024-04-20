package training;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SchleifeTrainer {
	
	private static Collection<String> namenListe = new ArrayList<>();
	
	private static Map<String, String> nameWohnortMap = new LinkedHashMap<String, String>();

	@BeforeAll
	public static void bevorDieTestsStarten() {
		namenListe.add("Uwe");
		namenListe.add("Karl");
		namenListe.add("Uta");
		
		nameWohnortMap.put("Uwe", "Hamburg");
		nameWohnortMap.put("Karl", "Bochum");
		nameWohnortMap.put("Uta", "Aachen");
	}

	/**
	 * Erzeuge aus den Zahlen ein Array.
	 * Ermittle die Summe der Array Elemente mit for Schleife.
	 * 
	 * @param zahl1 erstes aufzusummierendes Element
	 * @param zahl2 zweites aufzusummierendes Element
	 * @param zahl3 drittes aufzusummierendes Element
	 * @return
	 * Summe der Elemente
	 */
	private int summeMitForSchleife( int zahl1, int zahl2, int zahl3 ) {
		int summe = 0;
		
		int[] intArray = new int[] { zahl1, zahl2, zahl3 };
		
		for ( int index = 0; index < intArray.length; index++ ) {
			summe+= intArray[index];
		}
		
		return summe;
	}

	/**
	 * Ermittle die Summe der Array Elemente mit for in loop
	 * 
	 * @param intArray
	 * Feld, dessen Elemente aufsummiert werden
	 * @return
	 * Summe der Elemente
	 */
	private int summeElementeMitForInLoop( int[] intArray ) {
		int summe = 0;
		for (int element : intArray) {
			summe+= element;
		}
		return summe;
	}

	/** 
	 * Erzeuge aus den übergebenen Werten ein Array.
	 * Fuege die Elemente des Arrays mit einer for in loop in eine Liste.
	 * 
	 * @param erster erstes in Liste einzufuegendes Element
	 * @param zweiter zweites in Liste einzufuegendes Element
	 * @param dritter drittes in Liste einzufuegendes Element
	 * @return
	 * Liste der Elemente
	 */
	private List<Boolean> booleanMitForInZuListe( 
										boolean erster, 
										boolean zweiter, 
										boolean dritter ) {
		
		List<Boolean> ergebnis = new ArrayList<>();
		
		boolean[] booleanArray = { erster, zweiter, dritter };
		
		for ( boolean element : booleanArray ) {
			ergebnis.add( element );
		}
		
		return ergebnis;
	}


	private String collectionMitIteratorZuString( Collection<String> namenCollection ) {
		StringBuilder aneinandergehaengt = new StringBuilder();

		for ( Iterator<String> iterator = namenCollection.iterator(); iterator.hasNext(); ) {
			aneinandergehaengt.append( iterator.next() );			
		}
		return aneinandergehaengt.toString();
	}

	private String collectionMitForInZuString( Collection<String> namenCollection ) {
		StringBuilder aneinandergehaengt = new StringBuilder();

		for (String element: namenCollection) {
			aneinandergehaengt.append( element );
		}
		return aneinandergehaengt.toString();
	}

	private String collectionMitWhileZuString( Collection<String> namenCollection ) {
		StringBuilder aneinandergehaengt = new StringBuilder();

		Iterator<String> iterator = namenCollection.iterator();
		while ( iterator.hasNext( ) ) {
			aneinandergehaengt.append( iterator.next() );
		}
		return aneinandergehaengt.toString();
	}

	private List<String> collectionMitForEachZuListe( Collection<String> namenCollection ) {
		List<String> ergebnisListe = new ArrayList<>();

		namenCollection.forEach( text -> ergebnisListe.add( text ) );

		return ergebnisListe;
	}

	private void elementAusListeLoeschenMitIterator( 
											Collection<String> liste, 
											String zuLoeschenderEintrag ) {
		for ( Iterator<String> iterator = liste.iterator(); iterator.hasNext(); ) {
			String name = iterator.next();
			if ( Objects.equals( name, zuLoeschenderEintrag ) ) {
				iterator.remove();
			}
		}
	}

	private void elementAusListeLoeschenMitPredicate( 
												Collection<String> liste, 
												String zuLoeschenderEintrag ) {
		namenListe.removeIf( name -> Objects.equals( name, "Uta" ) );
	}

	/**
	 * Fuegt key und value aller map Eintraege ohne Leerzeichen
	 * zu einem String zusammen.
	 * z.B.: UweHamburgKarlBochum 
	 * 
	 * @param map die Werte, die zusammengefuegt werden sollen
	 * @return key und value aller Eintaege ohne Leerzeichen
	 */
	private String mapMitWhileZuString( Map<String, String> map  ) {
		String aneinandergehaengt = "";

		Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
		while( iterator.hasNext() ) {
			Map.Entry<String, String> entry = iterator.next();
			aneinandergehaengt+= entry.getKey() + entry.getValue();
		}
		return aneinandergehaengt;
	}

	private String mapMitIteratorZuString( Map<String, String> map  ) {
		String aneinandergehaengt = "";

		Set<Map.Entry<String, String>> entrySet = map.entrySet();		
		for( Iterator<Map.Entry<String, String>> iterator = entrySet.iterator(); iterator.hasNext(); ) {
			Map.Entry<String, String> entry = iterator.next();
			aneinandergehaengt+= entry.getKey() + entry.getValue();
		}
		return aneinandergehaengt;
	}

	private String mapMitForInZuString( Map<String, String> map  ) {
		String aneinandergehaengt = "";

		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		for ( Map.Entry<String, String> entry : entrySet ) {
			aneinandergehaengt +=entry.getKey()  + entry.getValue();
		}
		return aneinandergehaengt;
	}

	private Map<String, String> mapMitForEachZuMapKeyValueVertauscht( Map<String, String> map ) {
		Map<String, String> keyValueVertauscht = new LinkedHashMap<String, String>();

		map.forEach( ( key, value ) -> keyValueVertauscht.put( value, key) );
		
		return keyValueVertauscht;
	}

	private static Map<String, String> sortiereMapNachKey( Map<String, String> map ) {
		Map<String, String> treeMap = new TreeMap<>(map);
		return treeMap;		
	}
	
}
