package com.example.sercanyusuf.boomsetdemo.ui.main

import android.util.Log
import com.example.sercanyusuf.boomsetdemo.data.model.Events
import com.example.sercanyusuf.boomsetdemo.di.modules.NetModule
import com.example.sercanyusuf.boomsetdemoapp.data.remote.ApiHelper
import com.example.sercanyusuf.boomsetdemoapp.di.scope.PerApplication
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import javax.inject.Inject

@PerApplication
class MainPresenter @Inject
constructor() {

    private var mEventsView: MainView? = null

    fun setView(eventsView: MainView) {
        this.mEventsView = eventsView
    }

    fun listEvents() {
        val apiHelper = NetModule.client!!.create(ApiHelper::class.java)
        val call = apiHelper.eventsRequest()
        Objects.requireNonNull<Call<Events>>(call).enqueue(object : Callback<Events> {
            override fun onResponse(call: Call<Events>, response: Response<Events>) {
                val events = Objects.requireNonNull<Events>(response.body()).results
                val events1 = Events()
                events1.results = events

                mEventsView!!.ListEvents(events)

                Log.d("TAG", events.toString())
                Log.d("TAG", events1.results.toString())

            }

            override fun onFailure(call: Call<Events>, t: Throwable) {
                Log.d("TAG", t.toString())
            }
        })
    }

}
