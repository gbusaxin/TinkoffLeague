package com.example.tinkoffleague.domain

import androidx.lifecycle.LiveData
import com.example.tinkoffleague.domain.pojo.TeamInfo
import com.example.tinkoffleague.domain.pojo.TournamentInfo

interface TeamRepository {

    fun getTeamInfoList():LiveData<List<TeamInfo>>

    fun getTeamInfo(teamName:String):LiveData<TeamInfo>

    fun getTournamentList():LiveData<List<TournamentInfo>>

    suspend fun loadData()

    suspend fun loadTournament()

}