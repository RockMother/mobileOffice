package mobileoffice.business.contracts;

import mobileoffice.dao.entities.Client;
import mobileoffice.models.NewClientModel;

/**
 * Created by kisc on 4/10/2017.
 */
public interface ClientsService {
    Client createClient(NewClientModel model) throws Exception;
}
