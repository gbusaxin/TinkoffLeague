package com.example.tinkoffleague.data.network.model

import androidx.room.PrimaryKey
import com.example.tinkoffleague.domain.pojo.FixturesInfo
import com.example.tinkoffleague.domain.pojo.PlayerInfo
import com.example.tinkoffleague.domain.pojo.ResultInfo
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TeamInfoDto (

    @PrimaryKey
    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("fullname")
    @Expose
    val fullname: String? = null,

    @SerializedName("nicknames")
    @Expose
    val nicknames: String? = null,

    @SerializedName("founded")
    @Expose
    val founded: String? = null,

    @SerializedName("website")
    @Expose
    val website: String? = null,

    @SerializedName("imageURL")
    @Expose
    val imageURL: String? = null,

    @SerializedName("smallImageURL")
    @Expose
    val smallImageURL: String? = null,

    @SerializedName("venue_name")
    @Expose
    val venueName: String? = null,

    @SerializedName("venue_capacity")
    @Expose
    val venueCapacity:Int? = 0,

    @SerializedName("gendir")
    @Expose
    val gendir: String? = null,

    @SerializedName("trainer")
    @Expose
    val trainer: String? = null,

    @SerializedName("captain")
    @Expose
    val captain: String? = null,

    @SerializedName("players")
    @Expose
    val players: List<PlayerInfo>? = null,

    @SerializedName("results")
    @Expose
    val results: List<ResultInfo>? = null,

    @SerializedName("fixtures")
    @Expose
    val fixtures: List<FixturesInfo>? = null

    )