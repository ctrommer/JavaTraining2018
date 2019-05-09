package mediator;

/**
 * Es gibt einen Laser, der bei jedem Schuss 10 Energie verbraucht und eine Stromversorgung, die am Anfang 100 Energie hat.
 * Solange noch 10 Energie in der Stomversorgung sind kann der Laser schiessen. Löse die Aufgabe mit einem Mediator.
 *
 * Erweitungsmöglichkeiten:
 * - Der Mediator kann eine Liste von Stomverbrauchern und Stromerzeugern haben.
 * 
 */
public class Mediator {
	private Laser laser;
	private Stromversorgung stromversorgung;
	
	public Mediator( Laser laser, Stromversorgung stromversorgung) {
		super();
		stromversorgung.setMediator(this);
		laser.setMediator(this);
		this.laser = laser;
		this.stromversorgung = stromversorgung;
		
	}

	public void energieWurdeVerbraucht(int energieVerbrauch) {
		stromversorgung.energieWurdeVerbraucht(energieVerbrauch);		
	} 
	
	public void energieVorratHatSichGeaendert(int restEnergie) {
		laser.energieVorratHatSichGeaendert(restEnergie);
	}
	
	public static void main( String[] args ) {
		Laser laser = new Laser();
		Stromversorgung stromversorgung = new Stromversorgung();
		@SuppressWarnings("unused")
		Mediator mediator = new Mediator(laser, stromversorgung);
		for ( int schuss = 1; schuss < 20; schuss++ ) {
			laser.schiessen();
		}
	}
}
