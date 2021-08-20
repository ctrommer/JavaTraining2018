package kundenverwaltungTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.Serializable;

import org.hibernate.Session;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import kundenverwaltung.Datenbankverbindung;
import kundenverwaltung.Ehepartner;
import kundenverwaltung.Kunde;
import kundenverwaltung.Name;

public class DatenbankTest {

	/**
	 * nur eine pro Anwendung
	 */
	private static Session session;

	@BeforeAll
	public static void datenbankVerbindungAufbauen() {
		session = Datenbankverbindung.holeSessionFactory().openSession();		
	}

	@AfterAll
	public static void datenbankVerbindungSchliessen() {
        if(session != null) {
            session.close();
        }
        Datenbankverbindung.schliesseSessionFactory();
	}

	@Test
	public void testeKundeSpeichern() {
		final int idKundeStart = 132;
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
            if(null != session && null != session.getTransaction()) {
                session.getTransaction().rollback();
            }
        }
        // zum testen ob's geklappt hat
		Kunde kundeAusDB =  (Kunde) session.get(Kunde.class, idKundeStart);
		assertEquals(idKundeStart, kundeAusDB.getIdKunde());
	}

	@Test
	public void testeKundeAusDBLesen() {
		Serializable idKunde = 110;
		Kunde kundeAusDB =  (Kunde) session.get(Kunde.class, idKunde);
		assertEquals(idKunde, kundeAusDB.getIdKunde());
	}
	
}
