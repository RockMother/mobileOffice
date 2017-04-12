package mobileoffice.business.contracts;

import mobileoffice.models.ContractModel;
import mobileoffice.models.EditContractModel;

import java.util.List;

/**
 * Created by kisc on 4/11/2017.
 */
public interface ContractService {
    void blockContractByClient(long id) throws Exception;
    void unblockContractByClient(long id) throws Exception;
    void updateContractData(EditContractModel editContractModel, boolean asManager) throws Exception;
    void createDefaultOptionList(long contractId, long tariffId) throws Exception;
    List<ContractModel> getUserContracts(long userId) throws Exception;
    List<ContractModel> getClientContracts(long clientId) throws Exception;
    ContractModel getContractModel(long id) throws Exception;
}
