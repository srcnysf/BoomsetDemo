package com.example.sercanyusuf.boomsetdemo.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: Application) {
    @Provides @Singleton
    fun provideApplication() = app
}