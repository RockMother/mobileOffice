package mobileoffice.business.services.data;

import base.business.services.DataServiceImpl;
import mobileoffice.business.contracts.data.TariffDataService;
import mobileoffice.dao.contracts.TariffRepository;
import mobileoffice.dao.entities.Tariff;

/*
    !!!! AUTOGENERATED !!!!!
*/
public class TariffDataServiceImpl extends DataServiceImpl<TariffRepository, Tariff> implements TariffDataService {
public TariffDataServiceImpl(TariffRepository repository) {
    super(repository);
    }
}