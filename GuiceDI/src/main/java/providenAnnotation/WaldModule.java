package providenAnnotation;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

class WaldModule extends AbstractModule {

	 @Override
	 protected void configure() {} 

	 // Stelle keine Verbindung in configure her, 
	 // sondern verwende eine Methode, die den 
	 // Foerster zur Verfuegung stellt.

}
