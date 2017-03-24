package mobileoffice.business.services;

import base.business.services.BaseService;
import mobileoffice.business.contracts.ContractService;
import mobileoffice.dao.contracts.ContractRepository;
import mobileoffice.dao.entities.Contract;

/**
 * Created by kisc on 3/23/2017.
 */
public class ContractServiceImpl extends BaseService<ContractRepository, Contract> implements ContractService {
    public ContractServiceImpl(ContractRepository repository) {
        super(repository);
    }
}
