package com.example.sercanyusuf.boomsetdemo.ui.main

import android.util.Log
import com.example.sercanyusuf.boomsetdemo.data.model.attendee.Attendees
import com.example.sercanyusuf.boomsetdemo.data.model.event.Events
import com.example.sercanyusuf.boomsetdemo.di.modules.NetModule
import com.example.sercanyusuf.boomsetdemoapp.data.remote.ApiHelper
import com.example.sercanyusuf.boomsetdemoapp.di.scope.PerApplication
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

@PerApplication
class MainPresenter : MainView.Presenter {

    private var mEventsView: MainView.View? = null
    private var eventId: Int? = null

    fun setView(mEventsView: MainView.View) {
        this.mEventsView = mEventsView
    }

    override fun getEvent(eventId: Int) {
        this.eventId = eventId
    }

    override fun listEvents() {
        val apiHelper = NetModule.client!!.create(ApiHelper::class.java)
        val call = apiHelper.eventsRequest()
        Objects.requireNonNull<Call<Events>>(call).enqueue(object : Callback<Events> {
            override fun onResponse(call: Call<Events>, response: Response<Events>) {
                val events = Objects.requireNonNull<Events>(response.body()).results
                val results = Events()
                results.results = events
                mEventsView!!.ListEvents(events!!)
            }

            override fun onFailure(call: Call<Events>, t: Throwable) {
                Log.d("TAG", t.toString())
            }
        })
    }

    override fun listAttendees(eventId: Int) {
        val apiHelper = NetModule.client!!.create(ApiHelper::class.java)
        val call = apiHelper.attendeeRequest(eventId = eventId)
        Objects.requireNonNull<Call<Attendees>>(call).enqueue(object : Callback<Attendees> {
            override fun onResponse(call: Call<Attendees>, response: Response<Attendees>) {
                val attendees = Objects.requireNonNull<Attendees>(response.body()).results
                val results = Attendees()
                results.results = attendees
                mEventsView!!.ListAttendees(attendees!!)
            }

            override fun onFailure(call: Call<Attendees>, t: Throwable) {
                Log.d("TAG", t.toString())
            }
        })
    }

    override fun listAttendees(eventId: Int, pageNumber: Int) {
        val apiHelper = NetModule.client!!.create(ApiHelper::class.java)
        val call = apiHelper.attendeeRequest(eventId = eventId, page = pageNumber)
        Objects.requireNonNull<Call<Attendees>>(call).enqueue(object : Callback<Attendees> {
            override fun onResponse(call: Call<Attendees>, response: Response<Attendees>) {
                val attendees = Objects.requireNonNull<Attendees>(response.body()).results
                val results = Attendees()
                results.results = attendees
                mEventsView!!.ListAttendees(attendees!!)
            }

            override fun onFailure(call: Call<Attendees>, t: Throwable) {
                Log.d("TAG", t.toString())
            }
        })
    }
}

