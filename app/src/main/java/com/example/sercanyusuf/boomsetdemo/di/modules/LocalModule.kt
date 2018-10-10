package com.example.sercanyusuf.boomsetdemo.di.modules

import android.content.Context

import com.example.sercanyusuf.boomsetdemo.data.local.EventRoomDatabase

import dagger.Module
import dagger.Provides

@Module
class LocalModule {

    @Provides
    internal fun provideRoomDatabase(context: Context): EventRoomDatabase? {
        return EventRoomDatabase.getDatabase(context)
    }
}
