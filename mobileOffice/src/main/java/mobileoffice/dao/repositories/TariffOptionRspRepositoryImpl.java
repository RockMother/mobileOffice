package mobileoffice.dao.repositories;

import org.hibernate.SessionFactory;
import base.dao.repositories.RepositoryImpl;
import mobileoffice.dao.entities.TariffOptionRsp;
import mobileoffice.dao.contracts.TariffOptionRspRepository;

public class TariffOptionRspRepositoryImpl extends RepositoryImpl<TariffOptionRsp> implements TariffOptionRspRepository{
    public TariffOptionRspRepositoryImpl(SessionFactory sessionFactory){
     super(sessionFactory);
    }
}