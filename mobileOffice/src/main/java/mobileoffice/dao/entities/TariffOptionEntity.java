package mobileoffice.dao.entities;

import base.contracts.HasLongId;

import java.util.Collection;

/**
 * Created by kiril_000 on 22.03.2017.
 */
public class TariffOptionEntity implements HasLongId {
    private long id;
    private int price;
    private int intialPrice;
    private Collection<TariffTariffOptionEntity> tariffTariffOptionsById;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getIntialPrice() {
        return intialPrice;
    }

    public void setIntialPrice(int intialPrice) {
        this.intialPrice = intialPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TariffOptionEntity that = (TariffOptionEntity) o;

        if (id != that.id) return false;
        if (price != that.price) return false;
        if (intialPrice != that.intialPrice) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + price;
        result = 31 * result + intialPrice;
        return result;
    }

    public Collection<TariffTariffOptionEntity> getTariffTariffOptionsById() {
        return tariffTariffOptionsById;
    }

    public void setTariffTariffOptionsById(Collection<TariffTariffOptionEntity> tariffTariffOptionsById) {
        this.tariffTariffOptionsById = tariffTariffOptionsById;
    }
}
