package com.example.sercanyusuf.boomsetdemo.data.model.attendee

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Contact {

    @SerializedName("prefix")
    @Expose
    var prefix: String? = null
    @SerializedName("first_name")
    @Expose
    var firstName: String? = null
    @SerializedName("last_name")
    @Expose
    var lastName: String? = null
    @SerializedName("suffix")
    @Expose
    var suffix: Any? = null
    @SerializedName("phone")
    @Expose
    var phone: String? = null
    @SerializedName("cellphone")
    @Expose
    var cellphone: String? = null
    @SerializedName("email")
    @Expose
    var email: String? = null

}
