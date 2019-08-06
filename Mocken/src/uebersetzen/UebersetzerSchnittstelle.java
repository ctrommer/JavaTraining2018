package uebersetzen;

import java.util.List;

/**
 * Schnittstelle, die getestet werden soll.
 *
 */
public class UebersetzerSchnittstelle {
	
	String uebersetze( Uebersetzer uebersetzer, String zuUebersetzen ) {
		return uebersetzer.uebersetze(zuUebersetzen);
	}
	
	List<String> uebersetzeMitMehrerenErgebnissen( Uebersetzer uebersetzer, String zuUebersetzen ) {
		return uebersetzer.uebersetzeMitMehrerenErgebnissen(zuUebersetzen);
	}
	
}
