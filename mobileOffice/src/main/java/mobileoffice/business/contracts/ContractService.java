package mobileoffice.business.contracts;

import mobileoffice.dao.entities.Options;
import mobileoffice.models.EditContractModel;

import java.util.List;

/**
 * Created by kisc on 4/11/2017.
 */
public interface ContractService {
    void blockContractByClient(long id) throws Exception;
    void unblockContractByClient(long id) throws Exception;
    List<Options> getContractOptions(long contractId) throws Exception;
    List<Options> getAvailableOptions(long contractId, List<Options> selectedOptions) throws Exception;
    void updateContractData(EditContractModel editContractModel) throws Exception;
}
