package base.dao.repositories;

import base.dao.contracts.HasLongId;
import base.dao.contracts.Repository;
import mobileoffice.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public abstract class RepositoryImpl<T extends HasLongId> implements Repository<T> {

    private Class<T> entityType;
    private SessionFactory sessionFactory;

    public RepositoryImpl(Class<T> entityType){
        this.entityType = entityType;
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }

    public List<T> getAll (Session session) {
        String query = String.format("from %s", entityType.getSimpleName());
        List result = session.createQuery(query).list();
        return result;
    }

    public List<T> getAll() throws Exception {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            return getAll(session);
        }
        catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public List<T> findByParameters(String searchQuery, List<Object> parameters, Session session) {
        String query = String.format("from %s WHERE %s", entityType.getSimpleName(), searchQuery);
        Query sessionQuery = session.createQuery(query);
        for (int i = 0; i < parameters.size(); i++) {
            Object parameter = parameters.get(i);
            sessionQuery.setParameter(i, parameter);
        }
        List<T> result = sessionQuery.list();
        return result;
    }

    public List<T> findByParameters(String searchQuery, List<Object> parameters) throws Exception {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            return findByParameters(searchQuery, parameters, session);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }finally {
            session.close();
        }
    }

    public T getById(long id, Session session) {
        return session.find(entityType, id);
    }
    public T getById(long id) throws Exception {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            return getById(id, session);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public T create(T model, Session session) {
        session.save(model);
        return model;
    }

    public T create(T model) throws Exception {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            create(model, session);
            session.getTransaction().commit();
            return model;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public void delete(long id, Session session) throws IllegalAccessException, InstantiationException {
        T item = entityType.newInstance();
        item.setId(id);
        session.delete(item);
    }

    public void delete(long id) throws Exception {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            delete(id, session);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }finally {
            session.flush();
            session.close();
        }
    }

    public void update(T current, Session session) {
        session.save(current);
    }

    @Override
    public void update(T current) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            update(current, session);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }
}
