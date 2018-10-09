package com.example.sercanyusuf.boomsetdemo.di.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
@Module
public class AppModule {

    private Application mApp;

    public AppModule(Application app) {
        this.mApp = app;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return mApp;
    }
}
