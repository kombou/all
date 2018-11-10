package controlleur;

import entity.Database;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.implementation.UserRepository;

public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    UserRepository repository = new UserRepository(Database.getSessionFactory());


}
