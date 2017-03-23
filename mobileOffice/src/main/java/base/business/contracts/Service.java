package base.business.contracts;

import base.dao.contracts.HasLongId;
import base.dao.contracts.Repository;

import java.util.List;

/**
 * Created by kisc on 3/23/2017.
 */
public interface Service<R extends Repository<T>, T extends HasLongId> {
    List<T> getAll();
    T getById(long id);
}
