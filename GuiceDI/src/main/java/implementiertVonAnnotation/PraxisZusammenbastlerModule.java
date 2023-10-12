package implementiertVonAnnotation;

import com.google.inject.AbstractModule;

public class PraxisZusammenbastlerModule extends AbstractModule {

	/**
	 * Hier muss keine Bindung hergestellt werden, da die Bindung
	 * implizit ueber just-in-time Bindings hergestellt wird.
	 * In diesem Fall kann die Methode natürlich ganz weggelassen werden,
	 * ist hier nur da um zu zeigen, dass hier nichts passiert. 
	 * 
	 * Die implizite Bindung ueber just-in-time-binding wird nur
	 * verwendet, wenn es keine explizite Bindung gibt.
	 * 
	 */
	@Override
	protected void configure() {
		super.configure();
	}
}
