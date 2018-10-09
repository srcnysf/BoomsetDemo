package com.example.sercanyusuf.boomsetdemo.data.model.attendee

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Contact {

    @SerializedName("prefix")
    @Expose
    var prefix: Any? = null
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
    var phone: Any? = null
    @SerializedName("cellphone")
    @Expose
    var cellphone: Any? = null
    @SerializedName("email")
    @Expose
    var email: Any? = null

}
