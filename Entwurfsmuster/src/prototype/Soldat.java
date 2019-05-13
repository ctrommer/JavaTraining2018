package prototype;

public class Soldat {
	private int alter;
	
	public Soldat(int alter) {
		this.alter = alter;
	}

	/**
	 * Laut Joshua Bloch sollte man clone nicht verwenden, daher hier der Copy-Konstruktor.
	 *  
	 * Alternativ könnte man auch eine statische Fabrikmethode verwenden, die einen Soldaten
	 * aus einem Prototyp Soldaten erzeugt.
	 * 
	 * @param kopierVorlage
	 * Der Soldat, von dem eine Kopie erzeugt werden soll.
	 * In diesem Beispiel der Prototyp eines Soldaten.
	 */
	public Soldat( Soldat kopierVorlage ) {
		this.alter = kopierVorlage.alter;
	}

	@Override
	public String toString() {
		return "Soldat [alter=" + alter + "]";
	}

}
