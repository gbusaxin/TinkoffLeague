package com.example.tinkoffleague.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.tinkoffleague.data.database.AppDatabase
import com.example.tinkoffleague.data.mapper.TeamMapper
import com.example.tinkoffleague.data.network.ApiFactory
import com.example.tinkoffleague.domain.TeamRepository
import com.example.tinkoffleague.domain.pojo.TeamInfo
import com.example.tinkoffleague.domain.pojo.TournamentInfo
import java.lang.Exception

class TeamRepositoryImpl(private val application: Application):TeamRepository {

    private val teamDbDao = AppDatabase.getInstance(application).teamDbDao()
    private val apiService = ApiFactory.apiService
    private val mapper = TeamMapper()

    override fun getTeamInfoList(): LiveData<List<TeamInfo>> {
        return Transformations.map(teamDbDao.getTeamList()){
            it.map { mapper.mapDbModelToEntity(it) }
        }
    }

    override fun getTeamInfo(teamName: String): LiveData<TeamInfo> {
        return Transformations.map(teamDbDao.getTeamInfo(teamName)){
            mapper.mapDbModelToEntity(it)
        }
    }

    override fun getTournamentList(): LiveData<List<TournamentInfo>> {
        return Transformations.map(teamDbDao.getTournamentList()){
            it.map { mapper.mapTournamentDbModelToEntity(it) }
        }
    }

    override suspend fun loadData() {
        try {
            val dataDto = apiService.getTeamFromJson()
            val dataDbModel = dataDto.map { mapper.mapDtoToDbModel(it) }
            teamDbDao.insertTeamList(dataDbModel)
        } catch (e: Exception){}
    }

    override suspend fun loadTournament(){
        try {
          val dataDto = apiService.getTournamentFromJson()
          val dataDbModel = dataDto.map { mapper.mapTournamentDtoToDbModel(it) }
          teamDbDao.insertTournamentList(dataDbModel)
        }catch (e:Exception){}
    }
}