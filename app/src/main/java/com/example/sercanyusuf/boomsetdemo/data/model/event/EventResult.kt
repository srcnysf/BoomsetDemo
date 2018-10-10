package com.example.sercanyusuf.boomsetdemo.data.model.event

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


@Entity(tableName = "event_result")
class EventResult(@field:SerializedName("timezone")
             @field:Expose
             var timezone: Int?) {

    @PrimaryKey
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @ColumnInfo(name = "group")
    @SerializedName("group")
    @Expose
    var group: Group? = null
    @ColumnInfo(name = "name")
    @SerializedName("name")
    @Expose
    var name: String? = null
    @ColumnInfo(name = "startsat")
    @SerializedName("startsat")
    @Expose
    var startsat: String? = null
    @ColumnInfo(name = "endsat")
    @SerializedName("endsat")
    @Expose
    var endsat: String? = null
    @ColumnInfo(name = "premium")
    @SerializedName("premium")
    @Expose
    var premium: Boolean? = null

    @ColumnInfo(name = "created")
    @SerializedName("created")
    @Expose
    var created: String? = null

    @ColumnInfo(name = "modified")
    @SerializedName("modified")
    @Expose
    var modified: String? = null

}
