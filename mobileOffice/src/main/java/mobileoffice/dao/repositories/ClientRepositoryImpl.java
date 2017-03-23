package mobileoffice.dao.repositories;

import base.dao.repositories.RepositoryImpl;
import mobileoffice.dao.entities.Client;
import mobileoffice.dao.contracts.ClientRepository;

public class ClientRepositoryImpl extends RepositoryImpl<Client> implements ClientRepository{
    public ClientRepositoryImpl(){
    }
}