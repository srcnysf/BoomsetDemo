package com.example.sercanyusuf.boomsetdemo.data.model.event

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import io.reactivex.annotations.Nullable

class Events {

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
    @Nullable
    var results: List<EventResult>? = null

    init {
        this.count = count
        this.next = next
        this.previous = previous
        this.results = results
    }

}
