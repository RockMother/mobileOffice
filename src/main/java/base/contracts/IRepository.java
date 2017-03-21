package base.contracts;

import base.dao.entities.BaseEntity;

import java.util.List;

public interface IRepository<TEntity extends BaseEntity> {
    List<TEntity> GetAllEntities();
}
