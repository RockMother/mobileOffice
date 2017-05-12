package mobileoffice.business.services.data;

import base.business.services.DataServiceImpl;
import mobileoffice.business.contracts.data.ClientDataService;
import mobileoffice.dao.contracts.ClientRepository;
import mobileoffice.dao.entities.Client;

/*
    !!!! AUTOGENERATED !!!!!
*/
public class ClientDataServiceImpl extends DataServiceImpl<ClientRepository, Client> implements ClientDataService {
public ClientDataServiceImpl(ClientRepository repository) {
    super(repository);
    }
}