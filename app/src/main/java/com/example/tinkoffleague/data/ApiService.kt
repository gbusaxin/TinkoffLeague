package com.example.tinkoffleague.data

import com.example.tinkoffleague.domain.pojo.TeamItem
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("teams_list_info.json")
    fun getTeamFromJson(): Single<List<TeamItem>>

}