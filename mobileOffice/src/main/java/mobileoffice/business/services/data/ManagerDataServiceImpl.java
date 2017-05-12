package mobileoffice.business.services.data;

import base.business.services.DataServiceImpl;
import mobileoffice.business.contracts.data.ManagerDataService;
import mobileoffice.dao.contracts.ManagerRepository;
import mobileoffice.dao.entities.Manager;

/*
    !!!! AUTOGENERATED !!!!!
*/
public class ManagerDataServiceImpl extends DataServiceImpl<ManagerRepository, Manager> implements ManagerDataService {
public ManagerDataServiceImpl(ManagerRepository repository) {
    super(repository);
    }
}