package com.example.sercanyusuf.boomsetdemo.data.repository

import com.example.sercanyusuf.boomsetdemo.data.model.event.EventResult
import com.example.sercanyusuf.boomsetdemo.data.model.event.Events

import retrofit2.Call

interface EventRepository {

    val eventsRemote: Call<Events>

    val eventsLocal: Call<Events>

    fun saveEvents(events: List<EventResult>)
}
