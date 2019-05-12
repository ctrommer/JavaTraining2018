package fabrikMethodeAbstrakteFabrik;

public class GriechischeArmeeFabrikMethode extends ArmeeAbstrakteFabrik {

	@Override
	public Soldat erzeugeSoldat() {
		return new GriechischerSoldat();
	}

	@Override
	public Schiff erzeugeSchiff() {
		return new GriechischesSchiff();
	}

}
