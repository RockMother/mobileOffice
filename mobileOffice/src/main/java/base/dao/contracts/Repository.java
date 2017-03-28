package base.dao.contracts;

import java.util.List;

public interface Repository<T extends HasLongId> {
    List<T> getAll() throws Exception;
    T getById(long Id) throws Exception;
}
