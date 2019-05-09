package mediator;

public class Laser  {
	
	public void schiessen() {
	}

	public void energieVorratHatSichGeaendert( int restEnergie) {
		System.out.println( restEnergie >= 10 ? " Laser kann noch schiessen." : "Laser hat zu wenig Enerige zum schiessen." );
	}

}
