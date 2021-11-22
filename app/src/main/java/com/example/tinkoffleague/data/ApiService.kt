package com.example.tinkoffleague.data

import com.example.tinkoffleague.domain.pojo.FixturesItem
import com.example.tinkoffleague.domain.pojo.PlayerItem
import com.example.tinkoffleague.domain.pojo.ResultItem
import com.example.tinkoffleague.domain.pojo.TeamItem
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("team_info_list.json")
    fun getTeamFromJson(): Single<List<TeamItem>>

    @GET("result_info_list.json")
    fun getResultsFromJson():Single<List<ResultItem>>

    @GET("player_info_list.json")
    fun getPlayersFromJson():Single<List<PlayerItem>>

    @GET("fixtures_info_list.json")
    fun getFixturesFromJson():Single<List<FixturesItem>>

}