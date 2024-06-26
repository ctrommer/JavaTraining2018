package strategyHirachy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SteuerTest {

	/**
	 * Erzeugt eine Immobilie und zieht die Steuern mit einer {@link EinkommensteuerAbziehStrategie } ab.
	 * @param gewinnVorSteuern
	 * Gewinn, von dem die Steuern abgezogen werden.
	 * 
	 * @return
	 * Gewinn nach Steuern
	 */
	public Long immobilieMitEinkommsteuer( Long gewinnVorSteuern ) {
		Immobilie immobilie = new Immobilie( gewinnVorSteuern, new EinkommensteuerAbziehStrategie() );
		return immobilie.gewinnNachSteuern();
	}
	
	/**
	 * Erzeugt eine Aktie und zieht die Steuern mit einer {@link KapitalertragssteuerAbziehStrategie } ab.
	 * 
	 * @param gewinnVorSteuern
	 * Gewinn, von dem die Steuern abgezogen werden.
	 * @return
	 * Gewinn nach Steuern
	 */
	public Long aktieMitKaptialertrasSteuer( Long gewinnVorSteuern ) {
		Aktie aktie = new Aktie( gewinnVorSteuern, new KapitalertragssteuerAbziehStrategie() );
		return aktie.gewinnNachSteuern();
	}

	/**
	 * Erzeugt eine Aktie.
	 * Zeigt, dass auch ein Lambda reicht fuer eine Strategie: 16 % sollen abgezogen werden
	 * @param gewinnVorSteuern
	 * Gewinn, von dem die Steuern abgezogen werden.
	 * @return
	 * Gewinn nach Steuern
	 */
	public Long aktieMitLambda( Long gewinnVorSteuern ) {
		SteuernAbziehStrategie steuernAbziehStrategie = geldBetrag -> Math.round( geldBetrag * 0.84 ); 
		Aktie aktie = new Aktie( gewinnVorSteuern, steuernAbziehStrategie );
		return aktie.gewinnNachSteuern();
	}
	
	public Immobilie erzeugeImmobilie( Long gewinnVorSteuern, SteuernAbziehStrategie steuernAbziehStrategie ) {
		return new Immobilie(gewinnVorSteuern, steuernAbziehStrategie);
	}

	@Test
	@DisplayName("Wird Einkommensteuer von Immobilie abgezogen?")
	public void test01() {
		assertEquals( 60, immobilieMitEinkommsteuer( 100L ) );
	}

	@Test
	@DisplayName("Wird Kaptialertragssteuer von Aktie abgezogen?")
	public void test02() {
		assertEquals( 75, aktieMitKaptialertrasSteuer( 100L ) );
	}

	@Test
	@DisplayName("Wird Kaptialertragssteuer von Aktie mit Lambda abgezogen?")
	public void test03() {
		assertEquals( 84, aktieMitLambda( 100L ) );
	}

	@Test
	@DisplayName("Wird exception geworfen, wenn null als gewinnVorSteuern uebergeben wird?")
	public void test04() {
		assertThrows(NullPointerException.class, () -> erzeugeImmobilie( null, new KapitalertragssteuerAbziehStrategie() ) );
	}

	@Test
	@DisplayName("Wird exception geworfen, wenn null als SteuernAbziehStrategie uebergeben wird?")
	public void test05() {
		assertThrows(NullPointerException.class, () -> erzeugeImmobilie( 100L, null ) );
	}

}
