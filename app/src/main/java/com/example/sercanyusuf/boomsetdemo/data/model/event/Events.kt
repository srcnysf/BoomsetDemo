package com.example.sercanyusuf.boomsetdemo.data.model.event

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import io.reactivex.annotations.Nullable
@Entity(tableName = "event_result")
class Events {
    @ColumnInfo(name = "count")
    @SerializedName("count")
    @Expose
    var count: Int? = null

    @ColumnInfo(name = "next")
    @SerializedName("next")
    @Expose
    var next: Any? = null

    @ColumnInfo(name = "previous")
    @SerializedName("previous")
    @Expose
    var previous: Any? = null

    @ColumnInfo(name = "results")
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
