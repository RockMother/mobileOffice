package mobileoffice.business.services;

import base.business.services.BaseService;
import mobileoffice.dao.contracts.ContractRepository;
import mobileoffice.dao.entities.Contract;
import org.springframework.stereotype.Service;

/**
 * Created by kisc on 3/23/2017.
 */
@Service
public class ContractServiceImpl extends BaseService<ContractRepository, Contract> {
    public ContractServiceImpl(ContractRepository repository) {
        super(repository);
    }
}
