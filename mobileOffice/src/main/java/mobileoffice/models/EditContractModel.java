package mobileoffice.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kisc on 4/11/2017.
 */
public class EditContractModel {
    long id;
    List<Long> selectedOptions = new ArrayList<>();
    Long tariffId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Long> getSelectedOptions() {
        return selectedOptions;
    }

    public void setSelectedOptions(List<Long> selectedOptions) {
        this.selectedOptions = selectedOptions;
    }

    public Long getTariffId() {
        return tariffId;
    }

    public void setTariffId(Long tariffId) {
        this.tariffId = tariffId;
    }
}
