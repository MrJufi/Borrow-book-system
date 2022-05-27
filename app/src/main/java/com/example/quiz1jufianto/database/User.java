package com.example.quiz1jufianto.database;

public class User {

    //DATABASE User or ERD User

    private String id, email, password, phone, dob;

        public User(String id, String email, String password, String phone, String dob) {
            this.id = id;
            this.email = email;
            this.password = password;
            this.phone = phone;
            this.dob = dob;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getDob() {
            return dob;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

}
