package strategyHirachy;

public class Aktie extends Investition {

	public Aktie( Long gewinnVorSteuern, SteuernAbziehStrategie steuernAbziehStrategie ) {
		super( gewinnVorSteuern, steuernAbziehStrategie );
	}
	
}
