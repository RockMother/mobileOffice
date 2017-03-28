package mobileoffice.business.services.data;

import base.business.services.DataServiceImpl;
import mobileoffice.business.contracts.data.ContractDataService;
import mobileoffice.dao.contracts.ContractRepository;
import mobileoffice.dao.entities.Contract;

/*
    !!!! AUTOGENERATED !!!!!
*/
public class ContractDataServiceImpl extends DataServiceImpl<ContractRepository, Contract> implements ContractDataService {
public ContractDataServiceImpl(ContractRepository repository) {
    super(repository);
    }
}