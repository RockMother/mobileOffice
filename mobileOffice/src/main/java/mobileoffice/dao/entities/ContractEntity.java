package mobileoffice.dao.entities;

import base.contracts.HasLongId;

import java.util.Collection;

/**
 * Created by kiril_000 on 22.03.2017.
 */
public class ContractEntity implements HasLongId {
    private long id;
    private String number;
    private long tariffId;
    private Collection<ClientContractEntity> clientContractsById;
    private TariffEntity tariffByTariffId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public long getTariffId() {
        return tariffId;
    }

    public void setTariffId(long tariffId) {
        this.tariffId = tariffId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContractEntity that = (ContractEntity) o;

        if (id != that.id) return false;
        if (tariffId != that.tariffId) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (int) (tariffId ^ (tariffId >>> 32));
        return result;
    }

    public Collection<ClientContractEntity> getClientContractsById() {
        return clientContractsById;
    }

    public void setClientContractsById(Collection<ClientContractEntity> clientContractsById) {
        this.clientContractsById = clientContractsById;
    }

    public TariffEntity getTariffByTariffId() {
        return tariffByTariffId;
    }

    public void setTariffByTariffId(TariffEntity tariffByTariffId) {
        this.tariffByTariffId = tariffByTariffId;
    }
}
