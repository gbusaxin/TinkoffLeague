package com.example.tinkoffleague.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tournament_list")
data class TournamentInfoDbModel(

    @PrimaryKey
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
