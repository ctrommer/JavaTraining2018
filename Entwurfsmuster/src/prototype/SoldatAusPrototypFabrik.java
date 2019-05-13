package prototype;

/**
 * Vorteil:
 * Wenn es einen Soldaten gibt, der sehr h�ufig erzeugt werden soll, so m�ssen nur einmal beim Erzeugen die Parameter daf�r angeben werden.
 * Dann kann man diesen typischen Soldaten immer wieder erzeugen. Im Verlaufe eines Computerspiels kann sich der Standard Soldat
 * nat�rlich ver�ndern. Man muss dann nur den Prototyp �ndern, kann dann davon wieder neue Kopien erstellen.
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
