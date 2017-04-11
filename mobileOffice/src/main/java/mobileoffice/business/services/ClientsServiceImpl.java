package mobileoffice.business.services;

import mobileoffice.business.contracts.RegistrationService;
import mobileoffice.dao.contracts.ClientRepository;
import mobileoffice.dao.contracts.ContractRepository;
import mobileoffice.dao.contracts.VContractWithTariffRepository;
import mobileoffice.dao.entities.Client;
import mobileoffice.dao.entities.Contract;
import mobileoffice.dao.entities.Users;
import mobileoffice.dao.entities.VContractWithTariff;
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
    private VContractWithTariffRepository vContractWithTariffRepository;
    private final RegistrationService registrationService;
    private ClientRepository clientRepository;

    public ClientsServiceImpl(ClientRepository clientRepository,
                              ContractRepository contractRepository,
                              VContractWithTariffRepository vContractWithTariffRepository,
                              RegistrationService registrationService){
        this.clientRepository = clientRepository;
        this.contractRepository = contractRepository;
        this.vContractWithTariffRepository = vContractWithTariffRepository;
        this.registrationService = registrationService;
    }

    @Override
    public long createClient(NewClientModel model) throws Exception {
        Users user = registrationService.registerNewUser(model);
        Client client = clientRepository.create(buildClient(user.getId(), model));
        contractRepository.create(buildContract(client.getId(), model));
        return client.getId();
    }

    public List<VContractWithTariff> getContracts(long clientId) throws Exception {
        List<Object> params = new ArrayList<>();
        params.add(clientId);
        return vContractWithTariffRepository.findByParameters("user_id = ?", params);
    }

    private Contract buildContract(long clientId, NewClientModel model){
        Contract contract = new Contract();
        contract.setTariffId(model.getTariffId());
        contract.setNumber(model.getNumber());
        contract.setClientId(clientId);
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
        return client;
    }
}
