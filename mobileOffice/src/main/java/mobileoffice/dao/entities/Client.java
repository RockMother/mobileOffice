package mobileoffice.dao.entities

import base.contracts.HasLongId;

public class Client implements HasLongId {
        private long id
        private String name
        private String lastName
        private java.util.Date birthdate
        private String passport
        private String address
        private String email
        private String passwordHash

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
        public java.util.Date getBirthdate(){
            return this.birthdate;
        }

        public void setBirthdate (java.util.Date birthdate) {
            this.birthdate = birthdate;
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
        public String getPasswordHash(){
            return this.passwordHash;
        }

        public void setPasswordHash (String passwordHash) {
            this.passwordHash = passwordHash;
        }
}