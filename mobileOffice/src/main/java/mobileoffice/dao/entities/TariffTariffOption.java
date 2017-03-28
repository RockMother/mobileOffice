package mobileoffice.dao.entities;

import base.dao.contracts.HasLongId;
import java.io.Serializable;

import java.util.Collection;

/*
!!!! AUTOGENERATED !!!!!
*/
public class TariffTariffOption implements HasLongId, Serializable {
    public TariffTariffOption() { }
    private long id;
    private long tariffId;
    private long tariffOptionId;

    public long getId(){
        return this.id;
    }

    public void setId (long id) {
        this.id = id;
    }
    public long getTariffId(){
        return this.tariffId;
    }

    public void setTariffId (long tariffId) {
        this.tariffId = tariffId;
    }
    public long getTariffOptionId(){
        return this.tariffOptionId;
    }

    public void setTariffOptionId (long tariffOptionId) {
        this.tariffOptionId = tariffOptionId;
    }
}