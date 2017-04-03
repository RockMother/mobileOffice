package mobileoffice.business.services.tariff;

import mobileoffice.business.contracts.tariff.TariffService;
import mobileoffice.dao.contracts.TariffRepository;
import mobileoffice.dao.entities.Tariff;
import mobileoffice.models.TariffModel;
import org.springframework.stereotype.Service;

/**
 * Created by kisc on 4/3/2017.
 */
@Service
public class TariffServiceImpl implements TariffService {
    private TariffRepository tariffRepository;

    public TariffServiceImpl(TariffRepository tariffRepository){
        this.tariffRepository = tariffRepository;
    }

    public Tariff addNewTariff(TariffModel model) throws Exception {
        try {
            Tariff tariff = new Tariff();
            tariff.setName(model.getName());
            tariff.setPrice(model.getPrice());
            return tariffRepository.create(tariff);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
