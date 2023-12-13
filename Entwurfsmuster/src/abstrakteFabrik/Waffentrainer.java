package abstrakteFabrik;

public class Waffentrainer implements Trainer {
	@Override
	public String unterrichte( Trainingsgeraet trainingsgeraet ) {
		return "Ich habe Waffen trainiert mit " + trainingsgeraet.holeName();
	}
}
