package injizierenMitBinding;

public class AbteilungsleiterImpl implements Abteilungsleiter {

	/**
	 * Konstruktoren k�nnen f�r just-in-time-binding verwendet werden,
	 * wenn sie nicht private sind und keine Argumente haben. Sie
	 * m�ssen dann also nicht im module gebunden werden.
	 */
	public AbteilungsleiterImpl() {
	}

	@Override
	public String toString() {
		return "AbteilungsleiterImpl []";
	}
}
