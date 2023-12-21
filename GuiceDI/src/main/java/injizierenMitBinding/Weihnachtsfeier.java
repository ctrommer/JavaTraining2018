package injizierenMitBinding;

public class Weihnachtsfeier {
	
	Boolean findetStatt;

	public Weihnachtsfeier( boolean findetStatt ) {
		this.findetStatt = findetStatt;
	}

	@Override
	public String toString() {
		return "Weihnachtsfeier [findetStatt=" + findetStatt + "]";
	}

}
