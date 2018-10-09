package com.example.sercanyusuf.boomsetdemo.data.model.event

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class EventResult(@field:SerializedName("timezone")
             @field:Expose
             var timezone: Int?) {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("group")
    @Expose
    var group: Group? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("startsat")
    @Expose
    var startsat: String? = null
    @SerializedName("endsat")
    @Expose
    var endsat: String? = null
    @SerializedName("premium")
    @Expose
    var premium: Boolean? = null
    @SerializedName("created")
    @Expose
    var created: String? = null
    @SerializedName("modified")
    @Expose
    var modified: String? = null

}
