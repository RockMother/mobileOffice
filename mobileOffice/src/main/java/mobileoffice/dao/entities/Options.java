package mobileoffice.dao.entities;

import base.dao.contracts.HasLongId;
import java.io.Serializable;

import java.util.Collection;

/*
!!!! AUTOGENERATED !!!!!
*/
public class Options implements HasLongId, Serializable {
    public Options() { }
    private long id;
    private Float initialPrice;
    private String name;
    private Collection<ContractOptionRsp> contractOptionRspsByOptionId;
    private Collection<OptionRelationsRsp> optionRelationsRspsByOptionMainId;
    private Collection<OptionRelationsRsp> optionRelationsRspsByOptionSecondId;
    private Collection<TariffOptionsRsp> tariffOptionsRspsByTariffOptionId;

    public long getId(){
        return this.id;
    }

    public void setId (long id) {
        this.id = id;
    }
    public Float getInitialPrice(){
        return this.initialPrice;
    }

    public void setInitialPrice (Float initialPrice) {
        this.initialPrice = initialPrice;
    }
    public String getName(){
        return this.name;
    }

    public void setName (String name) {
        this.name = name;
    }
    public Collection<ContractOptionRsp> getContractOptionRspsByOptionId(){
        return this.contractOptionRspsByOptionId;
    }

    public void setContractOptionRspsByOptionId (Collection<ContractOptionRsp> contractOptionRspsByOptionId) {
        this.contractOptionRspsByOptionId = contractOptionRspsByOptionId;
    }
    public Collection<OptionRelationsRsp> getOptionRelationsRspsByOptionMainId(){
        return this.optionRelationsRspsByOptionMainId;
    }

    public void setOptionRelationsRspsByOptionMainId (Collection<OptionRelationsRsp> optionRelationsRspsByOptionMainId) {
        this.optionRelationsRspsByOptionMainId = optionRelationsRspsByOptionMainId;
    }
    public Collection<OptionRelationsRsp> getOptionRelationsRspsByOptionSecondId(){
        return this.optionRelationsRspsByOptionSecondId;
    }

    public void setOptionRelationsRspsByOptionSecondId (Collection<OptionRelationsRsp> optionRelationsRspsByOptionSecondId) {
        this.optionRelationsRspsByOptionSecondId = optionRelationsRspsByOptionSecondId;
    }
    public Collection<TariffOptionsRsp> getTariffOptionsRspsByTariffOptionId(){
        return this.tariffOptionsRspsByTariffOptionId;
    }

    public void setTariffOptionsRspsByTariffOptionId (Collection<TariffOptionsRsp> tariffOptionsRspsByTariffOptionId) {
        this.tariffOptionsRspsByTariffOptionId = tariffOptionsRspsByTariffOptionId;
    }
}