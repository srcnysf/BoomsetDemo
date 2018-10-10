package com.example.sercanyusuf.boomsetdemo.data.model.attendee

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Answers {

    @SerializedName("answer")
    @Expose
    var answer: String? = null
    @SerializedName("option_id")
    @Expose
    var optionId: Int? = null
    @SerializedName("question")
    @Expose
    var question: String? = null
    @SerializedName("question_id")
    @Expose
    var questionId: Int? = null

}
