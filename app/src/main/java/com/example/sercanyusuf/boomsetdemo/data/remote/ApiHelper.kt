package com.example.sercanyusuf.boomsetdemoapp.data.remote

import com.example.sercanyusuf.boomsetdemo.data.model.LoginRequest
import com.example.sercanyusuf.boomsetdemo.data.model.LoginResponse
import com.example.sercanyusuf.boomsetdemo.util.AppConstants
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiHelper {


    //@Headers("Authorization: Token 4f81fed8ec862793b0abb9318b2066c47439bb13")
    @POST(AppConstants.LOGIN)
    fun loginRequest(@Body loginRequest: LoginRequest): Call<LoginResponse>


}
