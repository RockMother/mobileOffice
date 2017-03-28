package mobileoffice.dao.entities;

import base.dao.contracts.HasLongId;
import java.io.Serializable;

import java.util.Collection;

/*
!!!! AUTOGENERATED !!!!!
*/
public class Tariff implements HasLongId, Serializable {
    public Tariff() { }
    private long id;
    private String name;
    private Float price;
    private Collection<Contract> contractsById;
    private Collection<TariffTariffOption> tariffTariffOptionsById;

    public long getId(){
        return this.id;
    }

    public void setId (long id) {
        this.id = id;
    }
    public String getName(){
        return this.name;
    }

    public void setName (String name) {
        this.name = name;
    }
    public Float getPrice(){
        return this.price;
    }

    public void setPrice (Float price) {
        this.price = price;
    }
    public Collection<Contract> getContractsById(){
        return this.contractsById;
    }

    public void setContractsById (Collection<Contract> contractsById) {
        this.contractsById = contractsById;
    }
    public Collection<TariffTariffOption> getTariffTariffOptionsById(){
        return this.tariffTariffOptionsById;
    }

    public void setTariffTariffOptionsById (Collection<TariffTariffOption> tariffTariffOptionsById) {
        this.tariffTariffOptionsById = tariffTariffOptionsById;
    }
}