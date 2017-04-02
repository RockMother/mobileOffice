package base.dao.repositories;

import base.dao.contracts.HasLongId;
import base.dao.contracts.Repository;
import mobileoffice.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
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

    public List<T> findByParameters(String searchQuery, List<Object> parameters) throws Exception {
        Session session = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            String query = String.format("from %s WHERE %s", entityType.getSimpleName(), searchQuery);
            Query sessionQuery = session.createQuery(query);
            for (int i = 0; i < parameters.size(); i++) {
                Object parameter = parameters.get(i);
                sessionQuery.setParameter(i, parameter);
            }
            return sessionQuery.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
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

    public T create(T model) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(model);
            transaction.commit();
            return model;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}
