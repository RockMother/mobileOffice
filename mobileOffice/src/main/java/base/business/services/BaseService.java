package base.business.services;


import base.business.contracts.Service;
import base.dao.contracts.HasLongId;
import base.dao.contracts.Repository;

import java.util.List;

public abstract class BaseService<R extends Repository<T>, T extends HasLongId> implements Service {

    private R repository;

    public BaseService(R repository) {
        this.repository = repository;
    }

    public List<T> getAll() {
        return repository.getAll();
    }

    public T getById(long id) {
        return repository.getById(id);
    }
}
