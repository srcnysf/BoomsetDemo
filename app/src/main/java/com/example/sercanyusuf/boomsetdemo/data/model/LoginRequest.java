package com.example.sercanyusuf.boomsetdemo.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class LoginRequest {
    @Expose
    @SerializedName("username")
    private String username;

    @Expose
    @SerializedName("password")
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginRequest() {
    }

//    @Override
//    public boolean equals(Object object) {
//        if (this == object) {
//            return true;
//        }
//        if (object == null || getClass() != object.getClass()) {
//            return false;
//        }
//
//        LoginRequest that = (LoginRequest) object;
//
//        if (username != null ? !username.equals(that.username) : that.username != null) {
//            return false;
//        }
//        return password != null ? password.equals(that.password) : that.password == null;
//    }

}
