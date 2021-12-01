package com.example.tinkoffleague.domain.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class FixturesInfo(

    val enemy: String? = null,

    val type: String? = null,

    val date: String? = null,

    val imageURL: String? = null
)