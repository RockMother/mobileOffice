package mobileoffice.dao.entities

import base.contracts.HasLongId;

public class TariffOption implements HasLongId {
        private long id
        private Float price
        private Float intialPrice

        public long getId(){
            return this.id;
        }

        public void setId (long id) {
            this.id = id;
        }
        public Float getPrice(){
            return this.price;
        }

        public void setPrice (Float price) {
            this.price = price;
        }
        public Float getIntialPrice(){
            return this.intialPrice;
        }

        public void setIntialPrice (Float intialPrice) {
            this.intialPrice = intialPrice;
        }
}