package repository.contract;

import java.util.ArrayList;

public interface IRepository<T,ID> {

    ArrayList<T> List();
    T FindById(ID id) ;
    T Save(T obj);
    T Update(T obj);
    void Delete(T obj);

}
