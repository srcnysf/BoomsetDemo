package com.example.sercanyusuf.boomsetdemo.data.model.event

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "group")
class Group {

    @SerializedName("id")
    @Expose
    @PrimaryKey
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("email")
    @Expose
    var email: Any? = null
    @SerializedName("phone")
    @Expose
    var phone: String? = null
    @SerializedName("website")
    @Expose
    var website: Any? = null
    @SerializedName("fbpage")
    @Expose
    var fbpage: Any? = null
    @SerializedName("twitter")
    @Expose
    var twitter: Any? = null
    @SerializedName("googleplus")
    @Expose
    var googleplus: Any? = null

}
