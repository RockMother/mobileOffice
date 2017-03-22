package base.dao.repositories;

import base.contracts.IRepository;
import base.contracts.IHasLongId;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRepository<TEntity extends IHasLongId> implements IRepository<TEntity> {
    public List<TEntity> GetAllEntities(){
        return new ArrayList<TEntity>();
    }

}
