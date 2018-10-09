package com.example.sercanyusuf.boomsetdemo.ui.main

import com.example.sercanyusuf.boomsetdemo.data.model.attendee.AttendeeResult
import com.example.sercanyusuf.boomsetdemo.data.model.event.EventResult

interface MainView {

    fun ListEvents(events: List<EventResult>)
    fun ListAttendees(attendees: List<AttendeeResult>)


    //void displayResult(String result);

    fun displayNetworkError()

    fun displayDatabaseError()


}
