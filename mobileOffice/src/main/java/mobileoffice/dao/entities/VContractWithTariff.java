package mobileoffice.dao.entities;

import base.dao.contracts.HasLongId;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;

/*
!!!! AUTOGENERATED !!!!!
*/
public class VContractWithTariff implements HasLongId, Serializable {
    public VContractWithTariff() { }
    private long id;
    private String name;
    private String number;
    private Boolean isBlocked;
    private Boolean isAdminBlocker;
    private long clientId;
    private long userId;
    private long tariffId;

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
    public String getNumber(){
        return this.number;
    }

    public void setNumber (String number) {
        this.number = number;
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
    public long getClientId(){
        return this.clientId;
    }

    public void setClientId (long clientId) {
        this.clientId = clientId;
    }
    public long getUserId(){
        return this.userId;
    }

    public void setUserId (long userId) {
        this.userId = userId;
    }
    public long getTariffId(){
        return this.tariffId;
    }

    public void setTariffId (long tariffId) {
        this.tariffId = tariffId;
    }
}