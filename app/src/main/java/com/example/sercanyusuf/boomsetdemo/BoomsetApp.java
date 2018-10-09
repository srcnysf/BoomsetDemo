package com.example.sercanyusuf.boomsetdemo;

import android.app.Application;

import com.example.sercanyusuf.boomsetdemo.di.components.AppComponent;
import com.example.sercanyusuf.boomsetdemo.di.components.DaggerAppComponent;
import com.example.sercanyusuf.boomsetdemo.di.modules.AppModule;


public class BoomsetApp extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}

