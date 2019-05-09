package mediator;

public class Laser  {
	Mediator mediator;
	

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
	
	public void schiessen() {
		mediator.energieWurdeVerbraucht( 10 );
	}

	public void energieVorratHatSichGeaendert( int restEnergie) {
		System.out.println( restEnergie >= 10 ? " Laser kann noch schiessen." : "Laser hat zu wenig Enerige zum schiessen." );
	}

}
