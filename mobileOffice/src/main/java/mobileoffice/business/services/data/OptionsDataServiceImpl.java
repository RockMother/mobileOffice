package mobileoffice.business.services.data;

import base.business.services.DataServiceImpl;
import mobileoffice.business.contracts.data.OptionsDataService;
import mobileoffice.dao.contracts.OptionsRepository;
import mobileoffice.dao.entities.Options;

/*
    !!!! AUTOGENERATED !!!!!
*/
public class OptionsDataServiceImpl extends DataServiceImpl<OptionsRepository, Options> implements OptionsDataService {
public OptionsDataServiceImpl(OptionsRepository repository) {
    super(repository);
    }
}