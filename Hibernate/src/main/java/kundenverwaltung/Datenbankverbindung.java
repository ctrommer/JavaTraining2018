package kundenverwaltung;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Stellt Verbindung zur Datenbank Kundenverwaltung dar.
 *
 */
public class Datenbankverbindung {

    /**
     * Nur eine pro Anwendung
     */
    static SessionFactory sessionFactory;
    
    
    /**
     * Eine pro Arbeitseinheit, nicht eine f�r jede Datenbankoperation
     */
    static Session session;
 
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