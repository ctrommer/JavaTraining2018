package abstrakteFabrik;

public class WaffentrainingFabrik implements Fabrik {

	@Override
	public Trainer erzeugeTrainer() {
		return new Waffentrainer();
	}

	@Override
	public Trainingsgeraet erzeugeTrainingsgeraet() {
		return new Messer();
	}

}
