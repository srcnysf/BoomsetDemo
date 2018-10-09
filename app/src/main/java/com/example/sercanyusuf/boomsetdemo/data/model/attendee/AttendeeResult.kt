package com.example.sercanyusuf.boomsetdemo.data.model.attendee

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AttendeeResult {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("contact")
    @Expose
    var contact: Contact? = null
    @SerializedName("work_info")
    @Expose
    var workInfo: WorkInfo? = null
    @SerializedName("answers")
    @Expose
    var answers: List<Answer>? = null
    @SerializedName("checkin_info")
    @Expose
    var checkinInfo: List<CheckinInfo>? = null
    @SerializedName("transaction")
    @Expose
    var transaction: Transaction? = null
    @SerializedName("quantity")
    @Expose
    var quantity: Int? = null
    @SerializedName("total")
    @Expose
    var total: String? = null
    @SerializedName("paid")
    @Expose
    var paid: Int? = null
    @SerializedName("created")
    @Expose
    var created: String? = null
    @SerializedName("modified")
    @Expose
    var modified: String? = null

}
