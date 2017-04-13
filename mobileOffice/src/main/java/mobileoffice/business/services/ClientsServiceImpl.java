package mobileoffice.business.services;

import mobileoffice.business.contracts.ContractService;
import mobileoffice.business.contracts.OptionsService;
import mobileoffice.business.contracts.RegistrationService;
import mobileoffice.business.contracts.tariff.TariffService;
import mobileoffice.dao.contracts.ClientRepository;
import mobileoffice.dao.contracts.ContractRepository;
import mobileoffice.dao.contracts.VContractWithTariffRepository;
import mobileoffice.dao.entities.*;
import mobileoffice.models.ContractModel;
import mobileoffice.models.NewClientModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kisc on 4/10/2017.
 */

@Service
public class ClientsServiceImpl implements mobileoffice.business.contracts.ClientsService {

    private ContractRepository contractRepository;
    private OptionsService optionsService;
    private TariffService tariffService;
    private ContractService contractService;
    private VContractWithTariffRepository vContractWithTariffRepository;
    private final RegistrationService registrationService;
    private ClientRepository clientRepository;

    public ClientsServiceImpl(ClientRepository clientRepository,
                              ContractRepository contractRepository,
                              OptionsService optionsService,
                              TariffService tariffService,
                              ContractService contractService,
                              VContractWithTariffRepository vContractWithTariffRepository,
                              RegistrationService registrationService){
        this.clientRepository = clientRepository;
        this.contractRepository = contractRepository;
        this.optionsService = optionsService;
        this.tariffService = tariffService;
        this.contractService = contractService;
        this.vContractWithTariffRepository = vContractWithTariffRepository;
        this.registrationService = registrationService;
    }

    @Override
    public long createClient(NewClientModel model) throws Exception {
        Users user = registrationService.registerNewUser(model);
        Client client = clientRepository.create(buildClient(user.getId(), model));
        Contract contract = contractRepository.create(buildContract(client.getId(), model));
        contractService.createDefaultOptionList(contract.getId(), contract.getTariffId());
        return client.getId();
    }

    @Override
    public List<Client> searchByNumber(String number) throws Exception {
        List<Client> result = new ArrayList<>();
        List<Contract> contracts = contractRepository.findByParameter("number = ?", number);
        for (Contract contract : contracts) {
            if (result.stream().noneMatch(r -> r.getId() == contract.getClientId())){
                result.add(clientRepository.getById(contract.getClientId()));
            }
        }
        return result;
    }

    private Contract buildContract(long clientId, NewClientModel model){
        Contract contract = new Contract();
        contract.setTariffId(model.getTariffId());
        contract.setNumber(model.getNumber());
        contract.setClientId(clientId);
        contract.setIsBlocked(false);
        contract.setIsAdminBlocker(false);
        return contract;
    }

    private Client buildClient(long userId, NewClientModel model) {
        Client client = new Client();
        client.setUserId(userId);
        client.setAddress(model.getAddress());
        client.setBirthday(model.getBirthday());
        client.setEmail(model.getEmail());
        client.setLastName(model.getLastName());
        client.setName(model.getName());
        client.setPassport(model.getPassport());
        client.setLocked(false);
        client.setLockedByAdmin(false);
        return client;
    }
}
