package regeln;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.RuleChain;

public class TestRuleChain {

	/**
	 * erste Rule
	 */
	public MeinePieperRule meinePieperRule = new MeinePieperRule();

	/**
	 * zweite Rule
	 */	
	@SuppressWarnings("deprecation")
	public ExpectedException expectedException = ExpectedException.none();

	/**
	 * Verknüpfung der beiden Regeln
	 */
	@Rule
	public RuleChain ruleChain = RuleChain.outerRule(meinePieperRule).around(expectedException);

	@Test
	public void testeRuleChain() {
		expectedException.expect(ArrayIndexOutOfBoundsException.class);
		expectedException.expectMessage("3");
		int[] zahlen = {1,2,3};		
		System.out.println(zahlen[3]);
	}

}