package persistance.configuration;

import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

public class HibernateMysqlConfigurationTest {
    @Test
    public void save() {
        HibernateConfiguration configuration = new HibernateMysqlConfiguration();

        configuration.configure();
        configuration.addClass(User.class);
        configuration.buildSessionFactory();

        User user = new User();

        user.setName("KOMBOU");
        user.setSurname("Yvan");

        SessionFactory sessionFactory = configuration.sessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(user);

        session.getTransaction().commit();
        session.close();

        System.out.println("New user Id : " + user.getId());
    }
}
