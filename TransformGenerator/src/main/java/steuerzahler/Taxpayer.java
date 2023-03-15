package steuerzahler;

import java.time.LocalDateTime;

public class Taxpayer {
	private Long investmentAmount;
	private String investmentCurrency;
	
	private LocalDateTime startConversion;
	
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

	public LocalDateTime getStartConversion() {
		return startConversion;
	}

	public void setStartConversion(LocalDateTime startConversion) {
		this.startConversion = startConversion;
	}

}
