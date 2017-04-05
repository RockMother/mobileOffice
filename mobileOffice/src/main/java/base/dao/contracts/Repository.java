package base.dao.contracts;

import mobileoffice.dao.entities.Tariff;

import java.util.List;

public interface Repository<T extends HasLongId> {
    List<T> getAll() throws Exception;
    T getById(long Id) throws Exception;
    List<T> findByParameters(String searchQuery, List<Object> parameters) throws Exception;
    T create(T model) throws Exception;
    void delete(long id) throws Exception;
    void update(Tariff current);
}
