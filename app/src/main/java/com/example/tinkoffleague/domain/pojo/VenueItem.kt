package com.example.tinkoffleague.domain.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class VenueItem (
    @SerializedName("name")
    @Expose
     val name: String? = null,

    @SerializedName("capacity")
    @Expose
     val capacity:Int = 0
)