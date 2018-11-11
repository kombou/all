package controlleur;

import entity.Database;
import entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.implementation.UserRepository;

public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    private static UserRepository _repository ;

    public static void setRepository(UserRepository repository) {
        _repository = repository;
    }

    public void Create(User user) {
        _repository.Save(user);
    }

}
