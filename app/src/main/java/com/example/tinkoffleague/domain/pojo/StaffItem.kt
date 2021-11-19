package com.example.tinkoffleague.domain.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class StaffItem (
    @SerializedName("gendir")
    @Expose
    val gendir: String? = null,

    @SerializedName("trainer")
    @Expose
    val trainer: String? = null,

    @SerializedName("captain")
    @Expose
    val captain: String? = null
)