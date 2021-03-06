package mobileoffice.dao.entities;

import base.dao.contracts.HasLongId;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;

/*
!!!! AUTOGENERATED !!!!!
*/
public class Contract implements HasLongId, Serializable {
    public Contract() { }
    private long id;
    private String number;
    private long tariffId;
    private long clientId;
    private Boolean isBlocked;
    private Boolean isAdminBlocker;
    private Collection<ContractOptionRsp> contractOptionRspsByContractId;

    public long getId(){
        return this.id;
    }

    public void setId (long id) {
        this.id = id;
    }
    public String getNumber(){
        return this.number;
    }

    public void setNumber (String number) {
        this.number = number;
    }
    public long getTariffId(){
        return this.tariffId;
    }

    public void setTariffId (long tariffId) {
        this.tariffId = tariffId;
    }
    public long getClientId(){
        return this.clientId;
    }

    public void setClientId (long clientId) {
        this.clientId = clientId;
    }
    public Boolean getIsBlocked(){
        return this.isBlocked;
    }

    public void setIsBlocked (Boolean isBlocked) {
        this.isBlocked = isBlocked;
    }
    public Boolean getIsAdminBlocker(){
        return this.isAdminBlocker;
    }

    public void setIsAdminBlocker (Boolean isAdminBlocker) {
        this.isAdminBlocker = isAdminBlocker;
    }
    @JsonIgnore
    public Collection<ContractOptionRsp> getContractOptionRspsByContractId(){
        return this.contractOptionRspsByContractId;
    }

    public void setContractOptionRspsByContractId (Collection<ContractOptionRsp> contractOptionRspsByContractId) {
        this.contractOptionRspsByContractId = contractOptionRspsByContractId;
    }
}