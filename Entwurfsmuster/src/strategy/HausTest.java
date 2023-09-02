package strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Predicate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HausTest {

	/**
	 * Haus wird mit der Buchwertstrategie geprüft Buchwert > Marktwert -> guenstig, sonst teuer
	 * 
	 * @param zuBewertendesHaus
	 * @return "Haus ist guenstig" oder "Haus ist teuer"
	 */
	public String bewerteMitBuchwertStrategie( Haus zuBewertendesHaus ) {
		Predicate<Haus> buchwertStrategie = haus -> haus.getBuchwert() > haus.getMarktpreis();
		zuBewertendesHaus.setBewertungsstrategie(buchwertStrategie);
		return zuBewertendesHaus.istHauspreisGuenstig();
	}

	/**
	 * Haus wird mit der Mieteinnahmenstrategie geprüft Jahresmieteinnahmen * 10 > Marktpreis -> guenstig, sonst teuer
	 * 
	 * @param zuBewertendesHaus
	 * @return "Haus ist guenstig" "oder Haus ist teuer"
	 */
	public String bewerteMitMieteinnahmenstrategie( Haus zuBewertendesHaus ) {
		
		Predicate<Haus> mieteinnahmenStrategie 
			= haus -> haus.getJahresMieteinnahmen() * 10 > haus.getMarktpreis();			
		zuBewertendesHaus.setBewertungsstrategie(mieteinnahmenStrategie);		
		return zuBewertendesHaus.istHauspreisGuenstig();
	}

	@Test
	@DisplayName("Buchwertstrategie soll guenstig liefern.")
	public void test01() {
		Haus haus = new Haus( 200_000, 300_000, 30_000 );
		assertEquals( "Haus ist guenstig", bewerteMitBuchwertStrategie( haus ) );
	}

	@Test
	@DisplayName("Buchwertstrategie soll teuer liefern.")
	public void test02() {
		Haus haus = new Haus( 250_000, 200_000, 20_000 ); 
		assertEquals( "Haus ist teuer", bewerteMitBuchwertStrategie( haus) );
	}

	@Test
	@DisplayName("Mieteinnahmenstrategie soll guenstig liefern.")
	public void test03() {
		Haus einfamilienHaus = new Haus( 250_000, 300_000, 30_000 );
		assertEquals( "Haus ist guenstig", bewerteMitMieteinnahmenstrategie( einfamilienHaus ) );
	}

	@Test
	@DisplayName("Mieteinnahmenstrategie soll teuer liefern.")
	public void test04() {		
		Haus mehrfamilienHaus = new Haus( 250_000, 200_000, 20_000 );
		assertEquals( "Haus ist teuer", bewerteMitMieteinnahmenstrategie( mehrfamilienHaus) );
	}

	@Test
	@DisplayName("Ausgabe, wenn keine Bewertungsstrategie vorhanden.")
	public void test05() {
		Haus mehrfamilienHaus = new Haus( 250_000, 200_000, 20_000 );
		assertEquals( "keine Bewertungsstrategie vorhanden", mehrfamilienHaus.istHauspreisGuenstig() );				
	}
}