package com.example.regis;

import com.google.gson.annotations.SerializedName;

public class RegModel {
        @SerializedName("username")
        private String username;

        @SerializedName("email")
    private String email;
        @SerializedName("password")
    private String password;


        public RegModel(String name, String email, String password){
            this.email = email;
            this.username = name;
            this.password = password;
        }

    public String getName() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
