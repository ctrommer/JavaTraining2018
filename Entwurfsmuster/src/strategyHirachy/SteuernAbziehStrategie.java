package strategyHirachy;

/**
 * <pre>
 * Wieviele Steuern abgezogen werden hängt von vielen Faktoren ab:
 * 
 * - Land in dem die Steuern gezahlt werden
 * 
 * - persönlicher Steuersatz
 * 
 * - Was zu versteuern ist
 * 
 * </pre>
 * 
 * Daher gibt es verschiedene Strategieen der Besteuerung. Man kann damit zur Laufzeit ändern, wie Einkünfte besteuert werden. 
 *
 */
@FunctionalInterface
public interface SteuernAbziehStrategie {

	Long steuernAbziehen(Long geldBetrag);

}
