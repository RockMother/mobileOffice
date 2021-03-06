package mobileoffice.models;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kisc on 4/3/2017.
 */
public class TariffModel {
    private String name;
    private Float price;
    private Set<Long> selectedOptions = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Set<Long> getSelectedOptions() {
        return selectedOptions;
    }

    public void setSelectedOptions(Set<Long> selectedOptions) {
        this.selectedOptions = selectedOptions;
    }
}
