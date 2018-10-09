package com.example.sercanyusuf.boomsetdemo.data.model.attendee

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Attendees {

    @SerializedName("count")
    @Expose
    var count: Int? = null
    @SerializedName("next")
    @Expose
    var next: Any? = null
    @SerializedName("previous")
    @Expose
    var previous: Any? = null
    @SerializedName("results")
    @Expose
    var results: List<AttendeeResult>? = null

}
