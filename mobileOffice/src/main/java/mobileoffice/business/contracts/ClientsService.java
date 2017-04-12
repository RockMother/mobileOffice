package mobileoffice.business.contracts;

import mobileoffice.models.NewClientModel;

/**
 * Created by kisc on 4/10/2017.
 */
public interface ClientsService {
    long createClient(NewClientModel model) throws Exception;
}
