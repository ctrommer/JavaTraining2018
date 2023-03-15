package steuerzahler;

import java.time.LocalDateTime;

public class Steuerzahler {
	private Investition investition;
	private LocalDateTime startKonvertierung;

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

	public LocalDateTime getStartKonvertierung() {
		return startKonvertierung;
	}

	public void setStartKonvertierung(LocalDateTime startKonvertierung) {
		this.startKonvertierung = startKonvertierung;
	}

}
