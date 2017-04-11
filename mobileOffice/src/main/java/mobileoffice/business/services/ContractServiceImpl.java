package mobileoffice.business.services;

import mobileoffice.dao.contracts.ContractRepository;
import mobileoffice.dao.contracts.OptionsRepository;
import mobileoffice.dao.entities.Contract;
import mobileoffice.dao.entities.ContractOptionRsp;
import mobileoffice.dao.entities.Options;
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

    public ContractServiceImpl(ContractRepository contractRepository, OptionsRepository optionsRepository){
        this.contractRepository = contractRepository;

        this.optionsRepository = optionsRepository;
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
    public List<Options> getAvaliableOptions(long contractId, List<Options> selectedOptions) throws Exception {
        List<Options> result = new ArrayList<>();
        List<Options> avaliableOptions = optionsRepository.getAll();
        Stream<Options> selectedOptionsStream = selectedOptions.stream();
        for (Options avaliableOption : avaliableOptions) {
            if (!selectedOptionsStream.anyMatch(s -> avaliableOption.getId() == s.getId())) {
                result.add(avaliableOption);
            }
        }
        return result;
    }
}
