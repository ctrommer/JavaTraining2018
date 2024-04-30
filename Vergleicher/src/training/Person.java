package training;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Person {

    private final String name;
    private final Integer alter;

    public Person( String name, Integer alter ) {
		this.name = name;
		this.alter = alter;
	}    

    public Person( String name, Integer alter, String vorname ) {
		this.name = name;
		this.alter = alter;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + alter + "]";
	}

	public String getName() { return name; }	
    public Integer getAlter() { return alter; }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alter == null) ? 0 : alter.hashCode());
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
		Person other = (Person) obj;
		if (alter == null) {
			if (other.alter != null)
				return false;
		} else if (!alter.equals(other.alter))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Test
	@DisplayName("Wurde Person nach Name sortiert mit anonymer innerer Klasse?")
	public void test01() {
		sortierePersonNachNameMitAnonymerInnererKlasse();
		
		assertEquals( 
				nachNameSortiertePersonen, 
				zuSortierendePersonen );
	}
	
	@Test
	@DisplayName("Wurde Person nach Name sortiert mit Lambda?")
	public void test02() {
		sortierePersonNachNameMitLambda();
		
		assertEquals(
				nachNameSortiertePersonen, 
				zuSortierendePersonen );
	}	

	@Test
	@DisplayName("Wurde Person nach Name sortiert mit Comparator und Function als Lambda?")
	public void test03() {
		sortierePersonNachNameMitLambdaUndFunction();
		assertEquals(
				nachNameSortiertePersonen, 
				zuSortierendePersonen );
	}

	@Test
	@DisplayName("Wurde Person nach Name sortiert mit statischer Methode von Comparator?")
	public void test04() {
		sortierePersonNachNameMitStatischerMethodeVonComparator();
		
		assertEquals(
				nachNameSortiertePersonen, 
				zuSortierendePersonen );
	}

	@Test
	@DisplayName("Wurde Person nach Name rueckwaerts sortiert?")
	public void test05() {
		List<Person> nachNameRueckwaertsSortiertePersonen = Arrays.asList( 
																	new Person ( "Waltraut", 80 ) , 
																	new Person ( "Waltraut", 70 ), 
																	new Person ( "Kevin", 50 ), 
																	new Person( "KEVIN", 40 ),  
																	new Person ( "Andreas", 30 ) );

		sortierePersonNachNameRueckwaerts();
		assertEquals(
				nachNameRueckwaertsSortiertePersonen, 
				zuSortierendePersonen );
	}

	@Test
	@DisplayName("Wurde Person nach Name rueckwaerts sortiert Gross- Kleinschreibung ignorierend?")
	public void test06() {
		List<Person> nachNameRueckwaertsGrossKleinIgnorierendSortiertePersonen = Arrays.asList( 
																							new Person ( "Waltraut", 80 ) , 
																							new Person ( "Waltraut", 70 ), 
																							new Person ("Kevin", 50 ), 
																							new Person( "KEVIN", 40 ),  
																							new Person ( "Andreas", 30 ) );
		
		sortierePersonNachNameRueckwaertsGrossKleinSchreibungIgnorierend();
		assertEquals(
				nachNameRueckwaertsGrossKleinIgnorierendSortiertePersonen, 
				zuSortierendePersonen );
	}

	@Test
	@DisplayName("Wurde Person nach Name Rueckwaerts und dann nach Alter sortiert?")
	public void test07() {		
		List<Person> nachNameDannNachAlterSortiertePersonen = Arrays.asList( 
																		new Person ( "Waltraut", 70 ), 
																		new Person ( "Waltraut", 80 ), 
																		new Person ( "Kevin", 50 ), 
																		new Person( "KEVIN", 40 ), 
																		new Person ( "Andreas", 30 ) );
		
		sortierePersonNachNameRueckwaertsUndDannNachAlter();
		assertEquals(
				nachNameDannNachAlterSortiertePersonen, 
				zuSortierendePersonen );
	}

	@Test
	@DisplayName("Wurde Person nach Name mit Nullwerten und dann nach Alter soritert?")
	public void test08() {
	
		List<Person> nachNameUndAlterSortiertePersonenMitNull = Arrays.asList( 
																		new Person ( "Andreas", 30 ), 
																		new Person("KEVIN", 40 ), 
																		new Person ("Kevin", 50 ), 
																		new Person ( "Waltraut", 70 ), 
																		new Person ( "Waltraut", 80 ), 
																		null, 
																		null );

		sortierePersonNachNameMitNullZuletztUndDannNachAlter();

		assertEquals(
				nachNameUndAlterSortiertePersonenMitNull, 
				zuSortierendePersonenMitNull );
	}

	@Test
	@DisplayName("Wurden Angestellte nach natuerlicher Ordnung sortiert?")
	public void test09() {
		List<Angestellter> nachNatuerlicherOrdnungSortierteAngestellte = Arrays.asList(
																					new Angestellter(30), 
																					new Angestellter(40), 
																					new Angestellter(50), 
																					new Angestellter(60) );
		sortiereAngestellteNachNatuerlicherOrdnung();
		assertEquals(
				nachNatuerlicherOrdnungSortierteAngestellte, 
				zuSortierendeAngestellte );
	}
	

	
}
