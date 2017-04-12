package mobileoffice.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kisc on 4/11/2017.
 */
public class EditContractModel {
    private long id;
    private List<Long> selectedOptions = new ArrayList<>();
    private Long tariffId;
    private String blocked;
    private Long clientId;

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

    public boolean isBlocked() {
        return blocked != null && blocked.equals("true");
    }

    public void setBlocked(String blocked) {
        this.blocked = blocked;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
