package mobileoffice.dao.entities;

import base.dao.contracts.HasLongId;
import java.io.Serializable;

import java.util.Collection;

/*
!!!! AUTOGENERATED !!!!!
*/
public class Users implements HasLongId, Serializable {
    public Users() { }
    private long id;
    private String userName;
    private String password;
    private Boolean enabled;
    private Collection<Authorities> authoritiessById;
    private Collection<Client> clientsById;
    private Collection<Manager> managersById;

    public long getId(){
        return this.id;
    }

    public void setId (long id) {
        this.id = id;
    }
    public String getUserName(){
        return this.userName;
    }

    public void setUserName (String userName) {
        this.userName = userName;
    }
    public String getPassword(){
        return this.password;
    }

    public void setPassword (String password) {
        this.password = password;
    }
    public Boolean getEnabled(){
        return this.enabled;
    }

    public void setEnabled (Boolean enabled) {
        this.enabled = enabled;
    }
    public Collection<Authorities> getAuthoritiessById(){
        return this.authoritiessById;
    }

    public void setAuthoritiessById (Collection<Authorities> authoritiessById) {
        this.authoritiessById = authoritiessById;
    }
    public Collection<Client> getClientsById(){
        return this.clientsById;
    }

    public void setClientsById (Collection<Client> clientsById) {
        this.clientsById = clientsById;
    }
    public Collection<Manager> getManagersById(){
        return this.managersById;
    }

    public void setManagersById (Collection<Manager> managersById) {
        this.managersById = managersById;
    }
}