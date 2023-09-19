package syntax;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StaticImportTrainer {
	
	public Integer mitStaticImportIntMaxValue() {
		return null;
	}

	@DisplayName("Wird MAX_VALUE statisch importiert?")
	@Test
	public void test01() {
		Assertions.assertEquals( 2147483647, mitStaticImportIntMaxValue() );
	}
}
