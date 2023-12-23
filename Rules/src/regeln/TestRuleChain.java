package regeln;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.RuleChain;

public class TestRuleChain {

	/**
	 * erste Rule
	 */

	/**
	 * zweite Rule
	 */	

	/**
	 * Verknüpfung der beiden Regeln
	 */

	@Test
	public void testeRuleChain() {
		int[] zahlen = {1,2,3};		
		System.out.println(zahlen[3]);
	}

}