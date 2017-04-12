package mobileoffice.business.contracts;

import mobileoffice.dao.entities.Options;
import mobileoffice.models.OptionModel;

import java.util.List;

/**
 * Created by kiril_000 on 12.04.2017.
 */
public interface OptionsService {
    Options createNewOptions(OptionModel optionModel) throws Exception;

    Options updateOptions(OptionModel optionModel) throws Exception;

    void delete(long id) throws Exception;

    List<Options> getSelectedRequiredOptions(long optionId) throws Exception;

    List<Options> getSelectedIncompatibleOptions(long optionId) throws Exception;

    List<Options> getAvailableOptions(long optionId, List<Options> selectedRequiredOptions) throws Exception;

    List<Options> getAvailableOptions(List<Options> selectedOptions) throws Exception;
}
