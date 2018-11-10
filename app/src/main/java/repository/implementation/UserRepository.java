package repository.implementation;

import entity.User;
import org.hibernate.SessionFactory;
import repository.contract.IUserRepository;

public class UserRepository extends Repository<User,Integer> implements IUserRepository {

    public UserRepository(SessionFactory sessionFactory) {

        super(sessionFactory);
    }
}
