package regeln;

import java.awt.Toolkit;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

/**
 * Eigene Rule, die bei Fehler piept.
 *
 */
public class MeinePieperRule extends TestWatcher {

	@Override
	protected void failed( Throwable e, Description description ) {
		Toolkit.getDefaultToolkit().beep();
		super.failed( e, description );
	}	
}