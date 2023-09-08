package strategyHirachy;

/**
 * Stark vereinfacht:
 * 25% abziehen
 *
 */
public class KapitalertragssteuerAbziehStrategie implements SteuernAbziehStrategie{
	@Override
	public Long zieheSteuernAb( Long geldBetrag ) {
		return Math.round( geldBetrag * 0.75 );
	}
	
}
