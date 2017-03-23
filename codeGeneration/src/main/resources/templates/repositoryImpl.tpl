package ${settings.repositoryPackageName};

import org.hibernate.SessionFactory;
import base.dao.repositories.RepositoryImpl;
import ${settings.entityPackageName}.${model.className};
import ${settings.repositoryInterfacePackageName}.${model.className}Repository;

public class ${model.className}RepositoryImpl extends RepositoryImpl<${model.className}> implements ${model.className}Repository{
    public ${model.className}RepositoryImpl(SessionFactory sessionFactory){
     super(sessionFactory);
    }
}