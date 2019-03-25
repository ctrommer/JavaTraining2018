package test.mitJUnit4.eigeneRegel;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class MeineRegel implements TestRule{
	// https://www.vogella.com/tutorials/JUnit/article.html#exercise-using-junit
	private Statement basis;
	private Description beschreibung;
	
	@Override
	public Statement apply( Statement basis, Description beschreibung ) {
		this.basis = basis;
		this.beschreibung = beschreibung;
		return new MeinBericht( basis );
	}
	
	public class MeinBericht extends Statement {
		private final Statement basis;
		
		public MeinBericht( Statement basis ) {
			this.basis = basis;
		}

		@Override
		public void evaluate() throws Throwable {
			System.out.println( "Start von MeinRegel - Klasse " + beschreibung.getClassName() + " Methode: " + beschreibung.getMethodName() );
            try {            	
                basis.evaluate();
            } finally {
            	System.out.println( "Ende von MeinRegel - Klasse " + beschreibung.getClassName() + " Methode: " + beschreibung.getMethodName() );
            }
		}		
	}

	public Statement getBasis() {
		return basis;
	}
	
}
