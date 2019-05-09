package mediator;

public class Stromversorgung {
	int energie = 100;
	Mediator mediator;

	
	public int energieWurdeVerbraucht( int energieVerbrauch ) {
		energie -= energieVerbrauch;
		mediator.energieVorratHatSichGeaendert(energie);
		return energie;
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	
}
