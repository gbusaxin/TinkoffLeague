package com.example.tinkoffleague.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.tinkoffleague.data.database.converters.DatabaseConverters
import com.example.tinkoffleague.domain.pojo.FixturesInfo
import com.example.tinkoffleague.domain.pojo.PlayerInfo
import com.example.tinkoffleague.domain.pojo.ResultInfo

@Entity(tableName = "teams_list")
@TypeConverters(DatabaseConverters::class)
data class TeamInfoDbModel(

    @PrimaryKey
    val name: String,
    val fullname: String? = null,
    val nicknames: String? = null,
    val founded: String? = null,
    val website: String? = null,
    val imageURL: String? = null,
    val smallImageURL: String? = null,
    val venueName: String? = null,
    val venueCapacity: Int? = 0,
    val gendir: String? = null,
    val trainer: String? = null,
    val captain: String? = null,
    val players: List<PlayerInfo>? = null,
    val results: List<ResultInfo>? = null,
    val fixtures: List<FixturesInfo>? = null

)