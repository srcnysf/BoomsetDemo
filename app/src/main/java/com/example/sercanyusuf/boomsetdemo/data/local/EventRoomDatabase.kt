package com.example.sercanyusuf.boomsetdemo.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

import com.example.sercanyusuf.boomsetdemo.data.model.event.EventResult
import com.example.sercanyusuf.boomsetdemo.data.model.event.Events
import com.example.sercanyusuf.boomsetdemoapp.data.local.EventsDao

@Database(entities = arrayOf(Events::class, EventResult::class), version = 1, exportSchema = false)
abstract class EventRoomDatabase : RoomDatabase() {

    abstract fun eventsDao(): EventsDao

    companion object {

        private var instance: EventRoomDatabase? = null

        fun getDatabase(context: Context): EventRoomDatabase? {
            if (instance == null) {
                synchronized(EventRoomDatabase::class.java) {
                    if (instance == null) {
                        instance = Room.databaseBuilder(context.applicationContext,
                                EventRoomDatabase::class.java, "currency_db")
                                .build()
                    }
                }
            }
            return instance
        }
    }
}
