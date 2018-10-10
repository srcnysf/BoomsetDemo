package com.example.sercanyusuf.boomsetdemo.di.components


import android.app.Application
import com.example.sercanyusuf.boomsetdemo.di.modules.AppModule
import com.example.sercanyusuf.boomsetdemo.di.modules.LocalModule
import com.example.sercanyusuf.boomsetdemo.di.modules.NetModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, LocalModule::class,NetModule::class))
interface AppComponent {
    fun inject(BoomsetApp: Application)
}