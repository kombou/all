package repository.implementation;

import entity.Database;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.contract.IRepository;

import java.util.ArrayList;

public abstract class Repository<T,ID> implements IRepository<T,ID> {

    protected SessionFactory sessionFactory;
    private Session session;

    public Repository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public ArrayList<T> List() {
        return null;
    }

    @Override
    public T This(ID id) {
        return null;
    }

    @Override
    public T Save(T obj) {
        
        session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(obj);

        session.getTransaction().commit();
        session.close();
        return obj;
    }

    @Override
    public T Update(T obj) {
        return null;
    }

    @Override
    public void Delate(T obj) {

    }
}
