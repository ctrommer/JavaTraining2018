package uebersetzen;

import java.util.List;

/**
 * Interface, dass gemockt wird
 *
 */
public interface Uebersetzer {
	String uebersetze( String zuUebersetzen );
	List<String> uebersetzeMitMehrerenErgebnissen( String zuUebersetzen );
}
