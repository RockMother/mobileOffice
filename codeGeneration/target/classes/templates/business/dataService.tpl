package ${settings.dataServiceInterfacesPackageName};;

import base.business.contracts.DataService;
import ${settings.repositoryInterfacePackageName}.${model.className}Repository;
import ${settings.entityPackageName}.${model.className};

/*
    !!!! AUTOGENERATED !!!!!
*/
public interface ${model.className}DataService extends DataService<${model.className}Repository,${model.className}> {
}