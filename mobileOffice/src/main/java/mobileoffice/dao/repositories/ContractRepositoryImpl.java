package mobileoffice.dao.repositories;

import org.hibernate.SessionFactory;
import base.dao.repositories.RepositoryImpl;
import mobileoffice.dao.entities.Contract;
import mobileoffice.dao.contracts.ContractRepository;

public class ContractRepositoryImpl extends RepositoryImpl<Contract> implements ContractRepository{
    public ContractRepositoryImpl(SessionFactory sessionFactory){
     super(sessionFactory);
    }
}