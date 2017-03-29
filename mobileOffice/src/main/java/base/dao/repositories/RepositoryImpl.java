package base.dao.repositories;

import base.dao.contracts.HasLongId;
import base.dao.contracts.Repository;
import mobileoffice.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class RepositoryImpl<T extends HasLongId> implements Repository<T> {

    private Class<T> entityType;

    public RepositoryImpl(Class<T> entityType) {
        this.entityType = entityType;
    }

    public List<T> getAll() throws Exception {
        Session session = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            String query = String.format("from %s", entityType.getSimpleName());
            List result = session.createQuery(query).list();
            return result;
        }
        catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public T getById(long id) throws Exception {
        Session session = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            return session.find(entityType, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}
