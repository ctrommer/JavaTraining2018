package steuerzahlerTest;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mapstruct.factory.Mappers;

import steuerzahler.Investition;
import steuerzahler.Steuerzahler;
import steuerzahler.Taxpayer;
import steuerzahler.TaxpayerSteuerzahlerMapper;

public class TaxpayerSteuerzahlerMapperTest {
	private TaxpayerSteuerzahlerMapper taxpayerSteuerzahlerMapper = Mappers.getMapper(TaxpayerSteuerzahlerMapper.class);
	
	@Test
	public void testeTaxpayerZuSteuerzahler() {
		Taxpayer taxpayer = new Taxpayer(100L, "EUR");
		Steuerzahler steuerzahler = taxpayerSteuerzahlerMapper.taxpayerZuSteuerzahler(taxpayer);
		
		assertEquals(taxpayer.getInvestmentAmount(), steuerzahler.getInvestition().getInvestitionBetrag());
		assertEquals(taxpayer.getInvestmentCurrency(), steuerzahler.getInvestition().getInvestitionWaehrung());		
	}
	
	@Test
	public void testeTaxpayerZuSteuerzahlerBetragNull() {
		Taxpayer taxpayer = new Taxpayer(null, "EUR");
		Steuerzahler steuerzahler = taxpayerSteuerzahlerMapper.taxpayerZuSteuerzahler(taxpayer);
		
		assertEquals(null, steuerzahler.getInvestition().getInvestitionBetrag());
		assertEquals(null, steuerzahler.getInvestition().getInvestitionWaehrung());		
	}	
	
	@Test
	public void testeTaxpayerZuSteuerzahlerWaehrungNull() {
		Taxpayer taxpayer = new Taxpayer(100L, null);
		Steuerzahler steuerzahler = taxpayerSteuerzahlerMapper.taxpayerZuSteuerzahler(taxpayer);
		
		assertEquals(null, steuerzahler.getInvestition().getInvestitionBetrag());
		assertEquals(null, steuerzahler.getInvestition().getInvestitionWaehrung());		
	}		

	@Test
	public void testeSteuerzahlerZuTaxpayer() {
		Steuerzahler steuerzahler = new Steuerzahler(new Investition(42L, "Dollar"));		
		Taxpayer taxpayer = taxpayerSteuerzahlerMapper.steuerzahlerZuTaxpayer(steuerzahler);
		
		assertEquals(taxpayer.getInvestmentAmount(), steuerzahler.getInvestition().getInvestitionBetrag());
		assertEquals(taxpayer.getInvestmentCurrency(), steuerzahler.getInvestition().getInvestitionWaehrung());
	}
	
	@Test
	public void testeSteuerzahlerZuTaxpayerBetragNull() {
		Steuerzahler steuerzahler = new Steuerzahler(new Investition(null, "Dollar"));		
		Taxpayer taxpayer = taxpayerSteuerzahlerMapper.steuerzahlerZuTaxpayer(steuerzahler);
		
		assertEquals(null, taxpayer.getInvestmentAmount());
		assertEquals(null, taxpayer.getInvestmentCurrency());
	}

	@Test
	public void testeSteuerzahlerZuTaxpayerWaehrungNull() {
		Steuerzahler steuerzahler = new Steuerzahler(new Investition(200L, null));		
		Taxpayer taxpayer = taxpayerSteuerzahlerMapper.steuerzahlerZuTaxpayer(steuerzahler);
		
		assertEquals(null, taxpayer.getInvestmentAmount());
		assertEquals(null, taxpayer.getInvestmentCurrency());
	}	
	
}
