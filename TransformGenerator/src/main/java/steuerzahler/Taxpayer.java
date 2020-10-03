package steuerzahler;

public class Taxpayer {
	private Long investmentAmount;
	private String investmentCurrency;
	
	public Taxpayer() {
	}

	public Taxpayer(Long investmentAmount, String investmentCurrency) {
		this.investmentAmount = investmentAmount;
		this.investmentCurrency = investmentCurrency;
	}

	public Long getInvestmentAmount() {
		return investmentAmount;
	}

	public void setInvestmentAmount(Long investmentAmount) {
		this.investmentAmount = investmentAmount;
	}

	public String getInvestmentCurrency() {
		return investmentCurrency;
	}

	public void setInvestmentCurrency(String investmentCurrency) {
		this.investmentCurrency = investmentCurrency;
	}


}
