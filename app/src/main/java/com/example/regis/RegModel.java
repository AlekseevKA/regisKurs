package com.example.regis;

import com.google.gson.annotations.SerializedName;

public class RegModel {
        @SerializedName("name")
        private String name;

        @SerializedName("email")
    private String email;
        @SerializedName("password")
    private String password;


        public RegModel(String name, String email, String password){
            this.email = email;
            this.name = name;
            this.password = password;
        }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
