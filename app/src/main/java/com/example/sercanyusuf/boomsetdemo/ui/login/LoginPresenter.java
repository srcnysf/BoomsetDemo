package com.example.sercanyusuf.boomsetdemo.ui.login;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import com.example.sercanyusuf.boomsetdemo.data.model.LoginRequest;
import com.example.sercanyusuf.boomsetdemo.data.model.LoginResponse;
import com.example.sercanyusuf.boomsetdemo.di.modules.NetModule;
import com.example.sercanyusuf.boomsetdemoapp.data.remote.ApiHelper;
import com.example.sercanyusuf.boomsetdemoapp.di.scope.PerApplication;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


@PerApplication
public class LoginPresenter{


    private LoginView mLoginView;
    private String username;
    private String password;
    private ApiHelper apiHelper;

    @Inject
    public LoginPresenter() {
    }


    public boolean isEmailAndPasswordValid(String username, String password) {
        // validate username and password
        if (TextUtils.isEmpty(username)) {
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            return false;
        }
        return true;
    }

    public void setView(LoginView loginView){
        this.mLoginView = loginView;
    }



    public void login(String username, String password) {
        this.username = username;
        this.password = password;
        LoginRequest loginRequestSend = new LoginRequest();
        loginRequestSend.setUsername(username);
        loginRequestSend.setPassword(password);
        apiHelper = NetModule.INSTANCE.getClient().create(ApiHelper.class);
        Call<LoginResponse> call = apiHelper.loginRequest(loginRequestSend);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {

                LoginResponse loginResponse = new LoginResponse();
                LoginResponse responseBody = response.body();
                loginResponse.setToken(responseBody.getToken());

                mLoginView.onLoginSuccessful();


                Log.d("TAG", loginResponse.token);
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, Throwable t) {

            }

        });

    }



}
