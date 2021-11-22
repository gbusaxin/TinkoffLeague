package com.example.tinkoffleague.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tinkoffleague.domain.pojo.FixturesItem
import com.example.tinkoffleague.domain.pojo.PlayerItem
import com.example.tinkoffleague.domain.pojo.ResultItem
import com.example.tinkoffleague.domain.pojo.TeamItem

@Dao
interface TeamDbDao {

    @Query("SELECT * FROM teams_list")
    fun getTeamList():LiveData<List<TeamItem>>

    @Query("SELECT * FROM teams_list WHERE name == :teamName")
    fun getTeamInfo(teamName: String):LiveData<TeamItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTeamList(teamList:List<TeamItem>)


    @Query("SELECT * FROM fixtures_list")
    fun getFixturesList():LiveData<List<FixturesItem>>

    @Query("SELECT * FROM fixtures_list WHERE enemy == :fixturesEnemy")
    fun getFixturesInfo(fixturesEnemy: String):LiveData<FixturesItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFixturesList(fixturesList:List<FixturesItem>)


    @Query("SELECT * FROM players_list")
    fun getPlayersList():LiveData<List<PlayerItem>>

    @Query("SELECT * FROM players_list WHERE name == :playerName")
    fun getPlayersInfo(playerName: String):LiveData<PlayerItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlayersList(playersList:List<PlayerItem>)


    @Query("SELECT * FROM results_list")
    fun getResultsList():LiveData<List<ResultItem>>

    @Query("SELECT * FROM results_list WHERE enemy == :resultEnemy")
    fun getResultInfo(resultEnemy: String):LiveData<ResultItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertResultList(resultList:List<ResultItem>)


}