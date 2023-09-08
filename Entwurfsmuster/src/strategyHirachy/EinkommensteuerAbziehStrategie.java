package strategyHirachy;

/**
 * Stark vereinfacht:
 * 40% abziehen
 * 
 */
public class EinkommensteuerAbziehStrategie implements SteuernAbziehStrategie {

	@Override
	public Long zieheSteuernAb( Long geldBetrag ) {
		return Math.round( geldBetrag * 0.6 );
	}

}
