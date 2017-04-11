package mobileoffice.business.contracts;

import mobileoffice.dao.entities.Options;
import mobileoffice.models.OptionModel;

/**
 * Created by kiril_000 on 12.04.2017.
 */
public interface OptionsService {
    Options createNewOptions(OptionModel optionModel) throws Exception;

    Options updateOptions(OptionModel optionModel) throws Exception;

    void delete(long id) throws Exception;
}
