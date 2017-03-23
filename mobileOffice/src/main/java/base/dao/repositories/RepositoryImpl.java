package base.dao.repositories;

import base.dao.contracts.HasLongId;
import base.dao.contracts.Repository;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class RepositoryImpl<T extends HasLongId> implements Repository<T> {

    SessionFactory sessionFactory;

    public RepositoryImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public List<T> getAll(){
        return new ArrayList<T>();
    }

    public T getById(long id){
        return null;
    }

}
