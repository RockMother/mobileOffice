package mobileoffice.business.contracts;

import mobileoffice.models.RegistrationModel;

/**
 * Created by kiril_000 on 02.04.2017.
 */
public interface RegistrationService {
    void registerNewUser(RegistrationModel model);
}
