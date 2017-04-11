package mobileoffice.business.services;

import mobileoffice.dao.contracts.ContractOptionRspRepository;
import mobileoffice.dao.contracts.ContractRepository;
import mobileoffice.dao.contracts.OptionsRepository;
import mobileoffice.dao.entities.Contract;
import mobileoffice.dao.entities.ContractOptionRsp;
import mobileoffice.dao.entities.Options;
import mobileoffice.models.EditContractModel;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by kisc on 4/11/2017.
 */
@Service
public class ContractServiceImpl implements mobileoffice.business.contracts.ContractService {

    private ContractRepository contractRepository;
    private OptionsRepository optionsRepository;
    private ContractOptionRspRepository contractOptionRspRepository;

    public ContractServiceImpl(ContractRepository contractRepository,
                               OptionsRepository optionsRepository,
                               ContractOptionRspRepository contractOptionRspRepository){
        this.contractRepository = contractRepository;
        this.optionsRepository = optionsRepository;
        this.contractOptionRspRepository = contractOptionRspRepository;
    }

    @Override
    public void blockContractByClient(long id) throws Exception {
        Session session = contractRepository.getSession();
        session.beginTransaction();
        Contract contract = contractRepository.getById(id, session);
        contract.setIsBlocked(true);
        contractRepository.update(contract, session);
        session.flush();
        session.close();
    }

    @Override
    public void unblockContractByClient(long id) throws Exception {
        Session session = contractRepository.getSession();
        session.beginTransaction();
        Contract contract = contractRepository.getById(id, session);
        contract.setIsBlocked(false);
        contractRepository.update(contract, session);
        session.flush();
        session.close();
    }
    @Override
    public List<Options> getContractOptions(long contractId) throws Exception {
        Contract contract = contractRepository.getById(contractId);
        return contract.getContractOptionRspsById().stream().map(ContractOptionRsp::getOptionsByOptionsId).collect(Collectors.toList());
    }

    @Override
    public List<Options> getAvailableOptions(long contractId, List<Options> selectedOptions) throws Exception {
        List<Options> result = new ArrayList<>();
        List<Options> availableOptions = optionsRepository.getAll();
        if (selectedOptions != null && selectedOptions.size() > 0) {
            for (Options availableOption : availableOptions) {
                if (!selectedOptions.stream().anyMatch(s -> availableOption.getId() == s.getId())) {
                    result.add(availableOption);
                }
            }
        } else {
            result.addAll(availableOptions);
        }
        return result;
    }

    @Override
    public void updateContractData(EditContractModel editContractModel) throws Exception {
        Session session = contractRepository.getSession();
        session.beginTransaction();
        Contract baseContract = contractRepository.getById(editContractModel.getId(), session);
        if (baseContract.getTariffId() != editContractModel.getTariffId()){
            baseContract.setTariffId(editContractModel.getTariffId());
        }
        updateSelectedOptions(editContractModel, session);
        session.flush();
        session.close();
    }

    private void updateSelectedOptions(EditContractModel editContractModel, Session session) throws Exception {
        List<Object> params = new ArrayList<>();
        params.add(editContractModel.getId());
        List<ContractOptionRsp> currentOptions = contractOptionRspRepository.findByParameters("contract_id = ?", params);
        for (ContractOptionRsp currentOption: currentOptions){
            contractOptionRspRepository.delete(currentOption.getId(), session);
        }
        for (Long selectedOption: editContractModel.getSelectedOptions()){
            ContractOptionRsp option = new ContractOptionRsp();
            option.setContractId(editContractModel.getId());
            option.setOptionId(selectedOption);
            contractOptionRspRepository.create(option, session);
        }
    }
}
