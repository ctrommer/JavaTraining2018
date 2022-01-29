package injizierenMitBinding;

public class AbteilungsleiterImpl implements Abteilungsleiter {

	/**
	 * Konstruktoren können für just-in-time-binding verwendet werden,
	 * wenn sie nicht private sind und keine Argumente haben. Sie
	 * müssen dann also nicht im module gebunden werden.
	 */
	public AbteilungsleiterImpl() {
	}

	@Override
	public String toString() {
		return "AbteilungsleiterImpl []";
	}
}
