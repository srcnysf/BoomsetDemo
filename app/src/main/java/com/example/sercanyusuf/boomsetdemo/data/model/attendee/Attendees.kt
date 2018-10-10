package com.example.sercanyusuf.boomsetdemo.data.model.attendee

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
@Entity(tableName = "attendees")
class Attendees {

    @SerializedName("count")
    @Expose
    @ColumnInfo(name = "count")
    var count: Int? = null
    @SerializedName("next")
    @Expose
    @ColumnInfo(name = "next")
    var next: Any? = null
    @SerializedName("previous")
    @Expose
    @ColumnInfo(name = "previous")
    var previous: Any? = null
    @SerializedName("results")
    @Expose
    @ColumnInfo(name = "results")
    var results: List<AttendeeResult>? = null

}
