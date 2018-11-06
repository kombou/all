package persistance.configuration;

import org.hibernate.cfg.Configuration;



public class HibernateMysqlConfiguration extends HibernateConfiguration{

    @Override
    public void configure() {

        configuration = new Configuration();

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect")
                     .setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                     .setProperty("hibernate.connection.url", "jdbc:mysql://127.0.0.1:3306/app_orion")
                     .setProperty("hibernate.connection.username", "root")
                     .setProperty("hibernate.connection.password", "")
                     .setProperty("hibernate.hbm2ddl.auto", "update");
    }
}
