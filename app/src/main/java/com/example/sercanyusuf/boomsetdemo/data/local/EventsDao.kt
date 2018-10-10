package com.example.sercanyusuf.boomsetdemoapp.data.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.sercanyusuf.boomsetdemo.data.model.event.EventResult

@Dao
interface EventsDao {

    @Query("SELECT * FROM event_result")
    fun eventsRequest(): List<EventResult>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(events: List<EventResult>)
}
