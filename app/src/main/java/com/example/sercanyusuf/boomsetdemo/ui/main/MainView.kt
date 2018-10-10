package com.example.sercanyusuf.boomsetdemo.ui.main

import com.example.sercanyusuf.boomsetdemo.data.model.attendee.AttendeeResult
import com.example.sercanyusuf.boomsetdemo.data.model.event.EventResult

interface MainView {

    interface View{

        fun ListEvents(events: List<EventResult>)

        fun ListAttendees(attendees: List<AttendeeResult>)

        fun displayNetworkError()

        fun displayDatabaseError()

    }

    interface Presenter{

        fun  listEvents()

        fun listAttendees(eventId:Int)

        fun listAttendees(eventId:Int, pageNumber:Int)

        fun getEvent(eventId: Int)


    }

}
