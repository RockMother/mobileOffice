package mobileoffice.dao.entities;

import base.contracts.HasLongId;

/**
 * Created by kiril_000 on 22.03.2017.
 */
public class TariffTariffOptionEntity implements HasLongId {
    private long id;
    private Long tariffId;
    private Long tariffOptionId;
    private TariffEntity tariffByTariffId;
    private TariffOptionEntity tariffOptionByTariffOptionId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getTariffId() {
        return tariffId;
    }

    public void setTariffId(Long tariffId) {
        this.tariffId = tariffId;
    }

    public Long getTariffOptionId() {
        return tariffOptionId;
    }

    public void setTariffOptionId(Long tariffOptionId) {
        this.tariffOptionId = tariffOptionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TariffTariffOptionEntity that = (TariffTariffOptionEntity) o;

        if (id != that.id) return false;
        if (tariffId != null ? !tariffId.equals(that.tariffId) : that.tariffId != null) return false;
        if (tariffOptionId != null ? !tariffOptionId.equals(that.tariffOptionId) : that.tariffOptionId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (tariffId != null ? tariffId.hashCode() : 0);
        result = 31 * result + (tariffOptionId != null ? tariffOptionId.hashCode() : 0);
        return result;
    }

    public TariffEntity getTariffByTariffId() {
        return tariffByTariffId;
    }

    public void setTariffByTariffId(TariffEntity tariffByTariffId) {
        this.tariffByTariffId = tariffByTariffId;
    }

    public TariffOptionEntity getTariffOptionByTariffOptionId() {
        return tariffOptionByTariffOptionId;
    }

    public void setTariffOptionByTariffOptionId(TariffOptionEntity tariffOptionByTariffOptionId) {
        this.tariffOptionByTariffOptionId = tariffOptionByTariffOptionId;
    }
}
