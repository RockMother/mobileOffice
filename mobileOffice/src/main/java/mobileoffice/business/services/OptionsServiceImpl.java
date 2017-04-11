package mobileoffice.business.services;

import mobileoffice.business.contracts.OptionsService;
import mobileoffice.dao.contracts.OptionsRepository;
import mobileoffice.dao.entities.Options;
import mobileoffice.models.OptionModel;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

/**
 * Created by kiril_000 on 12.04.2017.
 */
@Service
public class OptionsServiceImpl implements OptionsService {
    private OptionsRepository optionsRepository;

    public OptionsServiceImpl(OptionsRepository optionsRepository){
        this.optionsRepository = optionsRepository;
    }

    @Override
    public Options createNewOptions(OptionModel optionModel) throws Exception {
        Options options = new Options();
        options.setName(optionModel.getName());
        options.setInitialPrice(optionModel.getInitialPrice());
        return optionsRepository.create(options);
    }

    @Override
    public Options updateOptions(OptionModel optionModel) throws Exception {
        Session session = optionsRepository.getSession();
        session.beginTransaction();
        Options options = optionsRepository.getById(optionModel.getId(), session);
        options.setName(optionModel.getName());
        options.setInitialPrice(optionModel.getInitialPrice());
        optionsRepository.update(options, session);
        session.flush();
        session.close();
        return options;
    }

    @Override
    public void delete(long id) throws Exception {
        optionsRepository.delete(id);
    }
}
