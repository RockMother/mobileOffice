package mobileoffice.dao.repositories;

import org.hibernate.SessionFactory;
import base.dao.repositories.RepositoryImpl;
import mobileoffice.dao.entities.ClientContractRsp;
import mobileoffice.dao.contracts.ClientContractRspRepository;

public class ClientContractRspRepositoryImpl extends RepositoryImpl<ClientContractRsp> implements ClientContractRspRepository{
    public ClientContractRspRepositoryImpl(SessionFactory sessionFactory){
     super(sessionFactory);
    }
}