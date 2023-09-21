package kundenverwaltungTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.Serializable;
import java.util.Optional;

import org.hibernate.Session;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import kundenverwaltung.Datenbankverbindung;
import kundenverwaltung.Ehepartner;
import kundenverwaltung.Kunde;
import kundenverwaltung.Name;

public class DatenbankTest {

	/**
	 * nur eine pro Anwendung, also nicht eine fuer jede Datenbankoperation
	 */
	private static Session session;

	@BeforeAll
	public static void datenbankVerbindungAufbauen() {
		session = Datenbankverbindung.holeSessionFactory().openSession();		
	}

	@AfterAll
	public static void datenbankVerbindungSchliessen() {
        if( session != null ) {
            session.close();
        }
        Datenbankverbindung.schliesseSessionFactory();
	}

	@Test
	@DisplayName("Kann ein bereits in der DB gespeicherter Kunde aus der DB gelesen werden?")
	public void test01() {
		Serializable idKunde = 100;
		Kunde kundeAusDB =  ( Kunde ) session.get( Kunde.class, idKunde );
		assertEquals( idKunde, kundeAusDB.getIdKunde() );
	}
	
	@Test
	@DisplayName("Wurde ein neuer Kunde in die DB geschrieben?")
	public void test02() {
		final int idKundeStart = 101;
        try {
            session.beginTransaction(); 
            
    		for(int idKunde = idKundeStart; idKunde <= idKundeStart+1; idKunde++) {
    			Kunde kunde = new Kunde();
    			kunde.setIdKunde(idKunde);
    			kunde.setName(new Name("Vorname" + idKunde, "Nachname" + idKunde));
    			kunde.setGeburtsjahr(1999);
    			kunde.setEhepartner(new Ehepartner(idKunde, kunde, 1999));

    			session.save(kunde);
    		}

    		session.getTransaction().commit();
            
        } catch(Exception sqlException) {
        	sqlException.printStackTrace();
        	Optional
        		.ofNullable( session )
        		.map( Session::getTransaction )
        		.ifPresent( transaction->transaction.rollback() );
        	
        }
        // zum testen ob's geklappt hat
		Kunde kundeAusDB = ( Kunde ) session.get( Kunde.class, idKundeStart );
		assertEquals( idKundeStart, kundeAusDB.getIdKunde() );
	}
	
}
