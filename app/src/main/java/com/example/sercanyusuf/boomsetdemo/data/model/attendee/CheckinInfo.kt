package com.example.sercanyusuf.boomsetdemo.data.model.attendee

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CheckinInfo {

    @SerializedName("timestamp")
    @Expose
    var timestamp: String? = null
    @SerializedName("source")
    @Expose
    var source: String? = null
    @SerializedName("quantity")
    @Expose
    var quantity: Int? = null

}
