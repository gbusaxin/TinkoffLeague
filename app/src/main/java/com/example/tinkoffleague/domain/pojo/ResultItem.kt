package com.example.tinkoffleague.domain.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResultItem(

    @SerializedName("enemy")
    @Expose
    val enemy: String? = null,

    @SerializedName("type")
    @Expose
    val type: String? = null,

    @SerializedName("result")
    @Expose
    val result: String? = null,

    @SerializedName("date")
    @Expose
    val date: String? = null,

    @SerializedName("status")
    @Expose
    val status: Int = 0,

    @SerializedName("imageURL")
    @Expose
    val imageURL: String? = null
)