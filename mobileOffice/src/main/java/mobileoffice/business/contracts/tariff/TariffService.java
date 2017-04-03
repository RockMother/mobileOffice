package mobileoffice.business.contracts.tariff;

import mobileoffice.dao.entities.Tariff;
import mobileoffice.models.TariffModel;

/**
 * Created by kisc on 4/3/2017.
 */
public interface TariffService {
    Tariff addNewTariff(TariffModel model) throws Exception;
}
