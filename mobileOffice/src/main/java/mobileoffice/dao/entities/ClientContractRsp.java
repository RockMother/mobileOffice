package mobileoffice.dao.entities;

import base.contracts.HasLongId;

import java.util.Collection;

/*
    !!!! AUTOGENERATED !!!!!
*/
public class ClientContractRsp implements HasLongId {
        private long id;
        private long clientId;
        private long contractId;
        private Client clientByClientId;
        private Contract contractByContractId;

        public long getId(){
            return this.id;
        }

        public void setId (long id) {
            this.id = id;
        }
        public long getClientId(){
            return this.clientId;
        }

        public void setClientId (long clientId) {
            this.clientId = clientId;
        }
        public long getContractId(){
            return this.contractId;
        }

        public void setContractId (long contractId) {
            this.contractId = contractId;
        }
        public Client getClientByClientId(){
        return this.clientByClientId;
        }

        public void setClientByClientId (Client clientByClientId) {
        this.clientByClientId = clientByClientId;
        }
        public Contract getContractByContractId(){
        return this.contractByContractId;
        }

        public void setContractByContractId (Contract contractByContractId) {
        this.contractByContractId = contractByContractId;
        }
}