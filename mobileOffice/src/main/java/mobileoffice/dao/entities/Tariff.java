package mobileoffice.dao.entities

import base.contracts.HasLongId;

public class Tariff implements HasLongId {
        private long id
        private String name
        private Float price

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
}