package mobileoffice.dao.entities;

import base.contracts.HasLongId;

import java.util.Collection;

/**
 * Created by kiril_000 on 22.03.2017.
 */
public class TariffEntity implements HasLongId {
    private long id;
    private String name;
    private Integer price;
    private Collection<ContractEntity> contractsById;
    private Collection<TariffTariffOptionEntity> tariffTariffOptionsById;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TariffEntity that = (TariffEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    public Collection<ContractEntity> getContractsById() {
        return contractsById;
    }

    public void setContractsById(Collection<ContractEntity> contractsById) {
        this.contractsById = contractsById;
    }

    public Collection<TariffTariffOptionEntity> getTariffTariffOptionsById() {
        return tariffTariffOptionsById;
    }

    public void setTariffTariffOptionsById(Collection<TariffTariffOptionEntity> tariffTariffOptionsById) {
        this.tariffTariffOptionsById = tariffTariffOptionsById;
    }
}
