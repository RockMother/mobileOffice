package mobileoffice.business.services;

import mobileoffice.business.contracts.OptionsService;
import mobileoffice.business.contracts.tariff.TariffService;
import mobileoffice.dao.contracts.ContractOptionRspRepository;
import mobileoffice.dao.contracts.ContractRepository;
import mobileoffice.dao.contracts.OptionsRepository;
import mobileoffice.dao.contracts.VContractWithTariffRepository;
import mobileoffice.dao.entities.Contract;
import mobileoffice.dao.entities.ContractOptionRsp;
import mobileoffice.dao.entities.Options;
import mobileoffice.dao.entities.VContractWithTariff;
import mobileoffice.models.ContractModel;
import mobileoffice.models.EditContractModel;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kisc on 4/11/2017.
 */
@Service
public class ContractServiceImpl implements mobileoffice.business.contracts.ContractService {

    private ContractRepository contractRepository;
    private OptionsRepository optionsRepository;
    private OptionsService optionsService;
    private VContractWithTariffRepository contractWithTariffRepository;
    private TariffService tariffService;
    private ContractOptionRspRepository contractOptionRspRepository;

    public ContractServiceImpl(ContractRepository contractRepository,
                               OptionsRepository optionsRepository,
                               OptionsService optionsService,
                               VContractWithTariffRepository contractWithTariffRepository,
                               TariffService tariffService,
                               ContractOptionRspRepository contractOptionRspRepository) throws Exception {
        this.contractRepository = contractRepository;
        this.optionsRepository = optionsRepository;
        this.optionsService = optionsService;
        this.contractWithTariffRepository = contractWithTariffRepository;
        this.tariffService = tariffService;
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
    public void updateContractData(EditContractModel editContractModel, boolean asManager) throws Exception {
        Session session = contractRepository.getSession();
        session.beginTransaction();
        Contract baseContract = contractRepository.getById(editContractModel.getId(), session);
        if (baseContract.getTariffId() != editContractModel.getTariffId()){
            baseContract.setTariffId(editContractModel.getTariffId());
            createDefaultOptionList(editContractModel.getId(), editContractModel.getTariffId(), session);
        } else {
            updateSelectedOptions(editContractModel.getId(), editContractModel.getSelectedOptions(), session);
        }
        if (asManager){
            if (editContractModel.isBlocked() && !baseContract.getIsBlocked()){
                baseContract.setIsBlocked(true);
                baseContract.setIsAdminBlocker(true);
            } else if (!editContractModel.isBlocked() && baseContract.getIsBlocked()) {
                baseContract.setIsBlocked(false);
                baseContract.setIsAdminBlocker(false);
            }
        }
        session.flush();
        session.close();
    }

    @Override
    public void createDefaultOptionList(long contractId, long tariffId) throws Exception {
        Session session = contractWithTariffRepository.getSession();
        createDefaultOptionList(contractId, tariffId, session);
    }

    private void createDefaultOptionList(long contractId, long tariffId, Session session) throws Exception {
        List<Options> defaultOptions = tariffService.getSelectedOptions(tariffId);
        List<Long> defaultOptionList = new ArrayList<>();
        for(Options option: defaultOptions){
            defaultOptionList.add(option.getId());
        }
        updateSelectedOptions(contractId, defaultOptionList, session);
    }

    @Override
    public List<ContractModel> getUserContracts(long userId) throws Exception {
        List<VContractWithTariff> contracts = contractWithTariffRepository.findByParameter("user_id = ?", userId);
        return buildContractModels(contracts);
    }

    @Override
    public List<ContractModel> getClientContracts(long clientId) throws Exception {
        List<VContractWithTariff> contracts = contractWithTariffRepository.findByParameter("client_id = ?", clientId);
        return buildContractModels(contracts);
    }

    @Override
    public ContractModel getContractModel(long contractId) throws Exception {
        VContractWithTariff contract = contractWithTariffRepository.getById(contractId);
        return buildContractModel(contract);
    }

    private List<Options> getContractOptions(long contractId) throws Exception {
        Contract contract = contractRepository.getById(contractId);
        return contract.getContractOptionRspsByContractId().stream().map(ContractOptionRsp::getOptionsByOptionId).collect(Collectors.toList());
    }

    private List<Options> getAvailableOptions(long contractId, List<Options> selectedOptions) throws Exception {
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

    private ContractModel buildContractModel(VContractWithTariff contract) throws Exception {
        List<VContractWithTariff> contracts = new ArrayList<>();
        contracts.add(contract);
        return buildContractModels(contracts).get(0);
    }

    private List<ContractModel> buildContractModels(List<VContractWithTariff> contracts) throws Exception {
        List<ContractModel> result = new ArrayList<>();
        for (VContractWithTariff contract: contracts){
            ContractModel model = new ContractModel();
            model.setId(contract.getId());
            model.setNumber(contract.getNumber());
            model.setAdminBlocker(contract.getIsAdminBlocker());
            model.setBlocked(contract.getIsBlocked());
            List<Options> selectedOptions = getContractOptions(contract.getId());
            List<Options> availableOptions = getAvailableOptions(contract.getId(), selectedOptions);
            model.setTariffId(contract.getTariffId());
            model.setTariffName(contract.getName());
            model.setAvailableOptions(availableOptions);
            model.setSelectedOptions(selectedOptions);

            result.add(model);
        }
        return result;
    }

    private void updateSelectedOptions(long id, List<Long> selectedOptions, Session session) throws Exception {
        List<ContractOptionRsp> currentOptions = contractOptionRspRepository.findByParameter("contract_id = ?", id, session);
        for (ContractOptionRsp currentOption: currentOptions){
            if (selectedOptions.stream().noneMatch(s -> s == currentOption.getOptionId())) {
                contractOptionRspRepository.delete(currentOption, session);
            }
        }
        for (Long optionId: selectedOptions){
            if (currentOptions.stream().noneMatch(o -> o.getOptionId() == optionId)){
                ContractOptionRsp rsp = new ContractOptionRsp();
                rsp.setContractId(id);
                rsp.setOptionId(optionId);
                contractOptionRspRepository.create(rsp, session);
            }
        }
    }
}
