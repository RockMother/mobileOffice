package base.dao.contracts;

import java.util.List;

public interface Repository<T extends HasLongId> {
    List<T> getAll();
    T getById(long Id);
}
