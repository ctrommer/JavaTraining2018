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
	 * Verkn�pfung der beiden Regeln
	 */


	@Test
	public void testeRuleChain() {

		Bruch bruch = new Bruch(1, 0);
		System.out.println(bruch);
	}

}