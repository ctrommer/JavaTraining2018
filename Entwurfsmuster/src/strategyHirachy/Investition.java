package strategyHirachy;

public abstract class Investition {
	
	/**
	 * Es kann vierschiedene Strategieen geben die Steuern abzuziehen.
	 */
	private SteuernAbziehStrategie steuernAbziehStrategie;

	/**
	 * Die Strategie, wie die Steuern abgezogen werden, kann im Konstruktor gesetzt werden.
	 * @param steuernAbzieher
	 * Strategie, die bestimmt, wie die Steuern abgezogen werden
	 */
	public Investition(SteuernAbziehStrategie steuernAbzieher) {
		super();
		this.steuernAbziehStrategie = steuernAbzieher;
	}

	/**
	 * Verwendet die Strategie um die Steuern abzuziehen.
	 * @param geldBetragVorSteuern
	 * Geldbetrag vor Steuern
	 * @return
	 * Geldbetrag nach Steuern
	 */
	public Long zieheSteuernAb(Long geldBetragVorSteuern) {
		return steuernAbziehStrategie.steuernAbziehen( geldBetragVorSteuern );
	}

	/**
	 * Auch zur Laufzeit kann die Strategie geändert werden, wie man Steuern abzieht.
	 * @param steuernAbziehStrategie
	 * Strategie, wie die Steuern abgezogen werden.
	 */
	public void setSteuernAbziehStrategie(SteuernAbziehStrategie steuernAbziehStrategie) {
		this.steuernAbziehStrategie = steuernAbziehStrategie;
	}

	
}
