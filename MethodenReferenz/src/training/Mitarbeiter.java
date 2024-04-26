package training;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Mitarbeiter {
	private String name;
	private static List<Mitarbeiter> bestenMitarbeiter = new ArrayList<>();

	public Mitarbeiter(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name ;
	}
	
	public static void fuegeBestenMitarbeiterHinzu( Mitarbeiter mitarbeiter ) {
		bestenMitarbeiter.add(mitarbeiter);
	}
	
	public static List<Mitarbeiter> getBestenMitarbeiter() {
		return new ArrayList<Mitarbeiter>( bestenMitarbeiter );
	}

	public void gebeNameAus() {
		System.out.println(name);
	}
	
	public void nameZuGrossbuchstaben() {
		name = name.toUpperCase(Locale.GERMAN);
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mitarbeiter other = (Mitarbeiter) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Test
	@DisplayName("Werden Kleinbuchstaben in Grossbuchstaben umgewandelt?")
	public void test01() {
		assertEquals(
				("kleinbuchstaben").toUpperCase(Locale.GERMAN), 
				kleinZuGrossMitMethodReferenz("kleinbuchstaben") );
	}

	@Test
	@DisplayName("Werden Namen der Mitarbeiter in Grossbuchstaben umgewandelt?")
	public void test02() {		
		List<Mitarbeiter> mitarbeiterListe = Arrays.asList(	new Mitarbeiter("Albert"), new Mitarbeiter("Bert" ) );
		mitarbeiternameZuGrossbuchstabenMitMethodReferenz( mitarbeiterListe );
		assertEquals(
				Arrays.asList( new Mitarbeiter("ALBERT"), new Mitarbeiter("BERT") ), 
				mitarbeiterListe );
	}

	@Test
	@DisplayName("Werden die Fans hinzugefuegt mit Consumer und Lambda?")
	public void test03() {
		Schauspieler arnold = new Schauspieler("I'll be back");
		List<Mitarbeiter> mitarbeiterListe = Arrays.asList( 
														new Mitarbeiter( "Karl" ), 
														new Mitarbeiter( "Hans" ), 
														new Mitarbeiter( "Egon" ) );

		fansHinzufuegenMitConsumerUndLambda( arnold, mitarbeiterListe );		
		
		assertEquals(
				mitarbeiterListe, 
				arnold.getFans() );
	}

	@Test
	@DisplayName("Werden die Fans hinzugefuegt mit Consumer und Method Referenz?")
	public void test04() {
		Schauspieler arnold = new Schauspieler("I'll be back");
		List<Mitarbeiter> neueFansVonArnold = Arrays.asList(
														new Mitarbeiter( "Karl" ), 
														new Mitarbeiter( "Hans" ), 
														new Mitarbeiter( "Egon" ) );

		fansHinzufuegenMitConsumerUndMethodReferenz( arnold, neueFansVonArnold );
		
		assertEquals( 
				neueFansVonArnold, 
				arnold.getFans() );				
	}

	@Test
	@DisplayName("Wird Name in Mitarbeiter umgewandelt mit Lambda und Function?")
	public void test05() {
		assertEquals(
				new Mitarbeiter("Karl"), 
				nameZuMitarbeiterMitLambdaUndFunction("Karl") );
	}

	@Test
	@DisplayName("Wird der Name in Mitarbeiter umgewandelt?")
	public void test06() {
		assertEquals(
				new Mitarbeiter("Karl"), 
				nameZuMitarbeiterMitMethodReferenzUndFunction("Karl") );
	}

	@Test
	@DisplayName("Wird Name in Map mit Name als Key und Mitarbeiter als Value umgewandelt?")
	public void test07( ) {
		Map<String, Mitarbeiter> mitarbeiterMap = new HashMap<>();
		String karl = "Karl";
		mitarbeiterMap.put( karl, new Mitarbeiter( karl ) );

		assertEquals(
				mitarbeiterMap, 
				nameZuMitarbeiterMapMitReferenzAufKonstruktor( karl ) );
	}

	@Test
	@DisplayName("Wird double mit Function in String umgewandelt?")
	public void test08() {
		assertEquals( 
				"42.3", 
				doubleZuStringMitFunctionUndMethodReferenz( 42.3 ) );
	}

	@Test
	@DisplayName("Wird Mitarbeiter zu besten Mitarbeitern hinzugefuegt?")
	public void test09( ) {
		List<Mitarbeiter> mitarbeiterListe = Arrays.asList( new Mitarbeiter( "Karl" ), new Mitarbeiter( "Hans" ), new Mitarbeiter( "Egon" ) );
	
		mitarbeiterZuBestenMitarbeiternHinzufuegenMitReferenzAufStatischeMethode(mitarbeiterListe);

		assertEquals( 
				mitarbeiterListe, 
				Mitarbeiter.getBestenMitarbeiter() );
	}
	


	
	
	

}
