package mobileoffice.business.services;

import mobileoffice.dao.contracts.AuthoritiesRepository;
import mobileoffice.dao.contracts.ClientRepository;
import mobileoffice.dao.contracts.UsersRepository;
import mobileoffice.dao.entities.Authorities;
import mobileoffice.dao.entities.Client;
import mobileoffice.dao.entities.Manager;
import mobileoffice.dao.entities.Users;
import mobileoffice.dao.repositories.ManagerRepositoryImpl;
import mobileoffice.models.RegistrationModel;
import org.springframework.stereotype.Service;

/**
 * Created by kiril_000 on 02.04.2017.
 */
@Service
public class RegistrationServiceImpl implements mobileoffice.business.contracts.RegistrationService {
    private UsersRepository usersRepository;
    private ManagerRepositoryImpl managerRepository;
    private ClientRepository clientRepository;
    private AuthoritiesRepository authoritiesRepository;

    public RegistrationServiceImpl(UsersRepository usersRepository,
                                   ManagerRepositoryImpl managerRepository,
                                   ClientRepository clientRepository,
                                   AuthoritiesRepository authoritiesRepository){
        this.usersRepository = usersRepository;
        this.managerRepository = managerRepository;
        this.clientRepository = clientRepository;
        this.authoritiesRepository = authoritiesRepository;
    }

    public void registerNewUser(RegistrationModel model) throws Exception {
        Users user = createUser(model);

        user = usersRepository.create(user);
        authoritiesRepository.create(createAuthority(user.getId(), model.getRole()));

        if (model.getRole().equals("ROLE_MANAGER")) {
            managerRepository.create(createManager(user.getId()));
        } else {
            clientRepository.create(createClient(user.getId(), model));
        }
    }

    private Client createClient(long id, RegistrationModel model) {
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

    private Users createUser(RegistrationModel model){
        Users entity = new Users();
        entity.setUserName(model.getUsername());
        entity.setPassword(model.getPassword());
        entity.setEnabled(true);
        return entity;
    }

    private Authorities createAuthority(long userId, String role){
        Authorities authority = new Authorities();
        authority.setUserId(userId);
        authority.setAuthority(role);
        return authority;
    }

    private Manager createManager(long userId){
        Manager manager = new Manager();
        manager.setUserId(userId);
        return manager;
    }
}
