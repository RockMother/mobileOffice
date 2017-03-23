package mobileoffice.dao.repositories;

import org.hibernate.SessionFactory;
import base.dao.repositories.RepositoryImpl;
import mobileoffice.dao.entities.TariffTariffOption;
import mobileoffice.dao.contracts.TariffTariffOptionRepository;

public class TariffTariffOptionRepositoryImpl extends RepositoryImpl<TariffTariffOption> implements TariffTariffOptionRepository{
    public TariffTariffOptionRepositoryImpl(SessionFactory sessionFactory){
     super(sessionFactory);
    }
}