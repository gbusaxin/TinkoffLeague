package com.example.tinkoffleague.domain.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "teams_list")
data class TeamItem (

    @PrimaryKey(autoGenerate = true)
    val id:Int,

    @SerializedName("name")
    @Expose
    val name: String? = null,

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

    @SerializedName("venueName")
    @Expose
    val venueName: String? = null,

    @SerializedName("venueCapacity")
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
    val captain: String? = null
)