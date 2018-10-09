package com.example.sercanyusuf.boomsetdemo.di.components


import android.app.Application
import com.example.sercanyusuf.boomsetdemo.di.modules.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(app: Application)
}