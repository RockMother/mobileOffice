package mobileoffice.business.services.tariff;

import mobileoffice.business.contracts.OptionsService;
import mobileoffice.business.contracts.tariff.TariffChangedNotifierService;
import mobileoffice.business.contracts.tariff.TariffService;
import mobileoffice.dao.contracts.OptionsRepository;
import mobileoffice.dao.contracts.TariffOptionsRspRepository;
import mobileoffice.dao.contracts.TariffRepository;
import mobileoffice.dao.entities.Options;
import mobileoffice.dao.entities.Tariff;
import mobileoffice.dao.entities.TariffOptionsRsp;
import mobileoffice.models.TariffModel;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by kisc on 4/3/2017.
 */
@Service
public class TariffServiceImpl implements TariffService {
    private TariffRepository tariffRepository;
    private OptionsRepository optionsRepository;
    private OptionsService optionsService;
    private TariffChangedNotifierService tariffChangedNotifierService;
    private TariffOptionsRspRepository tariffOptionsRspRepository;

    public TariffServiceImpl(TariffRepository tariffRepository,
                             OptionsRepository optionsRepository,
                             OptionsService optionsService,
                             TariffChangedNotifierService tariffChangedNotifierService,
                             TariffOptionsRspRepository tariffOptionsRspRepository){
        this.tariffRepository = tariffRepository;
        this.optionsRepository = optionsRepository;
        this.optionsService = optionsService;
        this.tariffChangedNotifierService = tariffChangedNotifierService;
        this.tariffOptionsRspRepository = tariffOptionsRspRepository;
    }

    @Override
    public Tariff addNewTariff(TariffModel model) throws Exception {
        Tariff tariff = new Tariff();
        tariff.setName(model.getName());
        tariff.setPrice(model.getPrice());
        Tariff result = tariffRepository.create(tariff);
        if (model.getSelectedOptions().size() > 0) {
            for (Long optionId : model.getSelectedOptions()) {
                TariffOptionsRsp rsp = new TariffOptionsRsp();
                rsp.setTariffId(result.getId());
                rsp.setTariffOptionId(optionId);
                tariffOptionsRspRepository.create(rsp);
            }
        }
        raiseChanged();
        return result;
    }

    @Override
    public List<Options> getSelectedOptions(long id) throws Exception {
        List<Options> result = new ArrayList<Options>();
        for (TariffOptionsRsp rsp : tariffOptionsRspRepository.findByParameter("tariff_id = ?", id)) {
            result.add(rsp.getOptionsByTariffOptionId());
        }
        return result;
    }

    @Override
    public List<Options> getAvaliableOptions(long id, List<Options> selectedOptions) throws Exception {
        List<Options> result = new ArrayList<>();
        List<Options> avaliableOptions = optionsRepository.getAll();

        for (Options avaliableOption : avaliableOptions) {
            if (!selectedOptions.stream().anyMatch(s -> avaliableOption.getId() == s.getId())) {
                result.add(avaliableOption);
            }
        }
        return result;
    }

    @Override
    public void delete(long id) throws Exception {
        tariffRepository.delete(id);
        raiseChanged();
    }

    @Override
    public void updateTariff(long id, TariffModel tariffModel) throws Exception {
        Session session = null;
        try {
            session = tariffRepository.getSession();
            session.beginTransaction();
            Tariff current = tariffRepository.getById(id, session);
            current.setPrice(tariffModel.getPrice());
            current.setName(tariffModel.getName());
            syncOptions(id, tariffModel.getSelectedOptions(), session);
            tariffRepository.update(current, session);
            session.flush();
            raiseChanged();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    private void raiseChanged(){
        tariffChangedNotifierService.tariffChanged();
    }

    private void syncOptions(long tariffId, Set<Long> selectedOptions,  Session session) throws Exception {
        List<TariffOptionsRsp> rsps = tariffOptionsRspRepository.findByParameter("tariff_id = ?", tariffId, session);

        List<TariffOptionsRsp> toDelete = new ArrayList<>();
        for(TariffOptionsRsp rsp: rsps){
            if (selectedOptions.stream().noneMatch(s -> s == rsp.getTariffOptionId())){
                toDelete.add(rsp);
            }
        }
        List<Long> toAdd = new ArrayList<>();
        for(Long id: selectedOptions){
            if (rsps.stream().noneMatch(r -> r.getTariffOptionId() == id)){
                toAdd.add(id);
            }
        }
        for(TariffOptionsRsp rsp: toDelete){
            tariffOptionsRspRepository.delete(rsp, session);
        }
        for(Long id: toAdd){
            TariffOptionsRsp rsp = new TariffOptionsRsp();
            rsp.setTariffId(tariffId);
            rsp.setTariffOptionId(id);
            tariffOptionsRspRepository.create(rsp, session);
        }

    }
}

