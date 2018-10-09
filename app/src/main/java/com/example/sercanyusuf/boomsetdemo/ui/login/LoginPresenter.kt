package com.example.sercanyusuf.boomsetdemo.ui.login

import android.text.TextUtils
import android.util.Log
import com.example.sercanyusuf.boomsetdemo.data.model.LoginRequest
import com.example.sercanyusuf.boomsetdemo.data.model.LoginResponse
import com.example.sercanyusuf.boomsetdemo.di.modules.NetModule
import com.example.sercanyusuf.boomsetdemoapp.data.remote.ApiHelper
import com.example.sercanyusuf.boomsetdemoapp.di.scope.PerApplication
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@PerApplication
class LoginPresenter @Inject
constructor() {


    private var mLoginView: LoginView? = null
    private var username: String? = null
    private var password: String? = null
    private var apiHelper: ApiHelper? = null


    fun isEmailAndPasswordValid(username: String, password: String): Boolean {
        // validate username and password
        if (TextUtils.isEmpty(username)) {
            return false
        }
        return if (TextUtils.isEmpty(password)) {
            false
        } else true
    }

    fun setView(loginView: LoginView) {
        this.mLoginView = loginView
    }


    fun login(username: String, password: String) {
        this.username = username
        this.password = password
        val loginRequestSend = LoginRequest()
        loginRequestSend.username = username
        loginRequestSend.password = password
        apiHelper = NetModule.client!!.create(ApiHelper::class.java)
        val call = apiHelper!!.loginRequest(loginRequestSend)
        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {

                val loginResponse = LoginResponse()
                val responseBody = response.body()
                loginResponse.token = responseBody!!.token

                mLoginView!!.onLoginSuccessful()


                Log.d("TAG", loginResponse.token)
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {

            }

        })

    }


}
