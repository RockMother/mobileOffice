package mobileoffice.dao.entities;

import base.dao.contracts.HasLongId;
import java.io.Serializable;

import java.util.Collection;

/*
!!!! AUTOGENERATED !!!!!
*/
public class Client implements HasLongId, Serializable {
    public Client() { }
    private long id;
    private String name;
    private String lastName;
    private java.sql.Date birthday;
    private String passport;
    private String address;
    private String email;
    private long userId;
    private Boolean locked;
    private Boolean lockedByAdmin;
    private Collection<Contract> contractsByClientId;

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
    public String getLastName(){
        return this.lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }
    public java.sql.Date getBirthday(){
        return this.birthday;
    }

    public void setBirthday (java.sql.Date birthday) {
        this.birthday = birthday;
    }
    public String getPassport(){
        return this.passport;
    }

    public void setPassport (String passport) {
        this.passport = passport;
    }
    public String getAddress(){
        return this.address;
    }

    public void setAddress (String address) {
        this.address = address;
    }
    public String getEmail(){
        return this.email;
    }

    public void setEmail (String email) {
        this.email = email;
    }
    public long getUserId(){
        return this.userId;
    }

    public void setUserId (long userId) {
        this.userId = userId;
    }
    public Boolean getLocked(){
        return this.locked;
    }

    public void setLocked (Boolean locked) {
        this.locked = locked;
    }
    public Boolean getLockedByAdmin(){
        return this.lockedByAdmin;
    }

    public void setLockedByAdmin (Boolean lockedByAdmin) {
        this.lockedByAdmin = lockedByAdmin;
    }
    public Collection<Contract> getContractsByClientId(){
        return this.contractsByClientId;
    }

    public void setContractsByClientId (Collection<Contract> contractsByClientId) {
        this.contractsByClientId = contractsByClientId;
    }
}