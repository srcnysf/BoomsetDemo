package com.example.sercanyusuf.boomsetdemo

import android.app.Application

import com.example.sercanyusuf.boomsetdemo.di.components.AppComponent
import com.example.sercanyusuf.boomsetdemo.di.components.DaggerAppComponent
import com.example.sercanyusuf.boomsetdemo.di.modules.AppModule


class BoomsetApp : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}

