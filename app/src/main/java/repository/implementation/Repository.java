package repository.implementation;

import entity.Database;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.contract.IRepository;

import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

public abstract class Repository<T,ID> implements IRepository<T,ID> {

    protected SessionFactory sessionFactory;
    protected Class<T> type;

    public Repository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        type = (Class<T>) ((ParameterizedType)(getClass().getGenericSuperclass())).getActualTypeArguments()[0];

        if(type == null) {

            throw new NullPointerException("Cette couche d'acces au données ne contient pas de classe");
        }
    }

    @Override
    public ArrayList<T> List() {

        ArrayList<T> list = new ArrayList<T>();
        Session session =  sessionFactory.openSession();
        session.beginTransaction();

        try {

            Query query = session.createQuery("SELECT t FROM "+ type.getSimpleName().toLowerCase() +" t") ;
            list = (ArrayList<T>) query.getResultList();

            session.getTransaction().commit();

        }catch (Exception e){
            session.getTransaction().rollback();
            throw new RuntimeException("Problème lors de la génération de la liste des",e);
        }
        return list;
    }

    @Override
    public T FindById(ID id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        T t ;

        try {
            t = session.find(type,id);
            session.getTransaction().commit();
        }catch (Exception e) {

            session.getTransaction().rollback();
            throw new RuntimeException("Erreur lors de la recherche .",e);
        }finally {
            session.close();
        }
        return t;
    }

    @Override
    public T Save(T obj) {

       Session session = sessionFactory.openSession();
       session.beginTransaction();

        try {

            session.save(obj);
            session.getTransaction().commit();

        }catch (Exception e) {

            session.getTransaction().rollback();

            throw new RuntimeException("Erreur lors de la sauvegarde d'objet.", e);

        }finally {

            session.close();
        }


        return obj;
    }

    @Override
    public T Update(T obj) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {

            session.update(obj);
            session.getTransaction().commit();

        }catch (Exception e) {

            session.getTransaction().rollback();
            throw new RuntimeException("Erreur lors de la mise a jour.",e);
        }finally {
            session.close();
        }
        return obj;
    }

    @Override
    public void Delete(T obj) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {

            session.delete(obj);
            session.getTransaction().commit();

        }catch (Exception e) {
            session.getTransaction().rollback();
            throw new RuntimeException("Erreur lors de la supression.",e);
        }finally {
            session.close();
        }
    }
}
