package mobileoffice.business.services;

import mobileoffice.business.contracts.OptionsService;
import mobileoffice.dao.contracts.OptionRelationsRspRepository;
import mobileoffice.dao.contracts.OptionsRepository;
import mobileoffice.dao.entities.OptionRelationsRsp;
import mobileoffice.dao.entities.Options;
import mobileoffice.models.OptionModel;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by kiril_000 on 12.04.2017.
 */
@Service
public class OptionsServiceImpl implements OptionsService {
    private OptionsRepository optionsRepository;
    private OptionRelationsRspRepository optionRelationsRspRepository;

    public OptionsServiceImpl(OptionsRepository optionsRepository, OptionRelationsRspRepository optionRelationsRspRepository){
        this.optionsRepository = optionsRepository;

        this.optionRelationsRspRepository = optionRelationsRspRepository;
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

        syncOptions(optionModel.getId(), "required", optionModel.getSelectedRequiredOptions(), o -> o.setRequired(true), session);
        syncOptions(optionModel.getId(), "incompatible", optionModel.getSelectedIncompatibleOptions(), o -> o.setIncompatible(true), session);

        optionsRepository.update(options, session);
        session.flush();
        session.close();
        return options;
    }



    @Override
    public void delete(long id) throws Exception {
        optionsRepository.delete(id);
    }

    @Override
    public List<Options> getSelectedRequiredOptions(long optionId) throws Exception {
        return getSelectedOptions(optionId, "required");
    }

    @Override
    public List<Options> getSelectedIncompatibleOptions(long optionId) throws Exception {
        return getSelectedOptions(optionId, "incompatible");
    }

    @Override
    public List<Options> getAvailableOptions(long optionId, List<Options> selectedRequiredOptions) throws Exception {
        List<Options> allOptions = optionsRepository.getAll();
        List<Options> result = new ArrayList<>();
        for(Options option: allOptions) {
            if (!selectedRequiredOptions.stream().anyMatch(o -> o.getId() == option.getId() || option.getId() == optionId)){
                result.add(option);
            }
        }
        return result;
    }

    @Override
    public List<Options> getAvailableOptions(List<Options> selectedOptions) throws Exception {
        List<Options> allOptions = optionsRepository.getAll();
        List<Options> incompatible = new ArrayList<>();
        List<Options> result = new ArrayList<>();
        for(Options selectedOption: selectedOptions){
            incompatible.addAll(getSelectedIncompatibleOptions(selectedOption.getId()));
        }
        for (Options option: allOptions){
            if (incompatible.stream().noneMatch(o -> o.getId() == option.getId())
                && selectedOptions.stream().noneMatch(o -> o.getId() == option.getId())) {
                result.add(option);
            }
        }
        return result;
    }

    private List<Options> getSelectedOptions(long optionId, String parameter) throws Exception {
        List<Options> result = new ArrayList<>();
        List<OptionRelationsRsp> optionRelationsRsps = getRelations(optionId, parameter);
        for(OptionRelationsRsp rsp: optionRelationsRsps) {
            if (rsp.getOptionMainId() == optionId){
                result.add(rsp.getOptionsByOptionSecondId());
            } else {
                result.add(rsp.getOptionsByOptionMainId());
            }
        }
        return result;
    }

    private List<OptionRelationsRsp> getRelations(long optionId, String parameter) throws Exception {
        List<Object> params = new ArrayList<>();
        params.add(optionId);
        params.add(optionId);
        String query =  String.format("%s = 1 and (option_main_id = ? or option_second_id = ?)", parameter);
        return optionRelationsRspRepository.findByParameters(query, params);
    }

    private void syncOptions(long optionsId, String parameter, List<Long> selectedItems, Consumer<OptionRelationsRsp> initializer, Session session) throws Exception {

        List<OptionRelationsRsp> selectedReqOptions = getRelations(optionsId, parameter);
        List<Long> toDelete = new ArrayList<>();
        for (OptionRelationsRsp selReqOpt: selectedReqOptions) {
            if (selectedItems.stream().noneMatch(s -> selReqOpt.getOptionMainId() == s
                    || selReqOpt.getOptionSecondId() == s)) {
                toDelete.add(selReqOpt.getId());
            }
        }
        List<Long> toAdd = new ArrayList<>();
        for (Long selOptionId: selectedItems) {
            if (selectedReqOptions.stream().noneMatch(o -> o.getOptionMainId() == selOptionId || o.getOptionSecondId() == selOptionId)) {
                toAdd.add(selOptionId);
            }
        }

        for(Long id: toDelete){
            optionRelationsRspRepository.delete(id, session);
        }
        for(Long id: toAdd){
            OptionRelationsRsp optRsp = new OptionRelationsRsp();
            optRsp.setOptionMainId(optionsId);
            optRsp.setOptionSecondId(id);
            initializer.accept(optRsp);
            optionRelationsRspRepository.create(optRsp, session);
        }
    }
}
