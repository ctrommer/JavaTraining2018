package regeln;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class TestErrorCollector {

	@Rule
	public ErrorCollector errorCollector = new ErrorCollector();

	@Test
	public void testeErrorCollector() {

		try {
			Bruch bruch1 = new Bruch(1, 0);
			System.out.println(bruch1);
		} catch (Exception e) {
			errorCollector.addError(e);
		}

		try {
			Bruch bruch2 = new Bruch(1, 0);
			System.out.println(bruch2);
		} catch (Exception e) {
			errorCollector.addError(e);
		}		

	}

}