package com.example.tinkoffleague.data

import com.example.tinkoffleague.domain.pojo.TeamItem
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("2teams.json")
    fun getTeamFromJson(): Single<List<TeamItem>>

}