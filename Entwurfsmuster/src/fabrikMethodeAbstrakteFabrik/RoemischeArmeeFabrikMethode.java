package fabrikMethodeAbstrakteFabrik;

public class RoemischeArmeeFabrikMethode extends ArmeeAbstrakteFabrik {

	@Override
	public Soldat erzeugeSoldat() {
		return new RoemischerSoldat();
	}

	@Override
	public Schiff erzeugeSchiff() {
		return new RoemischesSchiff();
	}

}
