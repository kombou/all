package persistance.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public abstract class HibernateConfiguration {

    protected SessionFactory sessionFactory;
    protected Configuration configuration;

    public abstract void configure();

    public void addClass(Class type) {

        configuration.addAnnotatedClass(type);
    }

    public void buildSessionFactory() {

        sessionFactory = configuration.buildSessionFactory();
    }

    public SessionFactory sessionFactory() {
        return sessionFactory;
    }
}
