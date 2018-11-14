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
			int[] zahlen1 = {1,2,3};		
			System.out.println(zahlen1[3]);
		} catch (Exception e) {
			errorCollector.addError(e);
		}

		try {
			int[] zahlen2 = {1,2,3};		
			System.out.println(zahlen2[3]);
		} catch (Exception e) {
			errorCollector.addError(e);
		}		

	}

}