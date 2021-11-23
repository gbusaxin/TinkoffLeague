package com.example.tinkoffleague.domain.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PlayerItem(

    @SerializedName("imagePlayer")
    @Expose
    val imagePlayer: String? = null,

    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("position")
    @Expose
    val position: String? = null
)