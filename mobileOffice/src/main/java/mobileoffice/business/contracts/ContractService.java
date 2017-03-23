package mobileoffice.business.contracts;

import base.business.contracts.Service;
import mobileoffice.dao.contracts.ContractRepository;
import mobileoffice.dao.entities.Contract;

/**
 * Created by kisc on 3/23/2017.
 */
public interface ContractService extends Service<ContractRepository,Contract> {
}
