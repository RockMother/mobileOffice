package mobileoffice.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiril_000 on 12.04.2017.
 */
public class OptionModel {
    Long id;
    String name;
    Float initialPrice;
    List<Long> selectedRequiredOptions = new ArrayList<>();
    List<Long> selectedIncompatibleOptions = new ArrayList<>();

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Float getInitialPrice() {
        return initialPrice;
    }
    public void setInitialPrice(Float initialPrice) {
        this.initialPrice = initialPrice;
    }

    public List<Long> getSelectedRequiredOptions() {
        return selectedRequiredOptions;
    }

    public void setSelectedRequiredOptions(List<Long> selectedRequiredOptions) {
        this.selectedRequiredOptions = selectedRequiredOptions;
    }

    public List<Long> getSelectedIncompatibleOptions() {
        return selectedIncompatibleOptions;
    }

    public void setSelectedIncompatibleOptions(List<Long> selectedIncompatibleOptions) {
        this.selectedIncompatibleOptions = selectedIncompatibleOptions;
    }
}
