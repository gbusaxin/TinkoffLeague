package com.example.tinkoffleague.data.network.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class TournamentInfoDto(

    @SerializedName("team_position")
    @Expose
    val teamPosition: Int? = 0,

    @SerializedName("team_image")
    @Expose
    val teamImage: String? = null,

    @SerializedName("team_name")
    @Expose
    val teamName: String? = null,

    @SerializedName("N")
    @Expose
    val n: Int? = 0,

    @SerializedName("B")
    @Expose
    val b: Int? = 0,

    @SerializedName("H")
    @Expose
    val h: Int? = 0,

    @SerializedName("P")
    @Expose
    val p: Int? = 0,

    @SerializedName("Z_P")
    @Expose
    val zP: String? = null,

    @SerializedName("scores")
    @Expose
    val scores: Int? = 0
)