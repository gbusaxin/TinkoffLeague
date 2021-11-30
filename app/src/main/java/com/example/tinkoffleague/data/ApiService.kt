package com.example.tinkoffleague.data

import com.example.tinkoffleague.domain.pojo.TeamItem
import com.example.tinkoffleague.domain.pojo.TournamentItem
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("teams_list_info.json")
     fun getTeamFromJson(): Single<List<TeamItem>>

    @GET("league_table.json")
     fun getTournamentFromJson():Single<List<TournamentItem>>

}