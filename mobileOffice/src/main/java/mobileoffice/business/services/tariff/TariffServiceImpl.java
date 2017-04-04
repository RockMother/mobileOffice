package mobileoffice.business.services.tariff;

import mobileoffice.business.contracts.tariff.TariffService;
import mobileoffice.dao.contracts.OptionsRepository;
import mobileoffice.dao.contracts.TariffOptionsRspRepository;
import mobileoffice.dao.contracts.TariffRepository;
import mobileoffice.dao.entities.Options;
import mobileoffice.dao.entities.Tariff;
import mobileoffice.dao.entities.TariffOptionsRsp;
import mobileoffice.models.TariffModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by kisc on 4/3/2017.
 */
@Service
public class TariffServiceImpl implements TariffService {
    private TariffRepository tariffRepository;
    private OptionsRepository optionsRepository;
    private TariffOptionsRspRepository tariffOptionsRspRepository;

    public TariffServiceImpl(TariffRepository tariffRepository,
                             OptionsRepository optionsRepository,
                             TariffOptionsRspRepository tariffOptionsRspRepository){
        this.tariffRepository = tariffRepository;
        this.optionsRepository = optionsRepository;
        this.tariffOptionsRspRepository = tariffOptionsRspRepository;
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

    public List<Options> getSelectedOptions(long id) throws Exception {
        try {
            List<Options> result = new ArrayList<Options>();
            List<Object> params = new ArrayList<Object>();
            params.add(id);
            for(TariffOptionsRsp rsp: tariffOptionsRspRepository.findByParameters("tariff_id = ?", params)){
                result.add(rsp.getOptionsByOptionsId());
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Options> getAvaliableOptions(long id, List<Options> selectedOptions) throws Exception {
        try {
            List<Options> result = new ArrayList<>();
            List<Options> avaliableOptions = optionsRepository.getAll();

            Stream<Options> selectedOptionsStream = selectedOptions.stream();
            for (Options avaliableOption: avaliableOptions){
                if (!selectedOptionsStream.anyMatch(s -> avaliableOption.getId() == s.getId())){
                    result.add(avaliableOption);
                }
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }
}

