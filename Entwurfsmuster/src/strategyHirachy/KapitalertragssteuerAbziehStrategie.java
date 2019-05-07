package strategyHirachy;

public class KapitalertragssteuerAbziehStrategie implements SteuernAbziehStrategie{

	@Override
	public Long steuernAbziehen(Long geldBetrag) {
		return Math.round( geldBetrag * 0.75);
	}
	
}
