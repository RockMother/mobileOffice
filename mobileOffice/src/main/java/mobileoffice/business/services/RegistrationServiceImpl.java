package mobileoffice.business.services;

import mobileoffice.dao.contracts.UsersRepository;
import mobileoffice.dao.entities.Users;
import mobileoffice.models.RegistrationModel;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by kiril_000 on 02.04.2017.
 */
@Service
public class RegistrationServiceImpl implements mobileoffice.business.contracts.RegistrationService {
    private UsersRepository usersRepository;

    public RegistrationServiceImpl(UsersRepository usersRepository){

        this.usersRepository = usersRepository;
    }

    @Transactional
    public void registerNewUser(RegistrationModel model){
        Users entity = new Users();
        entity.setUserName(model.getUsername());
        entity.setPassword(model.getPassword());
        try {
            entity = usersRepository.create(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
