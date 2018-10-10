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

}
