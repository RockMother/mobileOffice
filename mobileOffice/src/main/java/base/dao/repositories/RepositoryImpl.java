package base.dao.repositories;

import base.dao.contracts.HasLongId;
import base.dao.contracts.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public abstract class RepositoryImpl<T extends HasLongId> implements Repository<T> {

    private Class<T> entityType;
    private SessionFactory sessionFactory;

    public RepositoryImpl(SessionFactory sessionFactory, Class<T> entityType){
        this.sessionFactory = sessionFactory;
        this.entityType = entityType;
    }

    public List<T> getAll(){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery(String.format("Select e from %s e", entityType.getCanonicalName()));
            List<T> result = query.list();
            return result;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return null;
    }

    public T getById(long id){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            return session.find(entityType, id);
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}
