package base.dao.repositories;

import base.contracts.IRepository;
import base.dao.entities.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRepository<TEntity extends BaseEntity> implements IRepository<TEntity> {
    public List<TEntity> GetAllEntities(){
        return new ArrayList<TEntity>();
    }

}
