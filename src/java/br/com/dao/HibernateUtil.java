package br.com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Ricardo
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {

        Configuration configuration = new Configuration();
        configuration.configure("br/com/config/hibernate.cfg.xml");

        sessionFactory = configuration.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {

            sessionFactory = new Configuration().configure().buildSessionFactory();
        }

        return sessionFactory;
    }

    public static Session openSession() {

        return getSessionFactory().openSession();
    }

}
