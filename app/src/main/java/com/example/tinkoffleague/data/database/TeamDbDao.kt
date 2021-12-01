package com.example.tinkoffleague.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tinkoffleague.data.database.model.TeamInfoDbModel
import com.example.tinkoffleague.data.database.model.TournamentInfoDbModel

@Dao
interface TeamDbDao {

    @Query("SELECT * FROM teams_list")
    fun getTeamList(): LiveData<List<TeamInfoDbModel>>

    @Query("SELECT * FROM teams_list WHERE name == :teamName")
    fun getTeamInfo(teamName: String): LiveData<TeamInfoDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeamList(teamList: List<TeamInfoDbModel>)

    @Query("DELETE FROM teams_list")
    fun deleteData()

    @Query("SELECT * FROM tournament_list")
    fun getTournamentList(): LiveData<List<TournamentInfoDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTournamentList(tournamentList: List<TournamentInfoDbModel>)


}