package mobileoffice.business.services;

import mobileoffice.dao.contracts.AuthoritiesRepository;
import mobileoffice.dao.contracts.UsersRepository;
import mobileoffice.dao.entities.Authorities;
import mobileoffice.dao.entities.Manager;
import mobileoffice.dao.entities.Users;
import mobileoffice.dao.repositories.ManagerRepositoryImpl;
import mobileoffice.models.RegistrationModel;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by kiril_000 on 02.04.2017.
 */
@Service
public class RegistrationServiceImpl implements mobileoffice.business.contracts.RegistrationService {
    private UsersRepository usersRepository;
    private ManagerRepositoryImpl managerRepository;
    private AuthoritiesRepository authoritiesRepository;

    public RegistrationServiceImpl(UsersRepository usersRepository,
                                   ManagerRepositoryImpl managerRepository,
                                   AuthoritiesRepository authoritiesRepository){
        this.usersRepository = usersRepository;
        this.managerRepository = managerRepository;
        this.authoritiesRepository = authoritiesRepository;
    }

    @Transactional
    public void registerNewUser(RegistrationModel model){
        Users user = createUser(model);
        try {
            user = usersRepository.create(user);
            authoritiesRepository.create(createAuthority(user.getId(), model.getRole()));

            if (model.getRole().equals("ROLE_MANAGER")){
                managerRepository.create(createManager(user.getId()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
