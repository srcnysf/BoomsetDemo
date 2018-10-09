package com.example.sercanyusuf.boomsetdemo.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginRequest {
    @Expose
    @SerializedName("username")
    var username: String? = null

    @Expose
    @SerializedName("password")
    var password: String? = null

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
