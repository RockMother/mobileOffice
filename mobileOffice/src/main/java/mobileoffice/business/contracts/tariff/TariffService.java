package mobileoffice.business.contracts.tariff;

import mobileoffice.dao.entities.Options;
import mobileoffice.dao.entities.Tariff;
import mobileoffice.models.TariffModel;

import java.util.List;

/**
 * Created by kisc on 4/3/2017.
 */
public interface TariffService {
    Tariff addNewTariff(TariffModel model) throws Exception;

    List<Options> getSelectedOptions(long id) throws Exception;

    List<Options> getAvaliableOptions(long id, List<Options> selectedOptions) throws Exception;

    void delete(long id) throws Exception;

    void updateTariff(long id, TariffModel tariffModel) throws Exception;
}
