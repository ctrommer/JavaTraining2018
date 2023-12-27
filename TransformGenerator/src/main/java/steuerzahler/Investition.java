package steuerzahler;

public class Investition {
	private Long investitionBetrag;
	private String investitionWaehrung;
	
	public Investition() {
	}

	public Investition( Long investitionBetrag, String investitionWaehrung ) {
		this.investitionBetrag = investitionBetrag;
		this.investitionWaehrung = investitionWaehrung;
	}

	public Long getInvestitionBetrag() {
		return investitionBetrag;
	}

	public void setInvestitionBetrag(Long investitionBetrag) {
		this.investitionBetrag = investitionBetrag;
	}

	public String getInvestitionWaehrung() {
		return investitionWaehrung;
	}

	public void setInvestitionWaehrung(String investitionWaehrung) {
		this.investitionWaehrung = investitionWaehrung;
	}

}
