package kundenverwaltung;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Datenbankverbindung {

	static Kunde kunde;
    static Session session;
    static SessionFactory sessionFactory;
 
    private static SessionFactory erzeugeSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build(); 
 
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }
 
    public static void main(String[] args) {
        System.out.println(" - Hibernate Kundenverwaltung - \n");
        try {
            session = erzeugeSessionFactory().openSession();
            session.beginTransaction();
 
            for(int idKunde = 106; idKunde <= 106; idKunde++) {
                kunde = new Kunde();
                kunde.setIdKunde(idKunde);
                kunde.setName("Kunde " + idKunde);
                kunde.setGeburtsjahr(1999);
 
                session.save(kunde);
            }
            System.out.println("\n - Kunden erfolgreich gespeichert - \n");
 
            session.getTransaction().commit();
            
        } catch(Exception sqlException) {
        	sqlException.printStackTrace();
            if(null != session.getTransaction()) {
                System.out.println("\n - roll back der Transaktion - ");
                session.getTransaction().rollback();
            }
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }
}