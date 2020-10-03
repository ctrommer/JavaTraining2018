package steuerzahler;

public class Steuerzahler {
	private Investition investition;

	public Steuerzahler() {
	}

	public Steuerzahler(Investition investition) {
		super();
		this.investition = investition;
	}

	public Investition getInvestition() {
		return investition;
	}

	public void setInvestition(Investition investition) {
		this.investition = investition;
	}

}
