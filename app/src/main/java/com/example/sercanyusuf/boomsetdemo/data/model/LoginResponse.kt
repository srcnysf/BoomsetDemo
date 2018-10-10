package com.example.sercanyusuf.boomsetdemo.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginResponse {
    @Expose
    @SerializedName("token")
    lateinit var token: String
}
