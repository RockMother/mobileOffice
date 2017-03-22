package base.contracts;

import java.util.List;

public interface Repository<T extends HasLongId> {
    List<T> getAllEntities();
    T getById(long Id);
}
