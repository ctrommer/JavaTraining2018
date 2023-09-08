package strategyHirachy;

/**
 * <pre>
 * Wieviele Steuern abgezogen werden haengt von vielen Faktoren ab:
 * 
 * - Land in dem die Steuern gezahlt werden
 * 
 * - persoenlicher Steuersatz
 * 
 * - Was zu versteuern ist
 * 
 * </pre>
 * 
 * Daher gibt es verschiedene Strategieen der Besteuerung. 
 *
 */
public interface SteuernAbziehStrategie {
	Long zieheSteuernAb( Long geldBetrag );
}
