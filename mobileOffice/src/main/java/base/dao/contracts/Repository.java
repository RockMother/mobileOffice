package base.dao.contracts;

import org.hibernate.Session;

import java.util.List;

public interface Repository<T extends HasLongId> {
    Session getSession();
    List<T> getAll() throws Exception;
    List<T> getAll(Session session) throws Exception;
    T getById(long Id) throws Exception;
    T getById(long Id, Session session) throws Exception;
    List<T> findByParameters(String searchQuery, List<Object> parameters) throws Exception;
    List<T> findByParameters(String searchQuery, List<Object> parameters, Session session);
    List<T> findByParameter(String searchQuery, Object parameter, Session session) throws Exception;
    List<T> findByParameter(String searchQuery, Object parameter) throws Exception;
    T create(T model) throws Exception;
    T create(T model,Session session);
    void delete(T entity, Session session);
    void delete(long id) throws Exception;
    void delete(long id, Session session) throws IllegalAccessException, InstantiationException;
    void update(T current);
    void update(T current, Session session);
}
