package mobileoffice.business.services;

import mobileoffice.business.contracts.RegistrationService;
import mobileoffice.dao.contracts.ClientRepository;
import mobileoffice.dao.entities.Client;
import mobileoffice.dao.entities.Users;
import mobileoffice.models.NewClientModel;
import org.springframework.stereotype.Service;

/**
 * Created by kisc on 4/10/2017.
 */
@Service
public class ClientsServiceImpl implements mobileoffice.business.contracts.ClientsService {

    private final RegistrationService registrationService;
    private ClientRepository clientRepository;

    public ClientsServiceImpl(ClientRepository clientRepository, RegistrationService registrationService){
        this.clientRepository = clientRepository;
        this.registrationService = registrationService;
    }

    @Override
    public Client createClient(NewClientModel model) throws Exception {
        Users user = registrationService.registerNewUser(model);
        return clientRepository.create(buildClient(user.getId(), model));
    }

    private Client buildClient(long id, NewClientModel model) {
        Client client = new Client();
        client.setUserId(id);
        client.setAddress(model.getAddress());
        client.setBirthday(model.getBirthday());
        client.setEmail(model.getEmail());
        client.setLastName(model.getLastName());
        client.setName(model.getName());
        client.setPassport(model.getPassport());
        return client;
    }
}
