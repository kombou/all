package entity;

import org.hibernate.SessionFactory;
import persistance.configuration.HibernateConfiguration;
import persistance.configuration.HibernateH2Configuration;
import persistance.configuration.HibernateMysqlConfiguration;

public  class Database {

    private   static HibernateConfiguration  configuration = new HibernateMysqlConfiguration();

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if(sessionFactory == null){

            configuration.configure();

            //ajouter les classes a ce niveau
            configuration.addClass(User.class);

            configuration.buildSessionFactory();
            sessionFactory = configuration.sessionFactory();
        }

        return sessionFactory ;
    }
}
