package com.example.tinkoffleague.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tinkoffleague.data.database.model.TeamInfoDbModel

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


}