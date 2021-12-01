package com.example.tinkoffleague.domain.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class TournamentInfo(

    val teamPosition: Int? = 0,

    val teamImage: String? = null,

    val teamName: String? = null,

    val n: Int? = 0,

    val b: Int? = 0,

    val h: Int? = 0,

    val p: Int? = 0,

    val zP: String? = null,

    val scores: Int? = 0
)