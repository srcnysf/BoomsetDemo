package com.example.sercanyusuf.boomsetdemo.ui.main

import com.example.sercanyusuf.boomsetdemo.data.model.Result

interface MainView {

    fun ListEvents(events: List<Result>)

    //void displayResult(String result);

    fun displayNetworkError()

    fun displayDatabaseError()


}
