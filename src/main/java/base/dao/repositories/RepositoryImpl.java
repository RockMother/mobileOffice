package base.dao.repositories;

import base.contracts.HasLongId;
import base.contracts.Repository;

import java.util.ArrayList;
import java.util.List;

public abstract class RepositoryImpl<T extends HasLongId> implements Repository<T> {
    public List<T> getAllEntities(){
        return new ArrayList<T>();
    }

    public T getById(long id){
        return null;
    }

}
