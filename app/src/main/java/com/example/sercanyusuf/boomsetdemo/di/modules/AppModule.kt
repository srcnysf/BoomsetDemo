package com.example.sercanyusuf.boomsetdemo.di.modules

import com.example.sercanyusuf.boomsetdemo.BoomsetApp
import com.example.sercanyusuf.boomsetdemo.data.repository.DateRepositoryImplementation
import com.example.sercanyusuf.boomsetdemo.data.repository.EventRepository
import com.example.sercanyusuf.boomsetdemoapp.di.scope.PerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: BoomsetApp) {
    @Provides
    @Singleton
    fun provideApplication() = app

    @Provides
    @PerApplication
    internal fun provideLoginInteractor(dataManager: DateRepositoryImplementation): EventRepository {
        return dataManager
    }

}