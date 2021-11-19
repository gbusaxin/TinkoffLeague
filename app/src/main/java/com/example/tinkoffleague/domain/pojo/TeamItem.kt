package com.example.tinkoffleague.domain.pojo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Entity(tableName = "teams_list")
data class TeamItem (

    @SerializedName("name")
    @Expose
    val name: String? = null,

    @ColumnInfo
    @SerializedName("fullname")
    @Expose
    val fullname: String? = null,

    @ColumnInfo
    @SerializedName("nicknames")
    @Expose
    val nicknames: String? = null,

    @ColumnInfo
    @SerializedName("founded")
    @Expose
    val founded: String? = null,

    @ColumnInfo
    @SerializedName("website")
    @Expose
    val website: String? = null,

    @ColumnInfo
    @SerializedName("imageURL")
    @Expose
    val imageURL: String? = null,

    @ColumnInfo
    @SerializedName("smallImageURL")
    @Expose
    val smallImageURL: String? = null,

    @ColumnInfo
    @SerializedName("venue")
    @Expose
    val venue: VenueItem? = null,

    @ColumnInfo
    @SerializedName("staff")
    @Expose
    val staff: StaffItem? = null,

    @ColumnInfo
    @SerializedName("players")
    @Expose
    val players: List<PlayerItem>? = null,

    @ColumnInfo
    @SerializedName("results")
    @Expose
    val results: List<ResultItem>? = null,

    @ColumnInfo
    @SerializedName("fixtures")
    @Expose
    val fixtures: List<FixturesItem>? = null
)