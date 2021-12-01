package com.example.tinkoffleague.domain.pojo

data class TeamInfo(

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
