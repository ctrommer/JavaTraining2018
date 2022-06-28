package abstrakteFabrik;

public class Boxtrainer implements Trainer {
	
	@Override
	public String unterrichte(Trainingsgeraet trainingsgeraet) {
		return "Ich habe Boxen trainiert mit " + trainingsgeraet.holeName();
	}
}
