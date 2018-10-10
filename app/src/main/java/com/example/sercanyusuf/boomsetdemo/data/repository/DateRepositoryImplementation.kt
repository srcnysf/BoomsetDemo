package com.example.sercanyusuf.boomsetdemo.data.repository

import com.example.sercanyusuf.boomsetdemo.data.local.EventRoomDatabase
import com.example.sercanyusuf.boomsetdemo.data.model.attendee.Attendees
import com.example.sercanyusuf.boomsetdemo.data.model.event.EventResult
import com.example.sercanyusuf.boomsetdemo.data.model.event.Events
import com.example.sercanyusuf.boomsetdemo.data.remote.ApiManager
import com.example.sercanyusuf.boomsetdemoapp.di.scope.PerApplication
import retrofit2.Call
import javax.inject.Inject

@PerApplication
class DateRepositoryImplementation @Inject
constructor(private val apiManager: ApiManager, private val database: EventRoomDatabase) : EventRepository {

    override val eventsRemote: Call<Events>
        get() = apiManager.eventList!!

    val attendeesRemote: Call<Attendees>?
        get() = apiManager.attendeeList

    override val eventsLocal: Call<Events>
        get() = (database.eventsDao().eventsRequest() as Call<Events>?)!!

    override fun saveEvents(events: List<EventResult>) {
        database.eventsDao().insertAll(events)
    }
}
