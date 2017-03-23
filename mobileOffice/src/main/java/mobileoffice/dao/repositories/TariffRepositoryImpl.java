package mobileoffice.dao.repositories;

import org.hibernate.SessionFactory;
import base.dao.repositories.RepositoryImpl;
import mobileoffice.dao.entities.Tariff;
import mobileoffice.dao.contracts.TariffRepository;

public class TariffRepositoryImpl extends RepositoryImpl<Tariff> implements TariffRepository{
    public TariffRepositoryImpl(SessionFactory sessionFactory){
     super(sessionFactory);
    }
}