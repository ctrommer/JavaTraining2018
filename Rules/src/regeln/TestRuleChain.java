package regeln;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.RuleChain;

public class TestRuleChain {

	/**
	 * erste Rule
	 */
	@Rule
	public MeinePieperRule meinePieperRule = new MeinePieperRule();

	/**
	 * zweite Rule
	 */	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	/**
	 * Verknüpfung der beiden Regeln
	 */
	@Rule
	public RuleChain ruleChain = RuleChain.outerRule(meinePieperRule).around(expectedException);

	@Test
	public void testeRuleChain() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("Zaehler darf nicht null sein.");
		Bruch bruch = new Bruch(1, 0);
		System.out.println(bruch);
	}

}