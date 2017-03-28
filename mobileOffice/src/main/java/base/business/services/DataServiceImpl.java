package base.business.services;


import base.business.contracts.DataService;
import base.dao.contracts.HasLongId;
import base.dao.contracts.Repository;

import java.util.List;

public abstract class DataServiceImpl<R extends Repository<T>, T extends HasLongId> implements DataService<R, T> {

    private R repository;

    public DataServiceImpl(R repository) {
        this.repository = repository;
    }

    public List<T> getAll() throws Exception {
        return repository.getAll();
    }

    public T getById(long id) throws Exception {
        return repository.getById(id);
    }
}
