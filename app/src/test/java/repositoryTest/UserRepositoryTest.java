package repositoryTest;

import entity.Database;
import entity.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.implementation.UserRepository;

public class UserRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(UserRepositoryTest.class);

    UserRepository repository = new UserRepository(Database.getSessionFactory());

    @Test
    public void ListTest() {
        for (User user: repository.List()) {
            logger.info("User id "+user.getId());
        }
    }
    @Test
    public void FindByIdTest() {
        User user = new User();
        user = repository.FindById(1);

        logger.info("User name : {}",
                user.getName()
        );
    }

    @Test
    public void SaveTest() {

        User user = new User();

        user.setName("KOUAHOU");
        user.setSurname("Cabrel");

        user = repository.Save(user);

        logger.info("User Id {}",user.getId());
    }

    @Test
    public void UpdateTest() {
        User user = new User();

        user.setName("KOMBOU");
        user.setSurname("Cabrel");
        user.setId(2);

        user = repository.Update(user);

        logger.info("User Name {}",user.getName());
    }

    @Test
    public void DeleteTest() {
        User user = new User();

        user.setId(7);

        repository.Delete(user);
        logger.info("Suppresion ok !!!");
    }
}
