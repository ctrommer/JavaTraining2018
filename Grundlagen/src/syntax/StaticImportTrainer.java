package syntax;

import static java.lang.Integer.MAX_VALUE;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StaticImportTrainer {
	
	public Integer mitStaticImportIntMaxValue() {
		return MAX_VALUE;
	}

	@DisplayName("Wird MAX_VALUE statisch importiert?")
	@Test
	public void test01() {
		Assertions.assertEquals( 
						2147483647, 
						mitStaticImportIntMaxValue() );
	}
}
