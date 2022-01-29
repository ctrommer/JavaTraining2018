package providenAnnotation;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

class WaldModule extends AbstractModule {

	 @Override
	 protected void configure() {} 
	
	 @Provides
	 public Foerster zurVerfuegungStellenFoerster(){		 
		 return new FoersterImpl("Karl", 42 );
	 }
}
