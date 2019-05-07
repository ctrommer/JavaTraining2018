package strategyHirachy;

/**
 * Hier stark vereinfacht. Die Berechnung der Einkommensteuer ist viel komplexer. Insbesondere wenn sie progressiv ist.
 * Dann muss berücksichtigt werden, wieviel Einkommen sonst erziehlt wird.
 * 
 *
 */
public class EinkommensteuerAbziehStrategie implements SteuernAbziehStrategie{

	@Override
	public Long steuernAbziehen(Long geldBetrag) {
		return Math.round(geldBetrag*0.6);
	}

}
