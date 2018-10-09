package com.example.sercanyusuf.boomsetdemo.data.model.attendee

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Transaction {

    @SerializedName("restype")
    @Expose
    var restype: Restype? = null
    @SerializedName("amount")
    @Expose
    var amount: String? = null
    @SerializedName("fee")
    @Expose
    var fee: String? = null
    @SerializedName("total")
    @Expose
    var total: String? = null

}
