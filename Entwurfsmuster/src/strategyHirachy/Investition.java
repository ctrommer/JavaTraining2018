package strategyHirachy;

import java.util.Objects;

public abstract class Investition {
	
	/**
	 * Der Gewinn vor Steuern.
	 */
	private Long gewinnVorSteuern = null;
	
	/**
	 * Es kann vierschiedene Strategieen geben die Steuern abzuziehen.
	 */
	private SteuernAbziehStrategie steuernAbziehStrategie = null;

	/**
	 * Konstruiert eine Investition mit Gewinn vor Steuern und Strategie,
	 * wie die Steuern abgezogen werden.
	 * 
	 * @param gewinnVorSteuern 
	 * der Gewinn, den die Firma erzielt hat
	 * 
	 * @param steuernAbziehStrategie
	 * Strategie, die bestimmt, wie die Steuern abgezogen werden
	 */
	public Investition( Long gewinnVorSteuern, SteuernAbziehStrategie steuernAbziehStrategie ) {
		this.gewinnVorSteuern = Objects.requireNonNull( gewinnVorSteuern );
		this.steuernAbziehStrategie = Objects.requireNonNull( steuernAbziehStrategie );
	}

	/**
	 * Verwendet die Steuernabzieh-Strategie um die Steuern abzuziehen.
	 * @return
	 * Gewinn nach Steuern
	 */
	public Long gewinnNachSteuern() {
		return steuernAbziehStrategie.zieheSteuernAb( gewinnVorSteuern );
	}
	
}
