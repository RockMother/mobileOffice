package mobileoffice.dao.entities

import base.contracts.HasLongId;

public class Contract implements HasLongId {
        private long id
        private String number
        private long tariffId

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
}