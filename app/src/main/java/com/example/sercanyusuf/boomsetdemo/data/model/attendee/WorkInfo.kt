package com.example.sercanyusuf.boomsetdemo.data.model.attendee

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WorkInfo {

    @SerializedName("website")
    @Expose
    var website: String? = null
    @SerializedName("fax")
    @Expose
    var fax: String? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("company")
    @Expose
    var company: String? = null
    @SerializedName("blog")
    @Expose
    var blog: String? = null
    @SerializedName("phone")
    @Expose
    var phone: String? = null

}
