package mobileoffice.business.contracts;

import mobileoffice.dao.entities.VContractWithTariff;
import mobileoffice.models.NewClientModel;

import java.util.List;

/**
 * Created by kisc on 4/10/2017.
 */
public interface ClientsService {
    long createClient(NewClientModel model) throws Exception;
    List<VContractWithTariff> getContracts(long clientId) throws Exception;
}
