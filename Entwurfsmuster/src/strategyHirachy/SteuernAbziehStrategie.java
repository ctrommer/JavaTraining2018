package strategyHirachy;

/**
 * <pre>
 * Wieviele Steuern abgezogen werden h�ngt von vielen Faktoren ab:
 * 
 * - Land in dem die Steuern gezahlt werden
 * 
 * - pers�nlicher Steuersatz
 * 
 * - Was zu versteuern ist
 * 
 * </pre>
 * 
 * Daher gibt es verschiedene Strategieen der Besteuerung. Man kann damit zur Laufzeit �ndern, wie Eink�nfte besteuert werden. 
 *
 */
@FunctionalInterface
public interface SteuernAbziehStrategie {

	Long steuernAbziehen(Long geldBetrag);

}
