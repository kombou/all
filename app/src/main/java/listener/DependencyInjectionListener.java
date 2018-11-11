package listener;

import controlleur.UserController;
import entity.Database;
import repository.implementation.UserRepository;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DependencyInjectionListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        UserRepository repository = new UserRepository(Database.getSessionFactory());

        UserController.setRepository(repository);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
