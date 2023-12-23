package test.mitJUnit4.eigeneRegel;

import org.junit.Rule;
import org.junit.Test;

public class MeineRegelVerwender {
	
	@Rule
	public MeineRegel meineRegel = new MeineRegel();
	
	@Test
	public void testeNullDivision() {
		int x = 1 / 0;
		System.out.println( meineRegel.getBasis() );
		System.out.println( x );
	}	
}