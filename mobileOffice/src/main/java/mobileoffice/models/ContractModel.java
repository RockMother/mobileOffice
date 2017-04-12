package mobileoffice.models;

import mobileoffice.dao.entities.Options;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiril_000 on 12.04.2017.
 */
public class ContractModel {
    private Long id;
    private String number;
    private String tariffName;
    private boolean isBlocked;
    private boolean isAdminBlocker;
    List<Options> selectedOptions = new ArrayList<>();
    List<Options> availableOptions = new ArrayList<>();
    long tariffId;

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public boolean isAdminBlocker() {
        return isAdminBlocker;
    }

    public void setAdminBlocker(boolean adminBlocker) {
        isAdminBlocker = adminBlocker;
    }

    public List<Options> getSelectedOptions() {
        return selectedOptions;
    }

    public void setSelectedOptions(List<Options> selectedOptions) {
        this.selectedOptions = selectedOptions;
    }

    public List<Options> getAvailableOptions() {
        return availableOptions;
    }

    public void setAvailableOptions(List<Options> availableOptions) {
        this.availableOptions = availableOptions;
    }

    public long getTariffId() {
        return tariffId;
    }

    public void setTariffId(long tariffId) {
        this.tariffId = tariffId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTariffName() {
        return tariffName;
    }

    public void setTariffName(String tariffName) {
        this.tariffName = tariffName;
    }
}
