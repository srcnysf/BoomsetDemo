package com.example.sercanyusuf.boomsetdemo.data.remote

import com.example.sercanyusuf.boomsetdemo.data.model.attendee.Attendees
import com.example.sercanyusuf.boomsetdemo.data.model.event.Events
import com.example.sercanyusuf.boomsetdemoapp.data.remote.ApiHelper
import retrofit2.Call
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiManager @Inject
constructor(private val apiService: ApiHelper) {

    private var event_id: Int? = null

    val eventList: Call<Events>?
        get() = apiService.eventsRequest()


    val attendeeList: Call<Attendees>?
        get() = apiService.attendeeRequest(event_id)

    fun getEventId(eventId: Int) {
        this.event_id = eventId
    }
}
