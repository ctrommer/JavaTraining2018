package abstrakteFabrik;

public class BoxtrainingFabrik implements Fabrik {

	@Override
	public Trainer erzeugeTrainer() {
		return new Boxtrainer();
	}

	@Override
	public Trainingsgeraet erzeugeTrainingsgeraet() {
		return new Boxhandschuh();
	}

}
