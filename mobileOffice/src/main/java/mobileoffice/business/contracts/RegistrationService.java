package mobileoffice.business.contracts;

import mobileoffice.dao.entities.Users;
import mobileoffice.models.RegistrationModel;

/**
 * Created by kiril_000 on 02.04.2017.
 */
public interface RegistrationService {
    Users registerNewUser(RegistrationModel model) throws Exception;
}
