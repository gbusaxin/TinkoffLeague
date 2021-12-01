package com.example.tinkoffleague.data.network

import com.example.tinkoffleague.data.network.model.TeamInfoDto
import com.example.tinkoffleague.data.network.model.TournamentInfoDto
import retrofit2.http.GET

interface ApiService {

    @GET("teams_list_info.json")
    suspend fun getTeamFromJson(): List<TeamInfoDto>

    @GET("league_table.json")
    suspend fun getTournamentFromJson():List<TournamentInfoDto>

}