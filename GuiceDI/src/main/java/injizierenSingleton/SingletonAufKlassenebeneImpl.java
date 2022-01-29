package injizierenSingleton;

import com.google.inject.Singleton;

@Singleton
public class SingletonAufKlassenebeneImpl implements SingletonAufKlassenebene{

	@Override
	public String toString() {
		return "SingletonAufKlassenebeneImpl []";
	}

}
