package prototype;

/**
 * Vorteil:
 * Wenn es einen Soldaten gibt, der sehr häufig erzeugt werden soll, so müssen nur einmal beim Erzeugen die Parameter dafür angeben werden.
 * Dann kann man diesen typischen Soldaten immer wieder erzeugen. Im Verlaufe eines Computerspiels kann sich der Standard Soldat
 * natürlich verändern. Man muss dann nur den Prototyp ändern, kann dann davon wieder neue Kopien erstellen.
 * 
 * Nachteil:
 * Das Schreiben der Copy-Konstruktoren.
 *
 */
public class SoldatAusPrototypFabrik {
	
	private Soldat soldatPrototyp;

	public SoldatAusPrototypFabrik( Soldat prototyp ) {
		super();
		this.soldatPrototyp = prototyp;
	}
	
	public Soldat erzeugeSoldatWiePrototyp() {
		return new Soldat(soldatPrototyp);
	}

	public static void main(String[] args) {
		Soldat prototyp = new Soldat(42);
		
		SoldatAusPrototypFabrik soldatAusPrototypFabrik = new SoldatAusPrototypFabrik(prototyp);
		
		Soldat soldatWiePrototyp = soldatAusPrototypFabrik.erzeugeSoldatWiePrototyp();
		System.out.println(soldatWiePrototyp);
	}

}
