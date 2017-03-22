package mobileoffice.dao.entities;

import base.contracts.IHasLongId;

/**
 * Created by kiril_000 on 22.03.2017.
 */
public class ClientContractEntity implements IHasLongId {
    private long id;
    private long clientId;
    private long contractId;
    private ClientEntity clientByClientId;
    private ContractEntity contractByContractId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getContractId() {
        return contractId;
    }

    public void setContractId(long contractId) {
        this.contractId = contractId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientContractEntity that = (ClientContractEntity) o;

        if (id != that.id) return false;
        if (clientId != that.clientId) return false;
        if (contractId != that.contractId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (clientId ^ (clientId >>> 32));
        result = 31 * result + (int) (contractId ^ (contractId >>> 32));
        return result;
    }

    public ClientEntity getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(ClientEntity clientByClientId) {
        this.clientByClientId = clientByClientId;
    }

    public ContractEntity getContractByContractId() {
        return contractByContractId;
    }

    public void setContractByContractId(ContractEntity contractByContractId) {
        this.contractByContractId = contractByContractId;
    }
}
