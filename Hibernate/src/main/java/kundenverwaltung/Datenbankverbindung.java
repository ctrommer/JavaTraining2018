package kundenverwaltung;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Stellt Verbindung zur Datenbank Kundenverwaltung dar.
 *
 */
public class Datenbankverbindung {

    /**
     * Nur eine pro Anwendung
     */
    static SessionFactory sessionFactory;
 
    public static SessionFactory holeSessionFactory() {
    	if ( sessionFactory == null ) { 
	        Configuration configuration = new Configuration();
	        configuration.configure("hibernate.cfg.xml");
	 
	        sessionFactory = configuration.buildSessionFactory();
    	}
        return sessionFactory;
    }

	public static void schliesseSessionFactory() {
        if ( sessionFactory != null ) {
        	sessionFactory.close();
        }		
	}

}