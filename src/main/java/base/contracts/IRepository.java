package base.contracts;

import base.dao.entities.BaseEntity;

import java.util.List;

public interface IRepository<TEntity extends IHasLongId> {
    List<TEntity> GetAllEntities();
}
