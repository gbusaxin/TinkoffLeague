package com.example.tinkoffleague.domain

import androidx.lifecycle.LiveData
import com.example.tinkoffleague.domain.pojo.TeamInfo

interface TeamRepository {

    fun getTeamInfoList():LiveData<List<TeamInfo>>

    fun getTeamInfo(teamName:String):LiveData<TeamInfo>

    suspend fun loadData()

}